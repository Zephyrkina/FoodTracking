package ua.training.model.service.resourse.manager;

import java.util.Locale;
import java.util.ResourceBundle;

public class RegexManager implements ResourceManager {
    private ResourceBundle bungle;

    public RegexManager(Locale locale) {
        bungle = ResourceBundle.getBundle("regex", locale);
    }

    @Override
    public String getProperty(String key) {
        return bungle.getString(key);
    }
}
