package ua.training.controller.servlet.command;

import ua.training.model.service.DailyRecordService;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SavePreviousRecords implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        DailyRecordService dailyRecordService = new DailyRecordService();
        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        LocalDate date = LocalDate.now();
        dailyRecordService.savePreviousRecords(userId, date);

        return "/jsp/user/user_page.jsp";
    }
}
