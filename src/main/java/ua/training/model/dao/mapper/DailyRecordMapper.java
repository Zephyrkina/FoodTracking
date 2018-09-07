package ua.training.model.dao.mapper;

import ua.training.model.entity.DailyRecord;
import ua.training.model.builder.DailyRecordBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
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

        return dailyRecord;
    }

    @Override
    public DailyRecord makeUnique(Map<Integer, DailyRecord> cache, DailyRecord record) {
        cache.putIfAbsent(record.getId(), record);
        return cache.get(record.getId());
    }
}
