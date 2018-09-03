package ua.training.controller.servlet.command;

import ua.training.model.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllUsersCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<User> users = new UserService().findAllUsers();
        request.setAttribute("users", users);

        return "/WEB-INF/jsp/admin/admin_page.jsp";
    }
}
