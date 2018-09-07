package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.dto.FoodDTO;
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
import java.util.Locale;

public class FindFoodByName implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Locale locale = (Locale) request.getSession().getAttribute("locale");

        RegexManager regexManager = new RegexManager(locale);
        InputDataUtils inputDataUtils = new InputDataUtils();

        if (request.getParameter("search_food_name") == null) {
            return "/WEB-INF/jsp/user/findFood.jsp";
        }


        String nameEn = null;
        String nameUa = null;

        if(locale.getLanguage().equals("uk")){
            nameUa = inputDataUtils.readCorrectData(request, "search_food_name", regexManager.getProperty("name"));
        }
        if(locale.getLanguage().equals("en")){
            nameEn = inputDataUtils.readCorrectData(request, "search_food_name", regexManager.getProperty("name"));
        }

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/WEB-INF/jsp/user/findFood.jsp";
            }
        }

        FoodDTO foodDTO;

        try {
            foodDTO = new FoodService().findFoodByName(nameEn, nameUa);
        } catch(ItemNotFoundException itfe) {
            request.setAttribute("cantFindFoodMessage", "there is no food in db. Try to create your own");
            return "/WEB-INF/jsp/user/findFood.jsp";
        }

        List<Food> foods = new ArrayList<>();
        foods.add(foodDTO.convertToLocalizatedFood(locale));

        request.setAttribute("foods", foods);
        return "/WEB-INF/jsp/user/findFood.jsp";

    }
}
