package ua.training.model.entity;

public class User {
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

  /*  //TODO remove this constructor
    public User(int id, String login, String password, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String login, String password, String email, String name, ROLE role, int age,
                int height, double weight, LIFE_ACTIVITY activity, int calorieNorm) {
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
    }*/

    public User(String login, String password, String email, String name, ROLE role, int age, int height,
                double weight, LIFE_ACTIVITY activity, int calorieNorm) {
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

