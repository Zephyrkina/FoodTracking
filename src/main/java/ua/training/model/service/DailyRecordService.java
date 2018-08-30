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
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            if (dailyRecordDao.recordExists(userId)) {
                int dailyRecordId = dailyRecordDao.getRecordIdByUserId(userId);
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
        int consumedCalories = 0;
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()){

            int dailyRecordId = 0;
            if (!dailyRecordDao.recordExists(userId)) {
                dailyRecordDao.create(new DailyRecord(date, userId));
            }
            dailyRecordId = dailyRecordDao.getRecordIdByUserId(userId);
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


}
