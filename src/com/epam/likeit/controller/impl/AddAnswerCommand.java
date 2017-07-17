package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.AnswerService;
import com.epam.likeit.service.BannedUserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class AddAnswerCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String resp=null;
        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        AnswerService answerService=serviceFactory.getAnswerService();
        try {
            BannedUserService bannedUserService = serviceFactory.getBannedUserService();
            int id_user = Integer.parseInt(request.getParameter("id_user"));
            boolean isBanned = bannedUserService.isBanned(id_user);
            if (isBanned) {
                resp="view/errors/banError.jsp";
            } else {
                int id_question=Integer.parseInt(request.getParameter("id_question"));
                Answer answer=new Answer();
                answer.setIdUser(id_user);
                answer.setAnswerText(request.getParameter("answer"));
                answer.setIdQuestion(id_question);
                answer.setDateOfAnswer(new Date(System.currentTimeMillis()));
                answerService.addAnswer(answer);
                resp="view/allThemes/questionId"+id_question+".jsp";

                return resp;

            }
        }
        catch(ServiceException e){}
        return resp;

    }

}

