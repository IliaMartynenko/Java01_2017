package com.epam.likeit.controller.impl;

import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import com.epam.likeit.service.impl.QuestionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class DeleteQuestionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        QuestionService questionService=serviceFactory.getQuestionService();
        try{
            questionService.deleteQuestion(Integer.parseInt(request.getParameter("id_question")));
            resp="view/admin/operationsWithQuestions.jsp";

        }
    catch(ServiceException e){
            e.printStackTrace();
    }
        return resp;

    }
}
