package ua.training.model.dao.mapper;

import ua.training.model.entity.DailyRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class DailyRecordMapper implements ObjectMapper<DailyRecord> {

    @Override
    public DailyRecord extractFromResultSet(ResultSet resultSet) throws SQLException {
        DailyRecord dailyRecord = new DailyRecord();
        dailyRecord.setId(resultSet.getInt("id"));
        dailyRecord.setDate(resultSet.getDate("date").toLocalDate());
        dailyRecord.setTotalCalories(resultSet.getInt("total_calories"));
        dailyRecord.setUserId(resultSet.getInt("user_id"));

        return dailyRecord;
    }

    @Override
    public DailyRecord makeUnique(Map<Integer, DailyRecord> cache, DailyRecord record) {
        cache.putIfAbsent(record.getId(), record);
        return cache.get(record.getId());
    }
}
