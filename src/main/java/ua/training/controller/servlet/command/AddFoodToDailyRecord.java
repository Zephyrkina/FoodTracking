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
    //TODO private static final green string
    //TODO global interf contanrs


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RegexManager regexManager = new RegexManager((Locale) request.getSession().getAttribute("locale"));
        InputDataUtils inputDataUtils = new InputDataUtils();


        int userId = new UserService().getUserIdByLogin((String)request.getSession().getAttribute("login"));
        int foodId = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_id", regexManager.getProperty("int.numbers")));
        int quantity = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_quantity", regexManager.getProperty("int.numbers")));

        new DailyRecordService().addFoodToDailyRecord(foodId, quantity, LocalDate.now(), userId);


        return "/app/user";
    }
}
