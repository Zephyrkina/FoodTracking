package ua.training.model.dao.mapper;

import java.sql.ResultSet;
import java.util.Map;

public interface ObjectMapper<T> {

    T extractFromResultSet(ResultSet resultSet);

    T makeUnique(Map<Integer, T> cache, T entity);
}
