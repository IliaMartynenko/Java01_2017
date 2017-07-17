package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Review;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.ReviewService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class GetAllReviewsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        ReviewService reviewService=serviceFactory.getReviewService();
        UserService userService=serviceFactory.getUserService();
        try {
            List<Review> reviewList = reviewService.getAllReviews();
            List<User> usersList = userService.getAllUsers();
            request.getSession().setAttribute("reviews",reviewList);
            request.getSession().setAttribute("dsa","fads");
            request.setAttribute("users",usersList);




            resp="view/admin/operationsWithReviews.jsp";
        }

        catch(ServiceException  e){
            e.printStackTrace();
        }
return resp;
    }
}
