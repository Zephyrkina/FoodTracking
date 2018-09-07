package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.dto.FoodDTO;
import ua.training.model.builder.FoodBuilder;
import ua.training.model.builder.FoodDTOBuilder;
import ua.training.model.exception.ItemAlreadyExists;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

public class AddOwnFood implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Locale locale = (Locale) request.getSession().getAttribute("locale");

        RegexManager regexManager = new RegexManager(locale);
/*
        String locale = request.getSession().getAttribute("language").toString();
*/

        System.out.println(locale);


        //TODO breaks when input letters in int fields

        InputDataUtils inputDataUtils = new InputDataUtils();
        UserService userService = new UserService();
        FoodService foodService = new FoodService();

        if (request.getParameter("own_food_name_en") == null
                && request.getParameter("own_food_name_ua") == null
                && request.getParameter("own_food_calories") == null
                && request.getParameter("own_food_carbs") == null
                && request.getParameter("own_food_fats") == null
                && request.getParameter("own_food_proteins") == null ) {
          return "/WEB-INF/jsp/user/addOwnFood.jsp";

        }



        String nameEn = inputDataUtils.readCorrectData(request, "own_food_name_en", regexManager.getProperty("own.name.en"));
        String nameUa = inputDataUtils.readCorrectData(request, "own_food_name_ua", regexManager.getProperty("own.name.ua"));


        /*if(locale.toString().equals("uk_UA")){

            nameUa = inputDataUtils.readCorrectData(request, "own_food_name_ua", regexManager.getProperty("name"));
            System.out.println("ua:" + nameUa);
        }
        if(locale.toString().equals("en_US")){
            nameEn = inputDataUtils.readCorrectData(request, "own_food_name_en", regexManager.getProperty("name"));
            System.out.println("en:" + nameEn);


        }
*/
/*
        String name = inputDataUtils.readCorrectData(request, "own_food_name", regexManager.getProperty("name"));
*/
        int calories = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_calories", regexManager.getProperty("int.numbers")));
        int carbs = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_carbs", regexManager.getProperty("int.numbers")));
        int fats = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_fats", regexManager.getProperty("int.numbers")));
        int proteins = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_proteins", regexManager.getProperty("int.numbers")));


        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/WEB-INF/jsp/user/addOwnFood.jsp";
            }
        }

        FoodDTO food = new FoodDTOBuilder()
                .setNameEn(nameEn)
                .setNameUa(nameUa)
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
            return "/WEB-INF/jsp/user/addOwnFood.jsp";
        }

//        return "redirect:/WEB-INF/jsp/user/user_page.jsp";
        return "/WEB-INF/jsp/user/user_page.jsp";

    }
}
