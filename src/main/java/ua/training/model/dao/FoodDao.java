package ua.training.model.dao;

import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.Food;

import java.util.List;

public interface FoodDao extends GenericDao<FoodDTO> {
    FoodDTO findByName(String name);
    int createUsersFood(FoodDTO entity, int userId);
    List<FoodDTO> findAllFood(int currentPage, int recordsPerPage);
    int numberOfRows();



}
