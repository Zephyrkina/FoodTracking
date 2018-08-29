package ua.training.model.dao;

import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;

import java.time.LocalDate;
import java.util.List;

public interface DailyRecordDao extends GenericDao<DailyRecord> {

    boolean recordExists(int userId);
    int addFoodToRecord(int dailyRecordId, int foodId, int quantity);
    int getRecordIdByUserId(int userId);
    boolean savePreviousRecords(int userId, int dailyRecordId);
    int countCalories(int dailyRecordId, int userId);
    List<Food> showTodaysFoodList(int userId, LocalDate date);
    int getTotalCalories(int userId, LocalDate date);
}
