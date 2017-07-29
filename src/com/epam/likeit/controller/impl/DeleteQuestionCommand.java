package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import com.epam.likeit.service.impl.QuestionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class DeleteQuestionCommand implements Command {
    private static Logger logger = Logger.getLogger(DeleteQuestionCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        QuestionService questionService=serviceFactory.getQuestionService();

        try{

            questionService.deleteQuestion(Integer.parseInt(request.getParameter("id_question")));
            List<Question> allowedQuestions = questionService.getQuestionIsAllowed("yes");
            List<Question> notAllowed = questionService.getQuestionIsAllowed("no");
            request.getSession().setAttribute("allowed_questions",allowedQuestions);
            request.getSession().setAttribute("not_allowed_questions",notAllowed);


            resp="view/admin/operationsWithQuestions.jsp";

        }
        catch (ServiceException  e){
            logger.error(e);
        }
        return resp;

    }
}
