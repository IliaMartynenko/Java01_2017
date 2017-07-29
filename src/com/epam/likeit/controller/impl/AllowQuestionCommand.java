package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 18.07.2017.
 */
public class AllowQuestionCommand implements Command {
    private static Logger logger = Logger.getLogger(AllowQuestionCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        QuestionService questionService=serviceFactory.getQuestionService();
        try {
            Question question = questionService.getQuestion(Integer.parseInt(request.getParameter("id_question")));
            question.setAllowed("yes");
            questionService.updateQuestion(question);

            request.getSession().setAttribute("allowed_questions",questionService.getQuestionIsAllowed("yes"));
            request.getSession().setAttribute("not_allowed_questions",questionService.getQuestionIsAllowed("no"));

        }
        catch (ServiceException  e){
            logger.error(e);
        }
        return "view/admin/operationsWithQuestions.jsp";
    }
}
