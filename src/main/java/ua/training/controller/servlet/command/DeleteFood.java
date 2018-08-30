package ua.training.controller.servlet.command;

import ua.training.controller.utils.InputDataUtils;
import ua.training.model.service.FoodService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFood implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        FoodService foodService = new FoodService();
        int currentPage = Integer.parseInt(request.getParameter("current_page"));
        int amountOfPages = Integer.parseInt(request.getParameter("no_of_pages"));
        int recordsPerPage = Integer.parseInt(request.getParameter("records_per_page"));


        int foodId = Integer.parseInt(request.getParameter("food_id"));
        foodService.deleteFoodById(foodId);

        return "/app/showAllFood?currentPage="+ currentPage+"&recordsPerPage=" + recordsPerPage;
    }
}
