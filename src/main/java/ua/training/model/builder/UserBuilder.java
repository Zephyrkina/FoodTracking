package ua.training.model.builder;

import ua.training.model.entity.User;

public class UserBuilder {
    private int id;
    private String login;
    private String password;
    private String email;
    private String name;
    private User.ROLE role;
    private int age;
    private int height;
    private double weight;
    private User.LIFE_ACTIVITY activity;
    private int calorieNorm;

    public UserBuilder() {
    }

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setRole(User.ROLE role) {
        this.role = role;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setHeight(int height) {
        this.height = height;
        return this;

    }

    public UserBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public UserBuilder setActivity(User.LIFE_ACTIVITY activity) {
        this.activity = activity;
        return this;
    }

    public UserBuilder setCalorieNorm(int calorieNorm) {
        this.calorieNorm = calorieNorm;
        return this;
    }

    public User build(){
        return new User(id, login, password, email, name, role, age, height, weight, activity, calorieNorm);
    }
}
