package ua.training.controller.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmptyCommand  implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/index.jsp";
    }
}
