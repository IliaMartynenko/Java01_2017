package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.controller.contextlistener.ServletContextExample;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by mts7072572 on 18.07.2017.
 */
public class AddPlusCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        try {
            User user = userService.getUser(Integer.parseInt(request.getParameter("id_user")));
            user.setNumberOfRatings(user.getNumberOfRatings() + 1);
            userService.updateUser(user);
           HashMap<Integer,Integer> rating=(HashMap)request.getSession().getAttribute("user_ratings");
           int id_answer=Integer.parseInt(request.getParameter("id_answer"));
           int ratings=rating.get(id_answer);
           rating.put(id_answer,ratings+1);





        }
        catch(ServiceException e){}

        return "view/allThemes/questionId1.jsp";
    }
}
