package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.Food;
import ua.training.model.entity.builder.FoodBuilder;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class EditFood implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager();

        InputDataUtils inputDataUtils = new InputDataUtils();
        FoodService foodService = new FoodService();

        int currentPage = Integer.parseInt(request.getParameter("current_page"));
        int recordsPerPage = Integer.parseInt(request.getParameter("records_per_page"));

        int id = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_id", regexManager.getProperty("int.numbers")));
        String name = inputDataUtils.readCorrectData(request, "food_name", regexManager.getProperty("name"));
        int calories = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_calories", regexManager.getProperty("int.numbers")));
        int carbs = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_carbs", regexManager.getProperty("int.numbers")));
        int fats = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_fats", regexManager.getProperty("int.numbers")));
        int proteins = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_proteins", regexManager.getProperty("int.numbers")));

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/jsp/admin/editFood.jsp";
            }
        }
        Food food = new FoodBuilder()
                .setId(id)
                .setName(name)
                .setCalories(calories)
                .setCarbohydrates(carbs)
                .setFats(fats)
                .setProteins(proteins)
                .build();

        foodService.editFood(food);

        return "redirect:/app/showAllFood?currentPage="+ currentPage+"&recordsPerPage=" + recordsPerPage;
    }
}
