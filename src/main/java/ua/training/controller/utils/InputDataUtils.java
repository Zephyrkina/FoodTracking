package ua.training.controller.utils;

import ua.training.model.service.resourse.manager.ErrorMessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Locale;

public class InputDataUtils {

    public String readCorrectData(HttpServletRequest request, String parameter, String regex) {
        Locale locale = (Locale) request.getSession().getAttribute("locale");

        String inputData = request.getParameter(parameter);
        request.setAttribute(parameter, inputData);
        if (! inputData.matches(regex)) {
            request.setAttribute("wrong_"+parameter, new ErrorMessageManager(locale).getProperty("wrong." + parseString(parameter)));
            return "0";
        }
        return inputData;
    }

    private String parseString(String str){
        str = str.replaceAll("_",".");
        return str;

    }

    public boolean checkWrongInput(HttpServletRequest request) {
        Enumeration<String> requestAttributeNames = request.getAttributeNames();

        while(requestAttributeNames.hasMoreElements()){
            String attrName = requestAttributeNames.nextElement();
            if (attrName.contains("wrong")){
                return true;
            }
        }
        return false;
    }
}
