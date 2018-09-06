package ua.training.model.dao;

import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;

import java.time.LocalDate;
import java.util.List;

public interface DailyRecordDao extends GenericDao<DailyRecord> {

    boolean todaysDailyRecordExists(int userId, LocalDate date);
    int addFoodToRecord(int dailyRecordId, int foodId, int quantity);
    int getRecordIdByUserIdAndDate(int userId, LocalDate date);
    boolean savePreviousRecords(int userId, int dailyRecordId);
    int countCalories(int dailyRecordId, int userId, LocalDate date);
    List<FoodDTO> showTodaysFoodList(int userId, LocalDate date);
    int getTotalCalories(int userId, LocalDate date);
}
