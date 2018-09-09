package ua.training.model.dao.mapper;

import ua.training.model.dto.FoodDTO;
import ua.training.model.builder.FoodDTOBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FoodDTOMapper implements ObjectMapper<FoodDTO> {

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
                .setQuantity(resultSet.getInt("quantity"))
                .build();

        return food;
    }

}
