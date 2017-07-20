package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 19.07.2017.
 */
public class GetRatingsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        try {
            resp="view/users/userRatings.jsp";
            List<User> userList = userService.getAllUsers();
            for(User user:userList){
                user.setPassword("");
            }
            request.getSession().setAttribute("users",userList);
        }
        catch(ServiceException e){
            e.printStackTrace();
        }
            return resp;
    }
}
