package com.epam.likeit.controller.factory;

import com.epam.likeit.controller.Command;
import com.epam.likeit.controller.CommandEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public final class CommandFactory {

    public static Command defineCommand(HttpServletRequest request){
        Command current = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try{
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());

        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + " WRONG_ACTION");
        }

        return current;
    }
}
