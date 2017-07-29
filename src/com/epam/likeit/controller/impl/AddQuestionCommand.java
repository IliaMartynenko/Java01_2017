package com.epam.likeit.controller.impl;


import com.epam.likeit.bean.Question;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.BannedUserService;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.TopicService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class AddQuestionCommand implements Command {
    private static Logger logger = Logger.getLogger(AddQuestionCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("user_id") == null) {
            return "view/errors/questionError.jsp";
        }

        else {
            String resp = null;
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            QuestionService questionService = serviceFactory.getQuestionService();
            TopicService topicService = serviceFactory.getTopicService();
            BannedUserService bannedUserService = serviceFactory.getBannedUserService();
            Question question = new Question();
            int id_user = Integer.parseInt(request.getParameter("id_user"));

            try {
                boolean isBanned = bannedUserService.isBanned(id_user);
                if (isBanned) {
                    request.getSession().setAttribute("banned_user", bannedUserService.readByUserId(id_user));
                    resp = "view/errors/banError.jsp";
                } else {

                    int idTopic = topicService.getTopicByName(request.getParameter("topic")).getIdTopic();
                    question.setAllowed("NO");
                    question.setText(request.getParameter("question"));
                    question.setIdTopic(idTopic);
                    question.setDateOfCreate(new Date(System.currentTimeMillis()));
                    question.setIdUser(id_user);

                    questionService.addQuestion(question);
                    resp = "view/questions/questionSucess.jsp";
                }
            } catch (ServiceException  e){
                logger.error(e);
            }


            return resp;
        }


    }

}
