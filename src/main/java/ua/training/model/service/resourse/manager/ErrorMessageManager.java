package ua.training.model.service.resourse.manager;

import java.util.Locale;
import java.util.ResourceBundle;

public class ErrorMessageManager implements ResourceManager {
    private ResourceBundle bungle;

    public ErrorMessageManager(Locale locale) {
        bungle = ResourceBundle.getBundle("errorMessages", locale);
    }

    @Override
    public String getProperty(String key) {
        return bungle.getString(key);
    }
}
