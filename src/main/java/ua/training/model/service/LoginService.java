package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.util.List;

public class LoginService {
    private UserDao userDao;

    public LoginService() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.createUserDao();
    }

    public boolean userExists(String login, String password) {
        return userDao.userExists(login, password);
    }

    public User.ROLE getRoleByLoginPassword(String login, String password) {
        return userDao.getRoleByLoginPassword(login, password);
    }
}
