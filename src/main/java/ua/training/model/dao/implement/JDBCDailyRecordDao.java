package ua.training.model.dao.implement;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCDailyRecordDao implements DailyRecordDao {
    private DataSource dataSource;

    //TODO remove close() ?

    //TODO autocount total calories after food adding


    public JDBCDailyRecordDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean recordExists(LocalDate requiredDate, int userId) {
        String sql = "select * from daily_record where date = ? and user_id = ?";
        ResultSet resultSet;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setDate(1, Date.valueOf(requiredDate));
            preparedStatement.setInt(2, userId);

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
        String sql = "insert into daily_record_has_food (daily_record_id, food_id, quantity)  values (?, ?, ?)";
        int result = 0;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, dailyRecordId);
            preparedStatement.setInt(2, foodId);
            preparedStatement.setInt(3, userQuantity);

            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int create(DailyRecord entity) {
        String sql = "insert into daily_record (date, user_id)  values (?, ?)";
        int result = 0;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
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
    public void close() throws Exception {

    }
}
