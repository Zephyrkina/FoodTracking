package ua.training.controller.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLanguage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
/*
        String page = request.getParameter("command");
        if (request.getParameter("query") != null) {
            page += "?" + request.getParameter("query");
        }

        System.out.println(page);*/


        return "/index.jsp";
    }
}
