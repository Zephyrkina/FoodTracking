package ua.training.model.entity.builder;

import ua.training.model.dto.FoodDTO;

public class FoodDTOBuilder {
    private int id;
    private String nameEn;
    private String nameUa;
    private int calories;
    private int carbohydrates;
    private int fats;
    private int proteins;
    private int quantity;

    public FoodDTOBuilder() {
    }

    public FoodDTOBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public FoodDTOBuilder setNameEn(String nameEn) {
        this.nameEn = nameEn;
        return this;
    }

    public FoodDTOBuilder setNameUa(String nameUa) {
        this.nameUa = nameUa;
        return this;
    }


    public FoodDTOBuilder setCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public FoodDTOBuilder setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public FoodDTOBuilder setFats(int fats) {
        this.fats = fats;
        return this;
    }

    public FoodDTOBuilder setProteins(int proteins) {
        this.proteins = proteins;
        return this;
    }
    public FoodDTOBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public FoodDTO build() {
        return new FoodDTO(id, nameUa, nameEn, calories, carbohydrates, fats, proteins, quantity);
    }
}
