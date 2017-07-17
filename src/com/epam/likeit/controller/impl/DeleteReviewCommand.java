package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Review;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.ReviewService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class DeleteReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        ReviewService reviewService=serviceFactory.getReviewService();
        try{
            reviewService.deleteReview(Integer.parseInt(request.getParameter("id_review")));
          List<Review> reviewList= reviewService.getAllReviews();
          request.getSession().setAttribute("reviews",reviewList);
            resp="view/admin/operationsWithReviews.jsp";

        }
        catch(ServiceException e){
            e.printStackTrace();
        }
        return resp;

    }
    }

