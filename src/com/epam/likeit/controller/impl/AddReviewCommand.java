package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Review;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.ReviewService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class AddReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        ReviewService reviewService=serviceFactory.getReviewService();
        try{
            Review review=new Review();
            review.setTextOfReview(request.getParameter("review"));
            review.setDate(new Date(System.currentTimeMillis()));
            review.setRating(Integer.parseInt(request.getParameter("rating")));
            review.setIdUser(3);
            reviewService.addReview(review);


            resp="view/reviews/addReview.jsp";

        }
        catch(ServiceException e){
            e.printStackTrace();
        }
        return resp;

    }
    }

