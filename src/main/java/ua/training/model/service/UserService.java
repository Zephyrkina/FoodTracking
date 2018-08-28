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
import java.util.List;

public class UserService {
    private UserDao userDao;
    private FoodDao foodDao;
    private DailyRecordDao dailyRecordDao;

    //нужно ли писать отдельное дао под таблицу н к н

    public UserService() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.createUserDao();
        foodDao = daoFactory.createFoodDao();
        dailyRecordDao = daoFactory.createDailyRecordDao();

    }

    public int calculateCalorieNorm(int age, int height, double weight) {
        return (int) (88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age));
    }

    public void addFoodToDailyRecord(int foodId, int quantity, LocalDate date, int userId) {
        int dailyRecordId = 0;
        if(! dailyRecordDao.recordExists(userId)){
             dailyRecordDao.create(new DailyRecord(date, userId));
        }
        dailyRecordId = dailyRecordDao.getRecordIdByUserId(userId);
        dailyRecordDao.addFoodToRecord(dailyRecordId, foodId, quantity);
        int consumedCalories = dailyRecordDao.countCalories(dailyRecordId, userId);
        int calorieNorm = userDao.findById(userId).getCalorieNorm();
        if(consumedCalories > calorieNorm){
            throw new ExceededCalorieNormException();
        }


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

    public void saveRecordToFoodDiary(int userId) {
        if(dailyRecordDao.recordExists(userId)) {
            int dailyRecordId = dailyRecordDao.getRecordIdByUserId(userId);
            dailyRecordDao.saveRecordToFoodDiary(userId, dailyRecordId);
        }
    }

    public void createUser(User user){
        userDao.create(user);
    }

    public void checkUniqueLoginEmail(String login, String email){
        userDao.checkUniqueLoginEmail(login, email);

    }


}
