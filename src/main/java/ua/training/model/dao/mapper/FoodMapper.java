package ua.training.model.dao.mapper;

import ua.training.model.entity.Food;
import ua.training.model.entity.builder.FoodBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FoodMapper implements ObjectMapper<Food> {
    @Override
    public Food extractFromResultSet(ResultSet resultSet) throws SQLException {
        Food food = new FoodBuilder()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name_en"))
                .setCalories(resultSet.getInt("calories"))
                .setCarbohydrates(resultSet.getInt("carbs"))
                .setFats(resultSet.getInt("fats"))
                .setProteins(resultSet.getInt("proteins"))
                .build();

        return food;
    }

    @Override
    public Food makeUnique(Map<Integer, Food> cache, Food food) {
        cache.putIfAbsent(food.getId(), food);
        return cache.get(food.getId());

    }

}
