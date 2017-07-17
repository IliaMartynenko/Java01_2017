package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.AnswerService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mts7072572 on 17.07.2017.
 */
public class GetAnswerByID implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        AnswerService answerService=serviceFactory.getAnswerService();
        try {

            List<Answer> answerList = answerService.getAnswersByQuestion(Integer.parseInt(request.getParameter("id_question")));

            request.getSession().setAttribute("users",answerList);

            resp="view/allThemes/questionId1.jsp";
        }

        catch(ServiceException e){
            e.printStackTrace();
        }
        return resp;
    }
}
