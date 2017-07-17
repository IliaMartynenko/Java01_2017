package com.epam.likeit.controller.impl;


import com.epam.likeit.bean.Question;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.TopicService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class AddQuestionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        QuestionService questionService=serviceFactory.getQuestionService();
        TopicService topicService=serviceFactory.getTopicService();
        Question question=new Question();
        try{
            int idTopic=topicService.getTopicByName(request.getParameter("topic")).getIdTopic();
            question.setAllowed("NO");
            question.setText(request.getParameter("question"));
            question.setIdTopic(idTopic);
            question.setDateOfCreate(new Date(System.currentTimeMillis()));
            question.setIdUser(Integer.parseInt(request.getParameter("id")));

            questionService.addQuestion(question);
            resp="view/questions/questionSucess.jsp";
        }
        catch(ServiceException e){

            e.printStackTrace();
        }


            return resp;

    }

}
