package ua.training.controller.servlet.listener;

import ua.training.model.entity.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Locale;

@WebListener
public class SessionListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //httpSessionEvent.getSession().setMaxInactiveInterval(20);
        httpSessionEvent.getSession().setAttribute("role", User.ROLE.GUEST.toString());
        httpSessionEvent.getSession().setAttribute("locale", new Locale("en","US"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().getServletContext().removeAttribute((String)httpSessionEvent.getSession().getAttribute("login"));
    }
}
