package ua.training.model.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.builder.FoodBuilder;
import ua.training.model.builder.FoodDTOBuilder;
import ua.training.model.builder.UserBuilder;
import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.Food;
import ua.training.model.entity.User;
import ua.training.model.exception.ItemAlreadyExists;

import static org.junit.Assert.*;

public class FoodServiceTest {
    FoodService foodService;
    FoodDTO food;

    @Before
    public void init() {
        foodService = new FoodService();
        food = new FoodDTOBuilder()
                .setNameEn("carrot")
                .setNameUa("морква")
                .setCalories(33)
                .setCarbohydrates(3)
                .setFats(3)
                .setProteins(3)
                .build();
    }

    @Test(expected = ItemAlreadyExists.class)
    public void addOwnFoodToDB() {
        foodService.addOwnFoodToDB(food, 2);
    }
}