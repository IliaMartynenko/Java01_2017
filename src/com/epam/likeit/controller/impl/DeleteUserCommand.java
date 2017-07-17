package com.epam.likeit.controller.impl;

import com.epam.likeit.controller.Command;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        try {
            userService.deleteUser(Integer.parseInt(request.getParameter("id")));
            resp="view/admin/operationsWithUser.jsp";
        }
        catch (ServiceException e){
            e.printStackTrace();
        }
       return resp;
    }
}
