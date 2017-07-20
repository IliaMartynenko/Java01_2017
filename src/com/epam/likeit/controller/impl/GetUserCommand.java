package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 20.07.2017.
 */
public class GetUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        String resp="view/users/userPage.jsp";
        try {
            User user = userService.getUser(Integer.parseInt(request.getParameter("id_user")));
            user.setPassword("");
            request.getSession().setAttribute("user_information", user);
        }
        catch (ServiceException e){
            e.printStackTrace();
        }
        return resp;
    }
}
