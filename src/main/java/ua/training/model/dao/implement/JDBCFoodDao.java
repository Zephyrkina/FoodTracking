package ua.training.model.dao.implement;

import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.dao.FoodDao;
import ua.training.model.dao.mapper.FoodMapper;
import ua.training.model.entity.Food;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCFoodDao implements FoodDao {
    private Connection connection;

    //TODO remove close() ?


    public JDBCFoodDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Food entity) {
        String sql = "insert into food (name_en, calories, carbs, fats, proteins, food_id)" +
                " values (?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getCalories());
            preparedStatement.setInt(3, entity.getCarbohydrates());
            preparedStatement.setInt(4, entity.getFats());
            preparedStatement.setInt(5, entity.getProteins());
            preparedStatement.setInt(6, entity.getId());

            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Food findById(int foodId) {
        String sql = "select * from food where food_id = ?";
        ResultSet resultSet;
        Food food = null;
        FoodMapper foodMapper = new FoodMapper();

        try (
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, foodId);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            food = foodMapper.extractFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    @Override
    public List<Food> findAll() {
        String sql = "select * from food";
        ResultSet resultSet;
        List<Food> foods = new ArrayList<>();
        FoodMapper foodMapper = new FoodMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Food food = foodMapper.extractFromResultSet(resultSet);
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    @Override
    public int delete(int foodId) {
        String sql = "delete from food where food_id = ?";
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
    public int update(Food entity) {
        String sql = "update food set name_en = ?, calories = ?, carbs = ?, fats = ?, proteins = ? where food_id = ?";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getCalories());
            preparedStatement.setInt(3, entity.getCarbohydrates());
            preparedStatement.setInt(4, entity.getFats());
            preparedStatement.setInt(5, entity.getProteins());
            preparedStatement.setInt(6, entity.getId());

            result =  preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Food findByName(String foodName) {
        String sql = "select * from food where name_en = ?";
        ResultSet resultSet;
        Food food = null;
        FoodMapper foodMapper = new FoodMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, foodName);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                food = foodMapper.extractFromResultSet(resultSet);
            } else {
                throw new ItemNotFoundException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }

    @Override
    public int createUsersFood(Food entity, int userId) {
        String sql = "insert into food (name_en, calories, carbs, fats, proteins, id, user_id)" +
                " values (?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getCalories());
            preparedStatement.setInt(3, entity.getCarbohydrates());
            preparedStatement.setInt(4, entity.getFats());
            preparedStatement.setInt(5, entity.getProteins());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.setInt(7, userId);

            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {

    }
}
