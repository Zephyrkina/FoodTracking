package ua.training.model.entity.builder;

import ua.training.model.entity.Food;

public class FoodBuilder {
    private int id;
    private String name;
    private int calories;
    private int carbohydrates;
    private int fats;
    private int proteins;

    public FoodBuilder() {
    }

    public FoodBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public FoodBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FoodBuilder setCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public FoodBuilder setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public FoodBuilder setFats(int fats) {
        this.fats = fats;
        return this;
    }

    public FoodBuilder setProteins(int proteins) {
        this.proteins = proteins;
        return this;
    }
    public Food build() {
        return new Food(id, name, calories, carbohydrates, fats, proteins);
    }
}
