package ua.training.controller.servlet.command;

import ua.training.model.exception.OperationFailedException;
import ua.training.model.service.DailyRecordService;
import ua.training.model.service.FoodService;
import ua.training.model.service.UserService;
import ua.training.model.service.resourse.manager.ErrorMessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class SavePreviousRecords implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Locale locale = (Locale) request.getSession().getAttribute("locale");

        try {
            new DailyRecordService().savePreviousRecords(new UserService()
                    .getUserIdByLogin((String)request.getSession().getAttribute("login")), LocalDate.now());
            request.setAttribute("savedRecords",  new ErrorMessageManager(locale).getProperty("saved.all.records"));

        } catch (OperationFailedException e) {
            request.setAttribute("notSavedRecords",  new ErrorMessageManager(locale).getProperty("records.not.saved"));
        }


        return "/WEB-INF/jsp/user/user_page.jsp";
    }
}
