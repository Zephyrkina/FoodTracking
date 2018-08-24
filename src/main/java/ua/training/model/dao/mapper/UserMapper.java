package ua.training.model.dao.mapper;

import ua.training.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name_en"));
        user.setRole(User.ROLE.valueOf((resultSet.getString("role")).toUpperCase()));
        user.setAge(resultSet.getInt("age"));
        user.setHeight(resultSet.getInt("height"));
        user.setWeight(resultSet.getDouble("weight"));
        user.setActivity(User.LIFE_ACTIVITY.valueOf((resultSet.getString("activity")).toUpperCase()));
        user.setCalorieNorm(resultSet.getInt("calorie_norm"));
        return user;
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User entity) {
        return null;
    }
}
