package ua.training.model.dao;

import ua.training.model.entity.Food;

public interface FoodDao extends GenericDao<Food> {
    Food findByName(String name);
    int createUsersFood(Food entity, int userId);

}
