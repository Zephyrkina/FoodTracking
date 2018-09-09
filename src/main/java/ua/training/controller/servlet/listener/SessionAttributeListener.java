package ua.training.controller.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Locale;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("language")) {
            String locale = (String) httpSessionBindingEvent.getSession().getAttribute("language");
            String lang = locale.substring(0,2);
            String country = locale.substring(3,5);

            httpSessionBindingEvent.getSession().setAttribute("locale", new Locale(lang, country));
        }

    }
}
