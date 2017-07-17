package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class GetAllQuestionsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        QuestionService reviewService=serviceFactory.getQuestionService();
        UserService userService=serviceFactory.getUserService();
        try {
            List<Question> questionsList = reviewService.getQuestionOrderByDate();

            request.getSession().setAttribute("questions",questionsList);
            resp="view/admin/operationsWithReviews.jsp";
        }

        catch(ServiceException e){
            e.printStackTrace();
        }
        return resp;
    }
}
