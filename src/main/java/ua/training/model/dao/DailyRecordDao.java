package ua.training.model.dao;

import ua.training.model.entity.DailyRecord;

public interface DailyRecordDao extends GenericDao<DailyRecord> {

    boolean recordExists(int userId);
    int addFoodToRecord(int dailyRecordId, int foodId, int quantity);
    int getRecordIdByUserId(int userId);
    boolean saveRecordToFoodDiary(int userId, int dailyRecordId);
    int countCalories(int dailyRecordId, int userId);
}
