package ua.training.controller.servlet;

import ua.training.model.dao.implement.UserDao;
import ua.training.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

import static ua.training.model.entity.User.ROLE.ADMIN;
import static ua.training.model.entity.User.ROLE.USER;

@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * Fake database connector.
     */
    private AtomicReference<UserDao> dao;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDao());

        dao.get().add(new User(1, "Pavel", "1", ADMIN));
        dao.get().add(new User(2, "Egor", "1", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}