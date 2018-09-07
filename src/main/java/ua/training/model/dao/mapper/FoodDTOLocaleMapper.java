package ua.training.model.dao.mapper;

import ua.training.model.dto.FoodDTO;
import ua.training.model.builder.FoodDTOBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FoodDTOLocaleMapper implements ObjectMapper<FoodDTO> {
    @Override
    public FoodDTO extractFromResultSet(ResultSet resultSet) throws SQLException {
        FoodDTO food = new FoodDTOBuilder()
                .setId(resultSet.getInt("id"))
                .setNameEn(resultSet.getString("name_en"))
                .setNameUa(resultSet.getString("name_ua"))
                .setCalories(resultSet.getInt("calories"))
                .setCarbohydrates(resultSet.getInt("carbs"))
                .setFats(resultSet.getInt("fats"))
                .setProteins(resultSet.getInt("proteins"))
                .build();

        return food;
    }

    @Override
    public FoodDTO makeUnique(Map<Integer, FoodDTO> cache, FoodDTO food) {
        cache.putIfAbsent(food.getId(), food);
        return cache.get(food.getId());    }
}
