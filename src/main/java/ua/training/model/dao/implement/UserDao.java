package ua.training.model.dao.implement;

import ua.training.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> users = new ArrayList<>();

    public User getById(int id) {

        User result = new User();
        result.setId(-1);

        for (User user : users) {
            if (user.getId() == id) {
                result = user;
            }
        }

        return result;
    }

    public User getUserByLoginPassword(final String login, final String password) {

        User result = new User();
        result.setId(-1);

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user;
            }
        }

        return result;
    }

    public boolean add(final User user) {

        for (User u : users) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return users.add(user);
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.GUEST;

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }

}
