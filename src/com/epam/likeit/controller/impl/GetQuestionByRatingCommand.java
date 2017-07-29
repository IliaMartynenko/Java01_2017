package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 20.07.2017.
 */
public class GetQuestionByRatingCommand implements Command {
    private static Logger logger = Logger.getLogger(GetQuestionByRatingCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        QuestionService questionService=serviceFactory.getQuestionService();
        try {
            List<Question> questionList = questionService.getQuestionsByAnswers();
            request.getSession().setAttribute("question_by_rating",questionList);

        }
        catch (ServiceException  e){
            logger.error(e);
        }
        return "view/questions/popularQuestions.jsp";
    }
}
