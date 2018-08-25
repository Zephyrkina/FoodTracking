package ua.training.model.service.resourse.manager;

import java.util.ResourceBundle;

public class ErrorMessageManager implements ResourceManager {
    private ResourceBundle bungle;

    public ErrorMessageManager() {
        bungle = ResourceBundle.getBundle("errorMessage");
    }

    @Override
    public String getProperty(String key) {
        return bungle.getString(key);
    }
}
