package ua.training.controller.servlet.command;

import com.sun.javafx.scene.input.InputEventUtils;
import ua.training.controller.utils.InputDataUtils;
import ua.training.model.exception.ExceededCalorieNormException;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class AddFoodToDailyRecord implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Locale locale = (Locale) request.getSession().getAttribute("locale");
        RegexManager regexManager = new RegexManager(locale);
        UserService userService = new UserService();
        DailyRecordService dailyRecordService = new DailyRecordService();
        InputDataUtils inputDataUtils = new InputDataUtils();



        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        int foodId = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_id", regexManager.getProperty("int.numbers")));
        int quantity = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_quantity", regexManager.getProperty("int.numbers")));
        LocalDate date = LocalDate.now();



        dailyRecordService.addFoodToDailyRecord(foodId, quantity, date, userId);

       /* int consumedCalories = dailyRecordService.getTotalCalories(userId, LocalDate.now());
        int calorieNorm = userService.getCalorieNorm(userId);
        int diff = calorieNorm - consumedCalories;

        request.getSession().setAttribute("consumedCalories", consumedCalories);
        request.getSession().setAttribute("calorieNorm", calorieNorm);
        request.getSession().setAttribute("difference", diff);


        if (calorieNorm - consumedCalories < 0){
            request.getSession().setAttribute("calorieNormExceeded", "You have exceeded daily calorie norm!");
        }*/
/*
        try {
            dailyRecordService.getTotalCalories(userId, LocalDate.now());
        } catch (ExceededCalorieNormException e) {
            request.getSession().setAttribute("calorieNormExceeded", e.getMessage());
        }*/

        return "/WEB-INF/jsp/user/user_page.jsp";
    }
}
