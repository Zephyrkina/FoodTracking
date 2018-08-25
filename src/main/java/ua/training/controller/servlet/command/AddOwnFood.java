package ua.training.controller.servlet.command;

import ua.training.model.entity.Food;
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


        String name = readCorrectData(request, "own_food_name", regexManager.getProperty("name"));
        int calories = Integer.parseInt(readCorrectData(request, "own_food_calories", regexManager.getProperty("int.numbers")));
        int carbs = Integer.parseInt(readCorrectData(request, "own_food_carbs", regexManager.getProperty("int.numbers")));
        int fats = Integer.parseInt(readCorrectData(request, "own_food_fats", regexManager.getProperty("int.numbers")));
        int proteins = Integer.parseInt(readCorrectData(request, "own_food_proteins", regexManager.getProperty("int.numbers")));

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/jsp/user/addOwnFood.jsp";
            }
        }

        Food food = new Food(name, calories, carbs, fats, proteins);
        UserService userService = new UserService();
        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        userService.addOwnFoodToDB(food, userId);

        return "redirect:/jsp/user/user_page.jsp";
    }


    private String readCorrectData(HttpServletRequest request, String parameter, String regex) {
        String inputData = request.getParameter(parameter).toLowerCase();
        request.setAttribute(parameter, inputData);
        if (! inputData.matches(regex)) {
            request.setAttribute("wrong_"+parameter, new ErrorMessageManager().getProperty("wrong." + parseString(parameter)));
            return null;  //TODO remove return null
        }
        return inputData;
    }

    private String parseString(String str){
        str = str.replaceAll("_",".");
        return str;

    }

}
