package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Review;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.ReviewService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class DeleteReviewCommand implements Command {
    private static Logger logger = Logger.getLogger(DeleteReviewCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        ReviewService reviewService=serviceFactory.getReviewService();
        UserService userService=serviceFactory.getUserService();
        try{
            reviewService.deleteReview(Integer.parseInt(request.getParameter("id_review")));
          List<Review> reviewList= reviewService.getAllReviews();
          List<User> userList=userService.getAllUsers();
          request.getSession().setAttribute("reviews",reviewList);
          request.getSession().setAttribute("users",userList);



            resp="view/admin/operationsWithReviews.jsp";

        }
        catch (ServiceException  e){
            logger.error(e);
        }
        return resp;

    }
    }

