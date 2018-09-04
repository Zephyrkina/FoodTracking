package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.entity.DailyRecord;
import ua.training.model.entity.User;
import ua.training.model.exception.ExceededCalorieNormException;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.RegexManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;

public class Login implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        InputDataUtils inputDataUtils = new InputDataUtils();
        RegexManager regexManager = new RegexManager();
        UserService userService = new UserService();
        DailyRecordService dailyRecordService = new DailyRecordService();

        String login1 = request.getParameter("input_login");
        String password1 = request.getParameter("input_password");

        if ( login1 == null && password1 == null) {
            return "/WEB-INF/jsp/login.jsp";
        }

        String login = inputDataUtils.readCorrectData(request, "input_login", regexManager.getProperty("login"));
        String password = inputDataUtils.readCorrectData(request,"input_password", regexManager.getProperty("password"));

        try {
            userService.checkLoginExists(login);
        } catch(ItemNotFoundException e) {
            request.setAttribute("userNotFound", "User with login \"" + login + "\" doesn't exist");
            return "/WEB-INF/jsp/login.jsp";
        }

        try {
            userService.checkPasswordCorrect(password);
        } catch(ItemNotFoundException e) {
            request.setAttribute("wrong_input_password", "Wrong password");
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
            ((HttpSession) request.getServletContext().getAttribute(login)).invalidate();
        }
        User.ROLE role = userService.getRoleByLoginPassword(login, password);
        //String role = userService.getRoleByLoginPassword(login, password).toString();

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("role", role.toString());
        request.getServletContext().setAttribute(login, request.getSession());
        System.out.println(role);
        String roleString = role.toString().toLowerCase();

       int userId = userService.getUserIdByLogin(login);

        int consumedCalories = dailyRecordService.getTotalCalories(userId, LocalDate.now());
        int calorieNorm = userService.getCalorieNorm(userId);
        int diff = calorieNorm - consumedCalories;

        request.getSession().setAttribute("consumedCalories", consumedCalories);
        request.getSession().setAttribute("calorieNorm", calorieNorm);
        request.getSession().setAttribute("difference", diff);


        if (calorieNorm - consumedCalories < 0){
            request.getSession().setAttribute("calorieNormExceeded", "You have exceeded daily calorie norm!");
        }

/*
        return "redirect:/WEB-INF/jsp/" + roleString +"/"+ roleString +"_page.jsp";
*/
        return "/WEB-INF/jsp/" + roleString +"/"+ roleString +"_page.jsp";



    }
}
