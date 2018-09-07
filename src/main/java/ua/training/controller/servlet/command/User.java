package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.ErrorMessageManager;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class User implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();

        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));

        int consumedCalories = new DailyRecordService().getTotalCalories(userId, LocalDate.now());
        int calorieNorm = userService.getCalorieNorm(userId);
        int diff = calorieNorm - consumedCalories;

        request.getSession().setAttribute("consumedCalories", consumedCalories);
        request.getSession().setAttribute("calorieNorm", calorieNorm);
        request.getSession().setAttribute("difference", diff);


        if (calorieNorm - consumedCalories < 0){
            request.getSession().setAttribute("calorieNormExceeded",
                    new ErrorMessageManager((Locale) request.getSession().getAttribute("locale")).getProperty("exceeded.daily.norm"));

        }

        return "/WEB-INF/jsp/user/user_page.jsp";
    }
}
