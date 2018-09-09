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
import java.util.Locale;

/**
 * Executes logging of the user: reads valid data, checks the login for existence,
 * checks if the password is correct and sets user's data in  session.
 */
public class Login implements Command{
    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Login.class);

    /**
     * Reads valid data, checks the login for existence,
     * checks if the password is correct and sets user's data in  session.
     *
     * @param request object that provides client request information
     * @param response object that assists a servlet in sending a response to the client
     */
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

        if ( checkLoginNotExists(request, userService, login)) {
            return "/WEB-INF/jsp/login.jsp";
        }

        if ( checkPasswordWrong(request, userService, login, password)) {
            return "/WEB-INF/jsp/login.jsp";
        }

        if (inputDataUtils.checkWrongInput(request)) {
            return "/WEB-INF/jsp/login.jsp";
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

    /**
     * Checks if password is wrong
     *
     * @param request client's request
     * @param userService contains service that checks if password is wrong
     * @param login string value that contains user login
     * @param password string value that contains user password
     * @return true if password is wrong
     */
    private boolean checkPasswordWrong(HttpServletRequest request, UserService userService, String login, String password) {
        try {
            userService.checkPasswordCorrect(login ,password);
        } catch(ItemNotFoundException e) {
            log.warn("Wrong password input, login " + login);
            request.setAttribute("wrong_input_password",
                    new ErrorMessageManager((Locale) request.getSession().getAttribute("locale")).getProperty("wrong.user.password"));
            return true;

        }
        return false;
    }

    /**
     * Checks if login doesn not exist
     *
     * @param request client's request
     * @param userService contains service that checks if password is wrong
     * @param login string value that contains user login
     * @return false if login doesn't exist
     */
    private boolean checkLoginNotExists(HttpServletRequest request, UserService userService, String login) {
        try {
            userService.checkLoginExists(login);
        } catch(ItemNotFoundException e) {
            log.warn("Wrong login input");
            request.setAttribute("userNotFound",
                    new ErrorMessageManager((Locale) request.getSession().getAttribute("locale")).getProperty("user.not.found"));
            return true;
        }
        return false;
    }
}
