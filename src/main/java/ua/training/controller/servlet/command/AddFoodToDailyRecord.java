package ua.training.controller.servlet.command;

import com.sun.javafx.scene.input.InputEventUtils;
import ua.training.controller.utils.InputDataUtils;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class AddFoodToDailyRecord implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager();

        UserService userService = new UserService();

        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        int foodId = Integer.parseInt(InputDataUtils.readCorrectData(request, "food_id", regexManager.getProperty("int.numbers")));
        int quantity = Integer.parseInt(InputDataUtils.readCorrectData(request, "food_quantity", regexManager.getProperty("int.numbers")));
        LocalDate date = LocalDate.now();
        System.out.println(date);

        userService.addFoodToDailyRecord(foodId, quantity, date, userId);

        return "/jsp/user/user_page.jsp";
    }
}