package ua.training.controller.utils;

import ua.training.model.service.resourse.manager.ErrorMessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class InputDataUtils {

    public String readCorrectData(HttpServletRequest request, String parameter, String regex) {
        Locale locale = (Locale) request.getSession().getAttribute("locale");

        String inputData = request.getParameter(parameter);
        request.setAttribute(parameter, inputData);
        if (! inputData.matches(regex)) {
            request.setAttribute("wrong_"+parameter, new ErrorMessageManager(locale).getProperty("wrong." + parseString(parameter)));
            return "0";  //TODO remove return null
        }
        return inputData;
    }

    private String parseString(String str){
        str = str.replaceAll("_",".");
        return str;

    }
}
