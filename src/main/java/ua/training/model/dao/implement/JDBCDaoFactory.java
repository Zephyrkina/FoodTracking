package ua.training.model.dao.implement;

import org.apache.logging.log4j.LogManager;
import ua.training.controller.servlet.command.AddOwnFood;
import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory{

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(JDBCDaoFactory.class);


    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    public FoodDao createFoodDao() {
        return new JDBCFoodDao(getConnection());
    }

    public DailyRecordDao createDailyRecordDao() { return new JDBCDailyRecordDao(getConnection()); }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Database connection failed");
            throw new RuntimeException();
        }
    }
}
