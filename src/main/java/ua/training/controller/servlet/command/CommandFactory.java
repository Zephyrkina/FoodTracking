package ua.training.controller.servlet.command;

import ua.training.controller.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command getCommand(HttpServletRequest request) {
        Command current = new EmptyCommand();

        String action = request.getRequestURI();
        action = action.replaceAll(".*/guest/|.*/user/|.*/admin/", "");


        if(action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", current);
        }
        return current;
    }



}

