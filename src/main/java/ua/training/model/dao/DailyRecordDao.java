package ua.training.model.dao;

import ua.training.model.entity.DailyRecord;

import java.time.LocalDate;

public interface DailyRecordDao extends GenericDao<DailyRecord> {

    boolean recordExists(LocalDate date, int userId);
    int addFoodToRecord(int dailyRecordId, int foodId, int quantity);
}
