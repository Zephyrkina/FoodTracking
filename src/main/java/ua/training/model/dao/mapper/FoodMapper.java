package ua.training.model.dao.mapper;

import ua.training.model.entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FoodMapper implements ObjectMapper<Food> {
    @Override
    public Food extractFromResultSet(ResultSet resultSet) throws SQLException {
        Food food = new Food();
        food.setId(resultSet.getInt("id"));
        food.setName(resultSet.getString("name_en"));
        food.setCalories(resultSet.getInt("calories"));
        food.setCarbohydrates(resultSet.getInt("carbs"));
        food.setFats(resultSet.getInt("fats"));
        food.setProteins(resultSet.getInt("proteins"));

        return food;
    }

    @Override
    public Food makeUnique(Map<Integer, Food> cache, Food food) {
        cache.putIfAbsent(food.getId(), food);
        return cache.get(food.getId());

    }

}
