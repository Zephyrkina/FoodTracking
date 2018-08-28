package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public AdminService() {
       // DaoFactory daoFactory = DaoFactory.getInstance();
        //userDao = daoFactory.createUserDao();
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (UserDao dao = daoFactory.createUserDao()) {
            users =  dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
