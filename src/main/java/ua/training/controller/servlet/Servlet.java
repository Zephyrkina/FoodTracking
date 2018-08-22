package ua.training.controller.servlet;

import ua.training.controller.servlet.command.Command;
import ua.training.controller.servlet.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/app/*")
public class Servlet extends HttpServlet {
    private Command command;
    private CommandFactory commandFactory;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        commandFactory = new CommandFactory();
        command = commandFactory.getCommand(request);

        String page = command.execute(request, response);

        if (page.contains("redirect")){
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }

    }
}