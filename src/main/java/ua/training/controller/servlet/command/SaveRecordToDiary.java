package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class SaveRecordToDiary implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        userService.saveRecordToFoodDiary(userId);

        return "/jsp/user/user_page.jsp";
    }
}
