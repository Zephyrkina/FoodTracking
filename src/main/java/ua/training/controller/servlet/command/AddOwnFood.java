package ua.training.controller.servlet.command;

import org.apache.logging.log4j.LogManager;
import ua.training.controller.filter.AuthFilter;
import ua.training.controller.utils.InputDataUtils;
import ua.training.model.builder.FoodDTOBuilder;
import ua.training.model.dto.FoodDTO;
import ua.training.model.exception.ItemAlreadyExists;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.ErrorMessageManager;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;


public class AddOwnFood implements Command{
    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(AddOwnFood.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager((Locale) request.getSession().getAttribute("locale"));
        InputDataUtils inputDataUtils = new InputDataUtils();

        if (checkEmptyParameters(request)) {
            return "/WEB-INF/jsp/user/addOwnFood.jsp";
        }

        String nameEn = inputDataUtils.readCorrectData(request, "own_food_name_en", regexManager.getProperty("own.name.en"));
        String nameUa = inputDataUtils.readCorrectData(request, "own_food_name_ua", regexManager.getProperty("own.name.ua"));
        int calories = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_calories", regexManager.getProperty("int.numbers")));
        int carbs = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_carbs", regexManager.getProperty("int.numbers")));
        int fats = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_fats", regexManager.getProperty("int.numbers")));
        int proteins = Integer.parseInt(inputDataUtils.readCorrectData(request, "own_food_proteins", regexManager.getProperty("int.numbers")));

        if (inputDataUtils.checkWrongInput(request)) {
            return "/WEB-INF/jsp/user/addOwnFood.jsp";
        }

        FoodDTO food = new FoodDTOBuilder()
                .setNameEn(nameEn)
                .setNameUa(nameUa)
                .setCalories(calories)
                .setCarbohydrates(carbs)
                .setFats(fats)
                .setProteins(proteins)
                .build();

        try {
            new FoodService().addOwnFoodToDB(food, new UserService().getUserIdByLogin((String)request.getSession().getAttribute("login")));
            log.info("Added new user's food to database: " + food.toString() + ", user: " +  new UserService().getUserIdByLogin((String)request.getSession().getAttribute("login")));
        } catch (ItemAlreadyExists e) {
            request.setAttribute("foodAlreadyExists", new ErrorMessageManager((Locale) request.getSession().getAttribute("locale")).getProperty("food.already.exist"));
            return "/WEB-INF/jsp/user/addOwnFood.jsp";
        }

        return "/WEB-INF/jsp/user/userPage.jsp";

    }


    private boolean checkEmptyParameters(HttpServletRequest request) {
        if (request.getParameter("own_food_name_en") == null
                && request.getParameter("own_food_name_ua") == null
                && request.getParameter("own_food_calories") == null
                && request.getParameter("own_food_carbs") == null
                && request.getParameter("own_food_fats") == null
                && request.getParameter("own_food_proteins") == null ) {
            return true;

        }
        return false;
    }
}
