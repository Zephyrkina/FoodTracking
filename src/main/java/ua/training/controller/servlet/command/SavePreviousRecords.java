package ua.training.controller.servlet.command;

import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SavePreviousRecords implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        int userId = userService.getUserIdByLogin((String)request.getSession().getAttribute("login"));
        userService.savePreviousRecords(userId);

        return "/jsp/user/user_page.jsp";
    }
}
