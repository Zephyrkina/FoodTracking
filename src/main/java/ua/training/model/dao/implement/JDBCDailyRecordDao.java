package ua.training.model.dao.implement;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.mapper.DailyRecordMapper;
import ua.training.model.dao.mapper.FoodMapper;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;
import ua.training.model.exception.FoodListIsEmptyException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDailyRecordDao implements DailyRecordDao {
    private Connection connection;

    //TODO add mapper

    //TODO made user_id in daily record unique


    public JDBCDailyRecordDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean todaysDailyRecordExists(int userId, LocalDate date) {
        String sql = "select * from daily_record where user_id = ? and date = ?";
        ResultSet resultSet;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);
            preparedStatement.setDate(2, Date.valueOf(date));

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int addFoodToRecord(int dailyRecordId, int foodId, int userQuantity) {
        String sql = "insert into daily_record_has_food (daily_record_id, food_id, quantity)  values (?, ?, ?)  " +
                "ON DUPLICATE key UPDATE quantity = quantity + ?";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, dailyRecordId);
            preparedStatement.setInt(2, foodId);
            preparedStatement.setInt(3, userQuantity);
            preparedStatement.setInt(4, userQuantity);
            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getRecordIdByUserIdAndDate(int userId, LocalDate date) {
        String sql = "select id from daily_record where  user_id = ? and date = ? ";
        int record_id = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);
            preparedStatement.setDate(2, Date.valueOf(date));

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                record_id = resultSet.getInt("id");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record_id;
    }

    @Override
    public boolean savePreviousRecords(int userId, int dailyRecordId) {


        Map<Integer, DailyRecord> dailyRecordMap = new HashMap<>();
        DailyRecord dailyRecord = null;

       /* List<DailyRecord> dailyRecordList = new ArrayList<>();


        String sql1 = "SELECT * FROM daily_record " +
                "RIGHT JOIN daily_record_has_food ON daily_record.id = daily_record_has_food.daily_record_id " +
                " left join food on  food.id = daily_record_has_food.food_id where daily_record.user_id = ? and not daily_record.id = ?";
*/

        String sql1 = "SELECT * FROM daily_record " +
                "RIGHT JOIN daily_record_has_food ON daily_record.id = daily_record_has_food.daily_record_id " +
                " left join food on  food.id = daily_record_has_food.food_id where daily_record.user_id = ?";

        String sql2 = "insert into food_diary (date, total_calories, user_id) values (?, ?, ?)";
        String sql3 = "SELECT LAST_INSERT_ID() as last_id from food_diary";
        String sql4 = "insert into record (name_en, quantity, calories, carbs, proteins, fats, diary_id) values (?, ?, ?, ?, ?, ?, ?)";
        String sql5 = "delete from daily_record where id = ?";
        int record_id = 0;

        //TODO extract anything possible in methods

        try (PreparedStatement getAllStatement = connection.prepareStatement(sql1);
             PreparedStatement createFoodDiaryDayRecordStatement = connection.prepareStatement(sql2);
             PreparedStatement getIdStatement = connection.prepareStatement(sql3);
             PreparedStatement createPermanentRecordStatement = connection.prepareStatement(sql4);
             PreparedStatement deleteTemporaryRecordStatement = connection.prepareStatement(sql5)){

            connection.setAutoCommit(false);

            DailyRecordMapper dailyRecordMapper = new DailyRecordMapper();
            FoodMapper foodMapper = new FoodMapper();

//-----------------------first query----------------------------------------------------------

            getAllStatement.setInt(1, userId);
            ResultSet resultSet = getAllStatement.executeQuery();

            while(resultSet.next()) {
                dailyRecord = dailyRecordMapper.extractFromResultSet(resultSet);
                Food food = foodMapper.extractFromResultSet(resultSet);
                int quantity = resultSet.getInt("quantity");
                dailyRecord = dailyRecordMapper.makeUnique(dailyRecordMap, dailyRecord);
                dailyRecord.getConsumedFood().put(food, quantity);

            }
//-----------------------second query----------------------------------------------------------

            createFoodDiaryDayRecordStatement.setDate(1, Date.valueOf(dailyRecord.getDate()));
            createFoodDiaryDayRecordStatement.setInt(2, dailyRecord.getTotalCalories());
            createFoodDiaryDayRecordStatement.setInt(3, userId);

            createFoodDiaryDayRecordStatement.executeUpdate();

//-----------------------third query----------------------------------------------------------

            resultSet = getIdStatement.executeQuery();


            int newDiaryId = 0;


            if (resultSet.next()) {
                newDiaryId = Integer.parseInt(resultSet.getString("last_id"));
            } else {
                throw new RuntimeException("problems with id");
            }
//-----------------------fourth query----------------------------------------------------------

            for(Map.Entry<Food, Integer> foodQuantityMap : dailyRecord.getConsumedFood().entrySet()) {
                createPermanentRecordStatement.setString(1, foodQuantityMap.getKey().getName());
                createPermanentRecordStatement.setInt(2, foodQuantityMap.getValue());
                createPermanentRecordStatement.setInt(3, foodQuantityMap.getKey().getCalories());
                createPermanentRecordStatement.setInt(4, foodQuantityMap.getKey().getCarbohydrates());
                createPermanentRecordStatement.setInt(5, foodQuantityMap.getKey().getProteins());
                createPermanentRecordStatement.setInt(6, foodQuantityMap.getKey().getFats());
                createPermanentRecordStatement.setInt(7, newDiaryId);

                createPermanentRecordStatement.addBatch();
            }

            createPermanentRecordStatement.executeBatch();

//-----------------------fifth query----------------------------------------------------------


            deleteTemporaryRecordStatement.setInt(1, dailyRecordId);
            deleteTemporaryRecordStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }



        return true;
    }

    @Override
    public int countCalories(int dailyRecordId, int userId) {
        String sql1 = "SELECT * FROM daily_record " +
                "RIGHT JOIN daily_record_has_food ON daily_record.id = daily_record_has_food.daily_record_id " +
                " left join food on  food.id = daily_record_has_food.food_id where daily_record.user_id = ?";
        String sql2 = "update daily_record set total_calories = ? where id = ?";
        int total_calories = 0;

        try (PreparedStatement getAllStatement = connection.prepareStatement(sql1);
             PreparedStatement updateCaloriesStatement = connection.prepareStatement(sql2)){

            connection.setAutoCommit(false);

            getAllStatement.setInt(1, userId);
            ResultSet resultSet = getAllStatement.executeQuery();

            while(resultSet.next()) {
                int quantity = resultSet.getInt("quantity");
                int calories = resultSet.getInt("calories");

                total_calories = total_calories + (int)((double)quantity * (double)calories * 0.01);
            }
            updateCaloriesStatement.setInt(1, total_calories);
            updateCaloriesStatement.setInt(2, dailyRecordId);
            updateCaloriesStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return total_calories;

    }

    @Override
    public List<Food> showTodaysFoodList(int userId, LocalDate userDate) {
        String sql1 = "SELECT * FROM daily_record " +
                "RIGHT JOIN daily_record_has_food ON daily_record.id = daily_record_has_food.daily_record_id " +
                " left join food on  food.id = daily_record_has_food.food_id where daily_record.user_id = ? and daily_record.date = ? ";

        List<Food> foodList = new ArrayList<>();
        FoodMapper foodMapper = new FoodMapper();

        try (PreparedStatement getAllStatement = connection.prepareStatement(sql1)){
            getAllStatement.setInt(1, userId);
            getAllStatement.setDate(2, Date.valueOf(userDate));

            ResultSet resultSet = getAllStatement.executeQuery();

            if( !resultSet.next()){
                throw new FoodListIsEmptyException("Today's food list is empty.");
            }
            resultSet.previous();

            while(resultSet.next()) {
                Food food = foodMapper.extractFromResultSet(resultSet);
                foodList.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foodList;
    }

    @Override
    public int getTotalCalories(int userId, LocalDate date) {
        String sql1 = "SELECT total_calories FROM daily_record  where user_id = ? and date = ?";

        int total_calories = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)){
            preparedStatement.setInt(1, userId);
            preparedStatement.setDate(2, Date.valueOf(date));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    total_calories = resultSet.getInt("total_calories");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total_calories;
    }

    @Override
    public int create(DailyRecord entity) {
        String sql = "insert into daily_record (date, user_id)  values (?, ?)";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, Date.valueOf(entity.getDate()));
            preparedStatement.setInt(2, entity.getUserId());

            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public DailyRecord findById(int id) {
        return null;
    }

    @Override
    public List<DailyRecord> findAll() {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(DailyRecord entity) {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
