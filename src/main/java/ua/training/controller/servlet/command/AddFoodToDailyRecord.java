package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class AddFoodToDailyRecord implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager(Locale.class.cast(request.getSession().getAttribute("locale")));
        InputDataUtils inputDataUtils = new InputDataUtils();

        int userId = new UserService().getUserIdByLogin((String)request.getSession().getAttribute("login"));
        int foodId = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_id", regexManager.getProperty("int.numbers")));
        int quantity = Integer.parseInt(inputDataUtils.readCorrectData(request, "food_quantity", regexManager.getProperty("int.numbers")));

        new DailyRecordService().addFoodToDailyRecord(foodId, quantity, LocalDate.now(), userId);


        return "/user/profile";
    }
}
