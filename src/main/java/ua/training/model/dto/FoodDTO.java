package ua.training.model.dto;

import ua.training.model.entity.Food;
import ua.training.model.entity.builder.FoodBuilder;

import java.util.Locale;

public class FoodDTO {
    private int id;
    private String nameUa;
    private String nameEn;
    private int calories;
    private int carbohydrates;
    private int fats;
    private int proteins;
    private int quantity;

    public FoodDTO(int id, String nameUa, String nameEn, int calories, int carbohydrates, int fats, int proteins, int quantity) {
        this.id = id;
        this.nameUa = nameUa;
        this.nameEn = nameEn;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.proteins = proteins;
        this.quantity = quantity;
    }

    public Food convertToLocalizatedFood(Locale locale){
        String lang = locale.getLanguage();
        System.out.println("language in dto: " + lang);

        return new FoodBuilder()
                .setId(id)
                .setName(lang.equals("en") ? nameEn : nameUa)
                .setCalories(calories)
                .setCarbohydrates(carbohydrates)
                .setFats(fats)
                .setProteins(proteins)
                .setQuantity(quantity)
                .build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
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
        return "FoodDTO{" +
                "id=" + id +
                ", nameUa='" + nameUa + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", calories=" + calories +
                ", carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                ", proteins=" + proteins +
                ", quantity=" + quantity +
                '}';
    }
}
