package ua.training.controller.servlet.command;

import ua.training.model.entity.User;
import ua.training.model.service.LoginService;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

       // AtomicReference<UserDao1> dao = (AtomicReference<UserDao1>) request.getServletContext().getAttribute("dao");

        //TODO check login and password separately

        String page;

        //аутентификация запускается один раз для текущей сессии

        if (new LoginService().userExists(login, password)) {
            if (request.getServletContext().getAttribute(login) != null && request.isRequestedSessionIdValid()) {
                ((HttpSession) request.getServletContext().getAttribute(login)).invalidate();
            }
            User.ROLE role = new LoginService().getRoleByLoginPassword(login, password);

            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("role", role.toString());
            request.getServletContext().setAttribute(login, request.getSession());


            page = moveToPage(request, response, role);

        } else {
             page = moveToPage(request, response, User.ROLE.GUEST);
        }

        return page;

    }

    private String moveToPage(HttpServletRequest request, HttpServletResponse response, User.ROLE role) throws IOException {
        if (role.equals(User.ROLE.ADMIN)){
            return  "redirect:/jsp/admin/admin_page.jsp";

        } else if (role.equals(User.ROLE.USER)){
            return "redirect:/jsp/user/user_page.jsp";

        } else {
            return "redirect:/jsp/index.jsp";
        }
    }
}
