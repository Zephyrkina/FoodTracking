package ua.training.controller.utils;

import ua.training.model.service.resourse.manager.ErrorMessageManager;

import javax.servlet.http.HttpServletRequest;

public class InputDataUtils {

    public String readCorrectData(HttpServletRequest request, String parameter, String regex) {
        String inputData = request.getParameter(parameter).toLowerCase();
        request.setAttribute(parameter, inputData);
        if (! inputData.matches(regex)) {
            request.setAttribute("wrong_"+parameter, new ErrorMessageManager().getProperty("wrong." + parseString(parameter)));
            return null;  //TODO remove return null
        }
        return inputData;
    }

    private String parseString(String str){
        str = str.replaceAll("_",".");
        return str;

    }
}
