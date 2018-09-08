package ua.training.model.entity;

import java.util.Objects;

public class Food {
    private int id;
    private String name;
    private int calories;
    private int carbohydrates;
    private int fats;
    private int proteins;
    private int quantity;

    public Food() {
    }

    public Food(int id, String name, int calories, int carbohydrates, int fats, int proteins, int quantity) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.proteins = proteins;
        this.quantity = quantity;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id &&
                calories == food.calories &&
                carbohydrates == food.carbohydrates &&
                fats == food.fats &&
                proteins == food.proteins &&
                quantity == food.quantity &&
                Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, calories, carbohydrates, fats, proteins, quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                ", proteins=" + proteins +
                '}';
    }
}
