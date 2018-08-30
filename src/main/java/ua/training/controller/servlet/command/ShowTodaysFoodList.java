package ua.training.controller.servlet.command;

import ua.training.model.entity.Food;
import ua.training.model.exception.FoodListIsEmptyException;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ShowTodaysFoodList implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        DailyRecordService dailyRecordService = new DailyRecordService();

        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        LocalDate date = LocalDate.now();

        try {
            List<Food> foodList = dailyRecordService.showTodaysFoodList(userId, date);
            request.setAttribute("foodList", foodList);

        } catch (FoodListIsEmptyException e) {
            request.setAttribute("foodListIsEmpty", e.getMessage());
        }
        return "/jsp/user/user_page.jsp";
    }
}
