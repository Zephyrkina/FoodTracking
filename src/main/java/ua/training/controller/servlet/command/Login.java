package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.User;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.service.LoginService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class Login implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        InputDataUtils inputDataUtils = new InputDataUtils();
        RegexManager regexManager = new RegexManager();

        String login = inputDataUtils.readCorrectData(request, "input_login", regexManager.getProperty("login"));
        String password = inputDataUtils.readCorrectData(request,"input_password", regexManager.getProperty("password"));

        UserService userService = new UserService();

        try {
            userService.checkLoginExists(login);
        } catch(ItemNotFoundException e) {
            request.setAttribute("userNotFound", "User with login \"" + login + "\" doesn't exist");
            return "/jsp/login.jsp";
        }

        try {
            userService.checkPasswordCorrect(password);
        } catch(ItemNotFoundException e) {
            request.setAttribute("wrong_input_password", "Wrong password");
            return "/jsp/login.jsp";

        }

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/jsp/login.jsp";
            }
        }

        if (request.getServletContext().getAttribute(login) != null && request.isRequestedSessionIdValid()) {
            ((HttpSession) request.getServletContext().getAttribute(login)).invalidate();
        }
        User.ROLE role = userService.getRoleByLoginPassword(login, password);
        //String role = userService.getRoleByLoginPassword(login, password).toString();

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("role", role.toString());
        request.getServletContext().setAttribute(login, request.getSession());
        System.out.println(role);
        String roleString = role.toString().toLowerCase();

        return "redirect:/jsp/" + roleString +"/"+ roleString +"_page.jsp";


    }
}
