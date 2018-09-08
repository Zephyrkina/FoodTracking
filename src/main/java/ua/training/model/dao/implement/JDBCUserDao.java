package ua.training.model.dao.implement;

import ua.training.model.dao.UserDao;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.User;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.exception.NotUniqueEmailException;
import ua.training.model.exception.NotUniqueLoginException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDao implements UserDao {
    private Connection connection;

    //TODO add resultset in try-with-res

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(User entity) {
        String sql = "insert into user (login, password, email, name_en, role, age, height, weight, activity, calorie_norm)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getName());
            preparedStatement.setString(5, entity.getRole().toString());
            preparedStatement.setInt(6, entity.getAge());
            preparedStatement.setInt(7, entity.getHeight());
            preparedStatement.setDouble(8, entity.getWeight());
            preparedStatement.setString(9, entity.getActivity().toString());
            preparedStatement.setInt(10, entity.getCalorieNorm());

            result =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public User findById(int userId) {
        String sql = "select * from `user` where id = ?";
        ResultSet resultSet;
        User user = null;
        UserMapper userMapper = new UserMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            user = userMapper.extractFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from `user`";
        ResultSet resultSet;
        List<User> users = new ArrayList<>();
        UserMapper userMapper = new UserMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int delete(int userId) {
        String sql = "delete from `user` where id = ?";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(User entity) {
        String sql = "update `user` set login = ?, password = ?, email = ?, name_en = ?, role = ?, age = ?," +
                "height = ?, weight = ?, activity = ?, calorie_norm = ? where id = ?";
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getName());
            preparedStatement.setString(5, entity.getRole().toString());
            preparedStatement.setInt(6, entity.getAge());
            preparedStatement.setInt(7, entity.getHeight());
            preparedStatement.setDouble(8, entity.getWeight());
            preparedStatement.setString(9, entity.getActivity().toString());
            preparedStatement.setInt(10, entity.getCalorieNorm());
            preparedStatement.setInt(11, entity.getId());

            result =  preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean userExists(String userLogin, String userPassword) {
        String sql = "select * from `user` where login = ? and password = ?";
        ResultSet resultSet;
        List<User> users = new ArrayList<>();
        UserMapper userMapper = new UserMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, userPassword);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                users.add(user);
            }
            if( ! users.isEmpty()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User.ROLE getRoleByLoginPassword(String userLogin, String userPassword) {
        String sql = "select role from `user` where login = ? and password = ?";
        User.ROLE role = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, userPassword);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                role = User.ROLE.valueOf((resultSet.getString("role")).toUpperCase());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public int getUserIdByLogin(String userLogin) {
        String sql = "select id from `user` where login = ?";

        int userId = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, userLogin);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                userId = resultSet.getInt("id");
                } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    //TODO  try to remove many try
    @Override
    public void checkUniqueLoginEmail(String userLogin, String email) {
        String sql1 = "select * from `user` where login = ?";
        String sql2 = "select * from `user` where email = ?";

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)){

            preparedStatement1.setString(1, userLogin);

            try ( ResultSet resultSet = preparedStatement1.executeQuery()) {
                if( resultSet.next()){
                    throw new NotUniqueLoginException();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try ( ResultSet resultSet = preparedStatement2.executeQuery()) {
                if(resultSet.next()){
                    throw new NotUniqueEmailException();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkLoginExists(String userLogin) {
        String sql1 = "select * from `user` where login = ?";

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1))
        {
            preparedStatement1.setString(1, userLogin);
            try ( ResultSet resultSet = preparedStatement1.executeQuery()) {
                if(! resultSet.next()){
                    throw new ItemNotFoundException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkPasswordCorrect(String userPassword) {
        String sql1 = "select * from `user` where password = ?";

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1))
        {
            preparedStatement1.setString(1, userPassword);
            try ( ResultSet resultSet = preparedStatement1.executeQuery()) {
                if(! resultSet.next()){
                    throw new ItemNotFoundException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCalorieNorm(int userId) {
        String sql1 = "select calorie_norm from `user` where id = ?";
        int calorie_norm = 0;

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql1))
        {
            preparedStatement1.setInt(1, userId);
            try ( ResultSet resultSet = preparedStatement1.executeQuery()) {
                resultSet.next();
                calorie_norm = resultSet.getInt("calorie_norm");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calorie_norm;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
