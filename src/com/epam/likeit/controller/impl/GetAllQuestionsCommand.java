package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
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
public class GetAllQuestionsCommand implements Command {
    private static Logger logger = Logger.getLogger(GetAllQuestionsCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        QuestionService reviewService=serviceFactory.getQuestionService();
        UserService userService=serviceFactory.getUserService();
        try {
            List<Question> questionsList = reviewService.getQuestionOrderByDate();
            List<Question> allowedQuestions = reviewService.getQuestionIsAllowed("yes");
            List<Question> notAllowed = reviewService.getQuestionIsAllowed("no");
            request.getSession().setAttribute("allowed_questions",allowedQuestions);
            request.getSession().setAttribute("not_allowed_questions",notAllowed);

            request.getSession().setAttribute("questions",questionsList);

            resp="view/admin/operationsWithQuestions.jsp";
        }

        catch (ServiceException  e){
            logger.error(e);
        }
        return resp;
    }
}
