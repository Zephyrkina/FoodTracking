package ua.training.model.dao;

import ua.training.model.entity.User;

public interface UserDao extends GenericDao<User>{
    boolean userExists(String login, String password);
    User.ROLE getRoleByLoginPassword(String login, String password);
    int getUserIdByLogin(String login);
}
