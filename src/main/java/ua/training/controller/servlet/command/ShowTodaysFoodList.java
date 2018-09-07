package ua.training.controller.servlet.command;

import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.Food;
import ua.training.model.exception.FoodListIsEmptyException;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShowTodaysFoodList implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        DailyRecordService dailyRecordService = new DailyRecordService();


        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));

        List<Food> foods = new ArrayList<>();
        Food food;
        try {
            List<FoodDTO> foodList = dailyRecordService.showTodaysFoodList(userId, LocalDate.now());
            for(FoodDTO dto : foodList) {
                food = dto.convertToLocalizatedFood((Locale) request.getSession().getAttribute("locale"));
                foods.add(food);
            }
            request.setAttribute("foodList", foods);
        } catch (FoodListIsEmptyException e) {
            request.setAttribute("foodListIsEmpty", e.getMessage());
        }


        return "/WEB-INF/jsp/user/showTodaysMeals.jsp";
    }
}
