package ua.training.controller.servlet.command;

import org.apache.logging.log4j.LogManager;
import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.User;
import ua.training.model.builder.UserBuilder;
import ua.training.model.exception.NotUniqueEmailException;
import ua.training.model.exception.NotUniqueLoginException;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

public class Registration implements Command {
    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Registration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager((Locale) request.getSession().getAttribute("locale"));
        InputDataUtils inputDataUtils = new InputDataUtils();
        UserService userService = new UserService();

        if (checkEmptyParameters(request)) return "/WEB-INF/jsp/registration.jsp";

        String name_en = inputDataUtils.readCorrectData(request, "user_name", regexManager.getProperty("name"));
        String login = inputDataUtils.readCorrectData(request, "user_login", regexManager.getProperty("login"));
        String email = inputDataUtils.readCorrectData(request, "user_email", regexManager.getProperty("email"));
        String password = inputDataUtils.readCorrectData(request, "user_password", regexManager.getProperty("password"));
        String password_repeat = inputDataUtils.readCorrectData(request, "user_password_repeat", request.getParameter("user_password"));
        int age = Integer.parseInt(inputDataUtils.readCorrectData(request, "user_age", regexManager.getProperty("int.numbers")));
        int height = Integer.parseInt(inputDataUtils.readCorrectData(request, "user_height", regexManager.getProperty("int.numbers")));
        double weight = Double.parseDouble(inputDataUtils.readCorrectData(request, "user_weight", regexManager.getProperty("int.numbers")));
        User.LIFE_ACTIVITY activity = User.LIFE_ACTIVITY.valueOf(request.getParameter("user_activity").toUpperCase());


        try {
            userService.checkUniqueLoginEmail(login, email);
        } catch (NotUniqueLoginException e) {
            request.setAttribute("notUniqueLogin", "Login is already in use. Choose another one.");
        } catch (NotUniqueEmailException e) {
            request.setAttribute("notUniqueEmail", "Email is already in use. Choose another one.");
        }

        if (inputDataUtils.checkWrongInput(request)) {
            return "/WEB-INF/jsp/registration.jsp";
        }


        int calorieNorm = userService.calculateCalorieNorm(age, height, weight);
        User.ROLE role = User.ROLE.USER;

        User user = new UserBuilder()
                .setLogin(login)
                .setPassword(password)
                .setEmail(email)
                .setName(name_en)
                .setRole(User.ROLE.USER)
                .setAge(age)
                .setHeight(height)
                .setWeight(weight)
                .setActivity(activity)
                .setCalorieNorm(calorieNorm)
                .build();

        userService.createUser(user);
        log.info("New user have been registered, login: " + login);

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("role", role.toString());
        request.getServletContext().setAttribute(login, request.getSession());


        return "/user/profile";
        }


    private boolean checkEmptyParameters(HttpServletRequest request) {
        if( request.getParameter("user_name") == null
                && request.getParameter("user_login") == null
                && request.getParameter("user_email") == null
                && request.getParameter("user_password") == null
                && request.getParameter("user_password_repeat") == null
                && request.getParameter("user_age") == null
                && request.getParameter("user_height") == null
                && request.getParameter("user_weight") == null ){
            return true;
        }
        return false;
    }
}
