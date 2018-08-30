package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.Food;
import ua.training.model.entity.builder.FoodBuilder;
import ua.training.model.exception.ItemAlreadyExists;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.ErrorMessageManager;
import ua.training.model.service.resourse.manager.RegexManager;
import ua.training.model.service.resourse.manager.ResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class AddOwnFood implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager();

        //TODO breaks when input letters in int fields

        InputDataUtils inputDataUtils = new InputDataUtils();
        UserService userService = new UserService();
        FoodService foodService = new FoodService();


        String name = inputDataUtils.readCorrectData(request, "own_food_name", regexManager.getProperty("name"));
        int calories = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_calories", regexManager.getProperty("int.numbers")));
        int carbs = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_carbs", regexManager.getProperty("int.numbers")));
        int fats = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_fats", regexManager.getProperty("int.numbers")));
        int proteins = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_proteins", regexManager.getProperty("int.numbers")));

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/jsp/user/addOwnFood.jsp";
            }
        }

        Food food = new FoodBuilder()
                .setName(name)
                .setCalories(calories)
                .setCarbohydrates(carbs)
                .setFats(fats)
                .setProteins(proteins)
                .build();

        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));

        try {
            foodService.addOwnFoodToDB(food, userId);
        } catch (ItemAlreadyExists e) {
            request.setAttribute("foodAlreadyExists", e.getMessage());
            return "/jsp/user/addOwnFood.jsp";
        }

        return "redirect:/jsp/user/user_page.jsp";
    }
}
