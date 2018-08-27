package ua.training;

import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.Food;
import ua.training.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();

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

        DaoFactory daoFactory = DaoFactory.getInstance();
        DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao();
        dailyRecordDao.saveRecordToFoodDiary(3,7);


    }
}
