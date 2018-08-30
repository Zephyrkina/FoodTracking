package ua.training.model.dao.mapper;

import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.Food;
import ua.training.model.entity.builder.DailyRecordBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class DailyRecordMapper implements ObjectMapper<DailyRecord> {

    @Override
    public DailyRecord extractFromResultSet(ResultSet resultSet) throws SQLException {

        DailyRecord dailyRecord = new DailyRecordBuilder()
                .setId(resultSet.getInt("id"))
                .setDate(resultSet.getDate("date").toLocalDate())
                .setUserId(resultSet.getInt("user_id"))
                .setTotalCalories(resultSet.getInt("total_calories"))
                .build();

        Food food = new FoodMapper().extractFromResultSet(resultSet);
        int quantity = resultSet.getInt("quanity");
        dailyRecord.getConsumedFood().put(food, quantity);

        return dailyRecord;
    }

    @Override
    public DailyRecord makeUnique(Map<Integer, DailyRecord> cache, DailyRecord record) {
        cache.putIfAbsent(record.getId(), record);
        return cache.get(record.getId());
    }
}
