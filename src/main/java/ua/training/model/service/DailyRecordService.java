package ua.training.model.service;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;
import ua.training.model.exception.ExceededCalorieNormException;

import java.time.LocalDate;
import java.util.List;

public class DailyRecordService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void savePreviousRecords(int userId) {
       /* try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            if (dailyRecordDao.todaysDailyRecordExists(userId, )) {
                int dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId);
                dailyRecordDao.savePreviousRecords(userId, dailyRecordId);
            }
        }*/
    }

    public List<Food> showTodaysFoodList(int userId, LocalDate date) {
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            return dailyRecordDao.showTodaysFoodList(userId, date);
        }
    }

    public void addFoodToDailyRecord(int foodId, int quantity, LocalDate date, int userId) {
        int consumedCalories = 0;
        int dailyRecordId = 0;

        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()){
            if (!dailyRecordDao.todaysDailyRecordExists(userId, date)) {
                dailyRecordDao.create(new DailyRecord(date, userId));
                System.out.println("crating new food");
            }
            dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId, date);
            System.out.println("dailyRecordId: " + dailyRecordId);
            dailyRecordDao.addFoodToRecord(dailyRecordId, foodId, quantity);
            consumedCalories = dailyRecordDao.countCalories(dailyRecordId, userId);

        }
        try (UserDao userDao = daoFactory.createUserDao()) {
            int calorieNorm = userDao.findById(userId).getCalorieNorm();
            int calorieExceeded = consumedCalories - calorieNorm;
            if (calorieExceeded > 0) {
                throw new ExceededCalorieNormException("Calorie norm was exceeded on " + calorieExceeded + " calories");
            }
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
        System.out.println("int get total calories + date: " + date);
        int calorieExceeded = total_calories - calorieNorm;
        if (calorieExceeded > 0) {
            throw new ExceededCalorieNormException("Calorie norm was exceeded on " + calorieExceeded + " calories");
        }
    }


}
