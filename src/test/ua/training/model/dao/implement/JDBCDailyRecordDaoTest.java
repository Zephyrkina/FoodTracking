package ua.training.model.dao.implement;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.util.resources.LocaleData;
import ua.training.model.dao.DailyRecordDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.exception.ItemAlreadyExists;
import ua.training.model.exception.ItemNotFoundException;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.Assert.*;

public class JDBCDailyRecordDaoTest {
    DaoFactory daoFactory;

    @Before
    public void init() {
        daoFactory = DaoFactory.getInstance();
    }

    @Test(expected = ItemNotFoundException.class)
    public void savePreviousRecords() {
        int userId = 3;
        LocalDate date = LocalDate.now();

        try (DailyRecordDao dailyRecordDao = daoFactory.createDailyRecordDao()) {
            int dailyRecordId = dailyRecordDao.getRecordIdByUserIdAndDate(userId, date);
            dailyRecordDao.savePreviousRecords(userId, dailyRecordId);

        }



    }


}
