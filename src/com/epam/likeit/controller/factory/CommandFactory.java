package com.epam.likeit.controller.factory;

import com.epam.likeit.controller.Command;
import com.epam.likeit.controller.CommandEnum;
import com.epam.likeit.controller.impl.SignInUserCommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public final class CommandFactory {
    private static Logger logger = Logger.getLogger(CommandFactory.class.getName());
    public static Command defineCommand(HttpServletRequest request){
        Command current = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try{
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());

        }  catch (IllegalArgumentException  e){
            logger.error(e);
        }

        return current;
    }
}
