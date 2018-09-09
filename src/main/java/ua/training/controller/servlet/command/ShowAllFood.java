package ua.training.controller.servlet.command;

import ua.training.model.dto.FoodDTO;
import ua.training.model.entity.Food;
import ua.training.model.service.FoodService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ShowAllFood implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = request.getParameter("recordsPerPage") == null ? 5 : Integer.valueOf(request.getParameter("recordsPerPage"));

        FoodService foodService = new FoodService();
        List<FoodDTO> foodList;

        int rows = foodService.getNumberOfRows();
        int amountOfPages = rows / recordsPerPage;
        if (rows % recordsPerPage > 0) {
            amountOfPages++;
        }
        if (currentPage > amountOfPages) {
            currentPage = amountOfPages;
        }

        foodList = foodService.findAllFood(currentPage, recordsPerPage);


        request.setAttribute("foodList", foodList);
        request.setAttribute("noOfPages", amountOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        return "/WEB-INF/jsp/admin/showAllFood.jsp";

    }
}
