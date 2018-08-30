package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.entity.Food;
import ua.training.model.exception.ItemAlreadyExists;
import ua.training.model.exception.ItemNotFoundException;

import java.util.List;

public class FoodService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public int addOwnFoodToDB(Food food, int userId) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            try {
                foodDao.findByName(food.getName());
                throw new ItemAlreadyExists("Food with such name already exists!");
            }catch (ItemNotFoundException e) {
                return foodDao.createUsersFood(food, userId);
            }

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

    public void deleteFoodById(int foodId) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            foodDao.delete(foodId);

        }
    }

    public void editFood(Food food) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            foodDao.update(food);

        }
    }

}
