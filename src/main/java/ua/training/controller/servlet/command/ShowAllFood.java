package ua.training.controller.servlet.command;

import ua.training.model.entity.Food;
import ua.training.model.exception.ItemNotFoundException;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllFood implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        UserService userService = new UserService();
        List<Food> foodList;
        try {
             foodList = userService.findAllFood(currentPage, recordsPerPage);

        } catch (ItemNotFoundException e) {
            --currentPage;
            return "redirect:/app/showAllFood?recordsPerPage="+recordsPerPage+"&currentPage="+currentPage;

        }
        request.setAttribute("foodList", foodList);

        int rows = userService.getNumberOfRows();
        int amountOfPages = rows / recordsPerPage;
        if (rows % recordsPerPage > 0) {
            amountOfPages++;
        }

        request.setAttribute("noOfPages", amountOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        return "/jsp/admin/showAllFood.jsp";

    }
}
