package ua.training.model.entity;

import java.time.LocalDate;
import java.util.*;

public class DailyRecord {
    int id;
    LocalDate date;
    int userId;
    int totalCalories;
    Map<Food, Integer> consumedFood = new HashMap<>();


    public DailyRecord() {
    }

    public DailyRecord(LocalDate date, int userId) {
        this.date = date;
        this.userId = userId;
    }

    public DailyRecord(int id, LocalDate date, int userId, int totalCalories, Map<Food, Integer> consumedFood) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.totalCalories = totalCalories;
        this.consumedFood = consumedFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyRecord that = (DailyRecord) o;
        return id == that.id &&
                userId == that.userId &&
                totalCalories == that.totalCalories &&
                Objects.equals(date, that.date) &&
                Objects.equals(consumedFood, that.consumedFood);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, userId, totalCalories, consumedFood);
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

    public Map<Food, Integer> getConsumedFood() {
        return consumedFood;
    }

    public void setConsumedFood(Map<Food, Integer> consumedFood) {
        this.consumedFood = consumedFood;
    }

    @Override
    public String toString() {
        return "DailyRecord{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", totalCalories=" + totalCalories +
                ", consumedFood=" + consumedFood +
                '}';
    }
}
