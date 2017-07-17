package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 17.07.2017.
 */
public class SignInUser implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        try {
        int id=userService.signIn(request.getParameter("login"), request.getParameter("password"));

            if (id != 0){
               User user= userService.getUser(id);
               request.getSession().setAttribute("user",user);
               return "view/signin/helloUser.jsp";
            }


        }
        catch (ServiceException e){e.printStackTrace();}

        return "view/signin/signError.jsp";
    }
}
