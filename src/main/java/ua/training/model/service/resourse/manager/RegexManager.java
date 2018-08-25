package ua.training.model.service.resourse.manager;

import java.util.ResourceBundle;

public class RegexManager implements ResourceManager {
    private ResourceBundle bungle;

    public RegexManager() {
        bungle = ResourceBundle.getBundle("regex");
    }

    @Override
    public String getProperty(String key) {
        return bungle.getString(key);
    }
}
