package ua.training.controller.servlet.command;

import org.apache.logging.log4j.LogManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout implements Command{
    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Logout.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info("User log out: "+ request.getSession().getAttribute("login"));
        request.getSession().invalidate();

        return "redirect:/index.jsp";


    }
}
