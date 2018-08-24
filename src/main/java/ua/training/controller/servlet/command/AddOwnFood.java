package ua.training.controller.servlet.command;

import ua.training.model.entity.Food;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddOwnFood implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("ownFoodName");
        int calories = Integer.parseInt(request.getParameter("ownFoodCalories"));
        int carbs = Integer.parseInt(request.getParameter("ownFoodCarbs"));
        int fats = Integer.parseInt(request.getParameter("ownFoodFats"));
        int proteins = Integer.parseInt(request.getParameter("ownFoodProteins"));

        Food food = new Food(name, calories, carbs, fats, proteins);
        UserService userService = new UserService();
        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));

        userService.addOwnFoodToDB(food, userId);

        return "redirect:/jsp/user/user_page.jsp";
    }
}
