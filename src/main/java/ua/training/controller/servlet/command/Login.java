package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.User;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.ErrorMessageManager;
import ua.training.model.service.resourse.manager.RegexManager;

import org.apache.logging.log4j.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

public class Login implements Command{
    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Login.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputDataUtils inputDataUtils = new InputDataUtils();
        RegexManager regexManager = new RegexManager((Locale) request.getSession().getAttribute("locale"));
        UserService userService = new UserService();

        if ( request.getParameter("input_login") == null && request.getParameter("input_password") == null) {
            return "/WEB-INF/jsp/login.jsp";
        }

        String login = inputDataUtils.readCorrectData(request, "input_login", regexManager.getProperty("login"));
        String password = inputDataUtils.readCorrectData(request,"input_password", regexManager.getProperty("password"));

        try {
            userService.checkLoginExists(login);
        } catch(ItemNotFoundException e) {
            log.warn("Wrong login input");
            request.setAttribute("userNotFound",
                    new ErrorMessageManager((Locale) request.getSession().getAttribute("locale")).getProperty("user.not.found"));
            return "/WEB-INF/jsp/login.jsp";
        }

        try {
            userService.checkPasswordCorrect(login ,password);
        } catch(ItemNotFoundException e) {
            log.warn("Wrong password input, login " + login);
            request.setAttribute("wrong_input_password",
                    new ErrorMessageManager((Locale) request.getSession().getAttribute("locale")).getProperty("wrong.user.password"));
            return "/WEB-INF/jsp/login.jsp";

        }

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/WEB-INF/jsp/login.jsp";
            }
        }

        if (request.getServletContext().getAttribute(login) != null && request.isRequestedSessionIdValid()) {
            log.warn("Invalidate previous user's session, login" + login);
            ((HttpSession) request.getServletContext().getAttribute(login)).invalidate();
        }
        User.ROLE role = userService.getRoleByLoginPassword(login, password);

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("role", role.toString());
        request.getServletContext().setAttribute(login, request.getSession());

        log.info("User log in, login " + login);

        return "redirect:/user/profile";

    }
}
