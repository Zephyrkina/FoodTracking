package ua.training.model.dao.mapper;

import ua.training.model.entity.User;
import ua.training.model.entity.builder.UserBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new UserBuilder()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name_en"))
                .setLogin(resultSet.getString("login"))
                .setPassword(resultSet.getString("password"))
                .setEmail(resultSet.getString("email"))
                .setRole(User.ROLE.valueOf((resultSet.getString("role")).toUpperCase()))
                .setAge(resultSet.getInt("age"))
                .setHeight(resultSet.getInt("height"))
                .setWeight(resultSet.getDouble("weight"))
                .setActivity(User.LIFE_ACTIVITY.valueOf((resultSet.getString("activity")).toUpperCase()))
                .setCalorieNorm(resultSet.getInt("calorie_norm"))
                .build();
        return user;
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }

}
