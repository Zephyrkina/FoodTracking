package ua.training.model.dao.implement;

import ua.training.model.dao.mapper.FoodDTOLocaleMapper;
import ua.training.model.dao.mapper.FoodDTOMapper;
import ua.training.model.dto.FoodDTO;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.dao.FoodDao;
import ua.training.model.dao.mapper.FoodMapper;
import ua.training.model.entity.Food;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCFoodDao implements FoodDao {
    private Connection connection;

    //TODO remove close() ?


    public JDBCFoodDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(FoodDTO entity) {
        String sql = "insert into food (name_en, calories, carbs, fats, proteins, id, name_ua)" +
                " values (?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getNameEn());
            preparedStatement.setInt(2, entity.getCalories());
            preparedStatement.setInt(3, entity.getCarbohydrates());
            preparedStatement.setInt(4, entity.getFats());
            preparedStatement.setInt(5, entity.getProteins());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.setString(7, entity.getNameUa());


            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public FoodDTO findById(int foodId) {
        String sql = "select * from food where food_id = ?";
        ResultSet resultSet;
        FoodDTO food = null;
        FoodDTOMapper foodDTOMapper = new FoodDTOMapper();

        try (
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, foodId);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            food = foodDTOMapper.extractFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    @Override
    public List<FoodDTO> findAll() {
        String sql = "select * from food";
        ResultSet resultSet;
        List<FoodDTO> foods = new ArrayList<>();
        FoodDTOMapper foodDTOMapper = new FoodDTOMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                FoodDTO food = foodDTOMapper.extractFromResultSet(resultSet);
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    @Override
    public int delete(int foodId) {
        String sql = "delete from food where id = ?";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, foodId);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(FoodDTO entity) {
        String sql = "update food set name_en = ?, calories = ?, carbs = ?, fats = ?, proteins = ?, name_ua = ? where id = ?";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getNameEn());
            preparedStatement.setInt(2, entity.getCalories());
            preparedStatement.setInt(3, entity.getCarbohydrates());
            preparedStatement.setInt(4, entity.getFats());
            preparedStatement.setInt(5, entity.getProteins());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.setString(7, entity.getNameUa());


            result =  preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public FoodDTO findByName(String foodNameEn, String foodNameUa) {
        String sql = "select * from food where (name_en = ? or name_ua = ?) ";
        ResultSet resultSet;
        FoodDTO food = null;
        FoodDTOLocaleMapper foodDTOMapper = new FoodDTOLocaleMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, foodNameEn);
            preparedStatement.setString(2, foodNameUa);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                food = foodDTOMapper.extractFromResultSet(resultSet);
            } else {
                throw new ItemNotFoundException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    @Override
    public int createUsersFood(FoodDTO entity, int userId) {
        String sql = "insert into food (name_en, calories, carbs, fats, proteins, id, user_id, name_ua)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getNameEn());
            preparedStatement.setInt(2, entity.getCalories());
            preparedStatement.setInt(3, entity.getCarbohydrates());
            preparedStatement.setInt(4, entity.getFats());
            preparedStatement.setInt(5, entity.getProteins());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.setInt(7, userId);
            preparedStatement.setString(8, entity.getNameUa());

            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<FoodDTO> findAllFood(int currentPage, int recordsPerPage) {
        String sql = "select * from food limit ?, ?";
        int start = currentPage * recordsPerPage - recordsPerPage;
        List<FoodDTO> foods = new ArrayList<>();
        FoodDTOLocaleMapper foodDTOMapper = new FoodDTOLocaleMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, recordsPerPage);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    FoodDTO food = foodDTOMapper.extractFromResultSet(resultSet);
                    foods.add(food);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    @Override
    public int numberOfRows() {

        String sql = "SELECT count(id) FROM food";
        int numOfRows = 0;
        try (Statement statement = connection.createStatement()){

            try (ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                numOfRows = resultSet.getInt("count(id)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numOfRows;
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
