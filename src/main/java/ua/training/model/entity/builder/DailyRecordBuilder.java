package ua.training.model.entity.builder;

import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DailyRecordBuilder {
    int id;
    LocalDate date;
    int userId;
    int totalCalories;
    Map<Food, Integer> consumedFood = new HashMap<>();

    public DailyRecordBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DailyRecordBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public DailyRecordBuilder setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public DailyRecordBuilder setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
        return this;
    }

    public DailyRecordBuilder setConsumedFood(Map<Food, Integer> consumedFood) {
        this.consumedFood = consumedFood;
        return this;
    }

    public DailyRecord build() {
        return new DailyRecord(id, date, userId, totalCalories, consumedFood);
    }
}
