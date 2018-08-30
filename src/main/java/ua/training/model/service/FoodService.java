package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.entity.Food;

import java.util.List;

public class FoodService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public int addOwnFoodToDB(Food food, int userId) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.createUsersFood(food, userId);
        }
    }

    public Food findFoodByName(String foodName) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.findByName(foodName);
        }
    }

    public List<Food> showAllFood() {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.findAll();
        }
    }

    public List<Food> findAllFood(int currentPage, int recordsPerPage) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.findAllFood(currentPage, recordsPerPage);
        }
    }

    public int getNumberOfRows() {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.numberOfRows();

        }
    }

}
