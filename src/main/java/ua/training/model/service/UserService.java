package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.Food;
import ua.training.model.entity.User;

import java.util.List;

public class UserService {
    private UserDao userDao;
    private FoodDao foodDao;

    public UserService() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.createUserDao();
        foodDao = daoFactory.createFoodDao();

    }

    public int calculateCalorieNorm(User user) {
        int calorieNorm = (int) (88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight()) - (5.7 * user.getAge()));
        return calorieNorm;
    }

    public void addFoodToRecord() {
    }

    public int addOwnFoodToDB(Food food, int userId) {
        return foodDao.createUsersFood(food, userId);
    }

    public Food findFoodByName(String foodName) {
        return foodDao.findByName(foodName);
    }

    public List<Food> showAllFood() {
        return foodDao.findAll();
    }

    public int getUserIdByLogin(String login) {
        return userDao.getUserIdByLogin(login);
    }
}
