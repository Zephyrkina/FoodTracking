package ua.training.model.service;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;
import ua.training.model.exception.ExceededCalorieNormException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DailyRecordService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public void savePreviousRecords(int userId, LocalDate date) {
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            int dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId, date);
            dailyRecordDao.savePreviousRecords(userId, dailyRecordId);

        }
    }

    public List<FoodDTO> showTodaysFoodList(int userId, LocalDate date) {
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            return dailyRecordDao.showTodaysFoodList(userId, date);
        }
    }

    public void addFoodToDailyRecord(int foodId, int quantity, LocalDate date, int userId) {
        int dailyRecordId = 0;

        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()){
            if (!dailyRecordDao.todaysDailyRecordExists(userId, date)) {
                dailyRecordDao.create(new DailyRecord(date, userId));
            }
            dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId, date);
            dailyRecordDao.addFoodToRecord(dailyRecordId, foodId, quantity);
            dailyRecordDao.countCalories(dailyRecordId, userId, date);

        }
    }

    public int getTotalCalories(int userId, LocalDate date) {
        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            return  dailyRecordDao.getTotalCalories(userId, date);
        }
    }


}
