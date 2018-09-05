package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.FoodDao;
import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.Food;
import ua.training.model.exception.ItemAlreadyExists;
import ua.training.model.exception.ItemNotFoundException;

import java.util.List;

public class FoodService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    //TODO parse name en/ name ua


    public int addOwnFoodToDB(FoodDTO food, int userId) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            try {

                foodDao.findByName(food.getNameEn(), food.getNameUa());
                throw new ItemAlreadyExists("Food with such name already exists!");
            }catch (ItemNotFoundException e) {
                return foodDao.createUsersFood(food, userId);
            }

        }
    }

    public FoodDTO findFoodByName(String foodNameEn, String foodNameUa) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.findByName(foodNameEn, foodNameUa);
        }
    }

    public List<FoodDTO> showAllFood() {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            return foodDao.findAll();
        }
    }

    public List<FoodDTO> findAllFood(int currentPage, int recordsPerPage) {
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

    public void editFood(FoodDTO food) {
        try (FoodDao foodDao = daoFactory.createFoodDao()) {
            foodDao.update(food);

        }
    }

}
