package ua.training.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyRecord {
    int id;
    LocalDate date;
    int userId;
    int totalCalories;
    List<Food> foodList = new ArrayList<>();


    public DailyRecord() {
    }

    public DailyRecord(LocalDate date, int userId) {
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
