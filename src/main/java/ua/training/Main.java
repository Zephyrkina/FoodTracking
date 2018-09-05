package ua.training;

import org.apache.logging.log4j.*;
import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.User;


public class Main {
    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(User.class);

    public static void main(String[] args) {
        User user = new User();
        user.setName("Anakin");

        userLogger.info(user.toString());

        rootLogger.info("Root Logger: "  + user.toString());

        //debug
        if (rootLogger.isDebugEnabled()) {
            rootLogger.debug("RootLogger: In debug message");
            userLogger.debug("UserLogger in debug");
        }

        try {
            User userNull = new User();
            userNull.getName().toString();
        } catch (NullPointerException ex) {
            userLogger.error("error message: " + ex.getMessage());
            userLogger.fatal("fatal error message: " + ex.getMessage());
        }

/*
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
*/

       /*
        UserDao jdbcUserDao = jdbcDaoFactory.createUserDao();
        User user = new User(10, "username", "1234", "email123", "Vasya", User.ROLE.USER, 18,
        178, 67.0, User.LIFE_ACTIVITY.NORMAL , 2500 );

        System.out.println(jdbcUserDao.create(user));

        System.out.println(jdbcUserDao.findById(15));
        System.out.println(jdbcUserDao.update(new User(15, "username2", "1234", "email123", "Vasya", User.ROLE.USER, 18,
                178, 67.0, User.LIFE_ACTIVITY.NORMAL , 2500 )));
        System.out.println(jdbcUserDao.findById(15));

        System.out.println(jdbcUserDao.delete(15));*/

        //System.out.println(jdbcUserDao.findById(11));

        /*FoodDao jdbcFoodDao = jdbcDaoFactory.createFoodDao();
        Food food = new Food(4, "carrot", 25, 12, 1,1);
        System.out.println(jdbcFoodDao.create(food));

        System.out.println(jdbcFoodDao.findByName("banana"));
        System.out.println(jdbcFoodDao.findById(4));

        System.out.println(jdbcFoodDao.update(new Food(4, "carrot", 40, 12, 1,1)));
        System.out.println(jdbcFoodDao.findById(4));

        System.out.println(jdbcFoodDao.delete(4));*/

        //System.out.println(jdbcUserDao.findById(11));

        /*DaoFactory daoFactory = DaoFactory.getInstance();
        DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao();
        dailyRecordDao.savePreviousRecords(3,7);*/


    }
}
