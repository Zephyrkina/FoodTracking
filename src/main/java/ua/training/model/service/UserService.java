package ua.training.model.service;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;
import ua.training.model.entity.User;
import ua.training.model.exception.ExceededCalorieNormException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public boolean userExists(String login, String password) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            return userDao.userExists(login, password);
        }
    }

    public User.ROLE getRoleByLoginPassword(String login, String password) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            return userDao.getRoleByLoginPassword(login, password);
        }
    }

    public int calculateCalorieNorm(int age, int height, double weight) {
        return (int) (88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age));
    }



    public int getUserIdByLogin(String login) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            return userDao.getUserIdByLogin(login);

        }

    }

    public void createUser(User user){
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.create(user);

        }
    }

    public void checkUniqueLoginEmail(String login, String email){

        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.checkUniqueLoginEmail(login, email);

        }

    }

    public void checkLoginExists(String login) {

        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.checkLoginExists(login);
        }

        }

    public void checkPasswordCorrect(String password) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.checkPasswordCorrect(password);

        }
    }

    public void getTotalCalories(int userId, LocalDate date) {
        int total_calories;
        int calorieNorm;
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            total_calories = dailyRecordDao.getTotalCalories(userId, date);
        }
        try (UserDao userDao = daoFactory.createUserDao()) {
            calorieNorm = userDao.findById(userId).getCalorieNorm();
        }
        int calorieExceeded = total_calories - calorieNorm;
        if (calorieExceeded > 0) {
            throw new ExceededCalorieNormException("Calorie norm was exceeded on " + calorieExceeded + " calories");
        }
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (UserDao dao = daoFactory.createUserDao()) {
            users =  dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
