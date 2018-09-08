package ua.training.model.entity;

import java.util.Objects;

public class User implements Cloneable{
    private int id;
    private String login;
    private String password;
    private String email;
    private String name;
    private ROLE role;
    private int age;
    private int height;
    private double weight;
    private LIFE_ACTIVITY activity;
    private int calorieNorm;

    //TODO overrride hash and equals??

    public enum LIFE_ACTIVITY  {
        LOW, NORMAL, HIGH
    }

    public enum ROLE {
        USER, ADMIN, GUEST
    }

    public User() {
    }

    public User(int id, String login, String password, String email, String name, ROLE role, int age, int height,
                double weight, LIFE_ACTIVITY activity, int calorieNorm) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.role = role;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
        this.calorieNorm = calorieNorm;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                height == user.height &&
                Double.compare(user.weight, weight) == 0 &&
                calorieNorm == user.calorieNorm &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                role == user.role &&
                activity == user.activity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, email, name, role, age, height, weight, activity, calorieNorm);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LIFE_ACTIVITY getActivity() {
        return activity;
    }

    public void setActivity(LIFE_ACTIVITY activity) {
        this.activity = activity;
    }

    public int getCalorieNorm() {
        return calorieNorm;
    }

    public void setCalorieNorm(int calorieNorm) {
        this.calorieNorm = calorieNorm;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", activity=" + activity +
                ", calorieNorm=" + calorieNorm +
                '}';
    }
}

