package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.Food;
import ua.training.model.entity.User;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RegexManager regexManager = new RegexManager();

        //TODO breaks when input letters in int fields

        InputDataUtils inputDataUtils = new InputDataUtils();

        String name_en = inputDataUtils.readCorrectData(request, "user_name", regexManager.getProperty("name"));
        String login = inputDataUtils.readCorrectData(request, "user_login", regexManager.getProperty("login"));
        String email = inputDataUtils.readCorrectData(request, "user_email", regexManager.getProperty("email"));
        String password = inputDataUtils.readCorrectData(request, "user_password", regexManager.getProperty("password"));
        String password_repeat = inputDataUtils.readCorrectData(request, "user_password_repeat", regexManager.getProperty("password"));
        int age = Integer.parseInt(inputDataUtils.readCorrectData(request, "user_age", regexManager.getProperty("int.numbers")));
        int height = Integer.parseInt(inputDataUtils.readCorrectData(request, "user_height", regexManager.getProperty("int.numbers")));
        double weight = Double.parseDouble(inputDataUtils.readCorrectData(request, "user_weight", regexManager.getProperty("int.numbers")));
        User.LIFE_ACTIVITY activity = User.LIFE_ACTIVITY.valueOf(request.getParameter("user_activity").toUpperCase());

        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return "/jsp/registration.jsp";
            }
        }

        UserService userService = new UserService();
        int calorieNorm = userService.calculateCalorieNorm(age, height, weight);


        User.ROLE role = User.ROLE.USER;
        User user = new User(login, password, email, name_en, role, age, height, weight, activity, calorieNorm);

        userService.createUser(user);

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("role", role.toString());
        request.getServletContext().setAttribute(login, request.getSession());


        return "redirect:/jsp/user/user_page.jsp";
        }
}
