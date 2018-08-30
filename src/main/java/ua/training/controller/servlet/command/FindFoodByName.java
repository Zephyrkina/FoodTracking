package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.entity.Food;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class FindFoodByName implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager();
        InputDataUtils inputDataUtils = new InputDataUtils();


        String foodName = inputDataUtils.readCorrectData(request,"search_food_name", regexManager.getProperty("name"));

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/jsp/user/user_page.jsp";
            }
        }

        Food food;

        try {
            food = new FoodService().findFoodByName(foodName);
        } catch(ItemNotFoundException itfe) {
            request.setAttribute("cantFindFoodMessage", "there is no food in db. Try to create your own");
            return "/jsp/user/user_page.jsp";
        }

        List<Food> foods = new ArrayList<>();
        foods.add(food);
        //request.setAttribute("food", food);
        request.setAttribute("foods", foods);
        return "/jsp/user/user_page.jsp";

    }
}
