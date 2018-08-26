package ua.training.model.dao;

import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.DailyRecord;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract FoodDao createFoodDao();
    public abstract DailyRecordDao createDailyRecordDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
