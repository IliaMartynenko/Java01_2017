package com.epam.likeit.controller.contextlistener;

import com.epam.likeit.bean.Question;
import com.epam.likeit.bean.Review;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.ReviewService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import com.epam.likeit.service.impl.QuestionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ServletContextExample implements ServletContextListener{
    private static Logger logger = Logger.getLogger(ServletContextExample.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServiceFactory serviceFactory=ServiceFactory.getInstance();
            QuestionService questionService=serviceFactory.getQuestionService();
            ReviewService reviewServiceService=serviceFactory.getReviewService();
            UserService userService=serviceFactory.getUserService();


            servletContextEvent.getServletContext().setAttribute("questions_by_answers", questionService.getQuestionsByAnswers());
            servletContextEvent.getServletContext().setAttribute("allowed_questions", questionService.getQuestionIsAllowed("yes"));
            servletContextEvent.getServletContext().setAttribute("all_questions", questionService.getQuestionOrderByDate());
            servletContextEvent.getServletContext().setAttribute("not_allowed_questions", questionService.getQuestionIsAllowed("no"));
            servletContextEvent.getServletContext().setAttribute("reviews", reviewServiceService.getAllReviews());
            servletContextEvent.getServletContext().setAttribute("users", userService.getAllUsers());



        }
        catch (ServiceException  e){
            logger.error(e);
        }
    }
}