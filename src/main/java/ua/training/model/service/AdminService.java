package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.util.List;

public class AdminService {
    private UserDao userDao;

    public AdminService() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.createUserDao();
    }

    public List<User> findAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }
}
