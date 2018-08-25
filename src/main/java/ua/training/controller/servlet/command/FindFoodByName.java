package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.ItemNotFoundException;
import ua.training.model.entity.Food;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindFoodByName implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager();
        InputDataUtils inputDataUtils = new InputDataUtils();

        String foodName = inputDataUtils.readCorrectData(request,"search_food_name", regexManager.getProperty("name"));

        Food food;

        try {
            food = new UserService().findFoodByName(foodName);
        } catch(ItemNotFoundException itfe) {
            request.setAttribute("cantFindFoodMessage", "there is no food in db. Try to create your own");
            return "/jsp/user/user_page.jsp";
        }


        request.setAttribute("food", food);
        return "/jsp/user/user_page.jsp";

    }
}
