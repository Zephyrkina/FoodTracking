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
    public int getCalorieNorm(int userId) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            return userDao.getCalorieNorm(userId);

        }

    }

    public void createUser(User user){
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.create(user);

        }
    }

    public void deleteUser(User user){
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.delete(user.getId());

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

    public void checkPasswordCorrect(String login, String password) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.checkPasswordCorrect(login, password);

        }
    }


    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (UserDao dao = daoFactory.createUserDao()) {
            users = dao.findAll();
        }
        return users;
    }

    public User findUserById(int userId) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            return userDao.findById(userId);
        }
    }

}
