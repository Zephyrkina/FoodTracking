package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.service.FoodService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFood implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int currentPage = Integer.parseInt(request.getParameter("current_page"));
        int recordsPerPage = Integer.parseInt(request.getParameter("records_per_page"));


        new FoodService().deleteFoodById(Integer.parseInt(request.getParameter("food_id")));

        return "/admin/showAllFood?currentPage="+ currentPage+"&recordsPerPage=" + recordsPerPage;
    }
}
