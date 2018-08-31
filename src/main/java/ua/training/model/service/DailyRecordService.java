package ua.training.model.service;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;
import ua.training.model.exception.ExceededCalorieNormException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DailyRecordService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    //TODO savePreviousRecords(userId, date);
    public void savePreviousRecords(int userId, LocalDate date) {
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            if (dailyRecordDao.todaysDailyRecordExists(userId, date)) {
                int dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId, date);
                dailyRecordDao.savePreviousRecords(userId, dailyRecordId);
            }
        }
    }

    public List<Food> showTodaysFoodList(int userId, LocalDate date) {
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            return dailyRecordDao.showTodaysFoodList(userId, date);
        }
    }

    public void addFoodToDailyRecord(int foodId, int quantity, LocalDate date, int userId) {
        int dailyRecordId = 0;

        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()){
            if (!dailyRecordDao.todaysDailyRecordExists(userId, date)) {
                dailyRecordDao.create(new DailyRecord(date, userId));
                System.out.println("crating new food");
            }
            dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId, date);
            System.out.println("dailyRecordId: " + dailyRecordId);
            dailyRecordDao.addFoodToRecord(dailyRecordId, foodId, quantity);
            dailyRecordDao.countCalories(dailyRecordId, userId, date);

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


}
