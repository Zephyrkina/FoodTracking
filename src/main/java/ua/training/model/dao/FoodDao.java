package ua.training.model.dao;

import ua.training.model.entity.Food;

import java.util.List;

public interface FoodDao extends GenericDao<Food> {
    Food findByName(String name);
    int createUsersFood(Food entity, int userId);
    List<Food> findAllFood(int currentPage, int recordsPerPage);
    int numberOfRows();


}
