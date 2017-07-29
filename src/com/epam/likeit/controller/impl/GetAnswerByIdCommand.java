package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.bean.Question;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.AnswerService;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;
import com.epam.likeit.service.impl.QuestionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mts7072572 on 17.07.2017.
 */
public class GetAnswerByIdCommand implements Command {
    private static Logger logger = Logger.getLogger(GetAnswerByIdCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        AnswerService answerService=serviceFactory.getAnswerService();
        UserService userService=serviceFactory.getUserService();
        QuestionService questionService=serviceFactory.getQuestionService();
        int id_question=Integer.parseInt(request.getParameter("id_question"));

        try {
            Map<Integer,String> userNameMap=new HashMap<Integer,String>();
            Map<Integer,Integer> userRatingsMap=new HashMap<Integer,Integer>();
            List<User> users=userService.getAllUsers();
            List<Question> questions=questionService.getAllowedQuestions(1,"yes");
            List<Answer> answerList = answerService.getAnswersByQuestion(id_question);

            User user=userService.getUser(questionService.getQuestion(id_question).getIdUser());
            String user_name=user.getName();


            for(Answer answer:answerList){
                int id_answer=answer.getIdAnswer();
                User user1=userService.getUser(answer.getIdUser());
                userNameMap.put(id_answer,user1.getName());
                userRatingsMap.put(id_answer,user1.getNumberOfRatings());
            }
            Question question=questionService.getQuestion(id_question);
            request.getSession().setAttribute("question",question);
            request.getSession().setAttribute("answers",answerList);
            request.getSession().setAttribute("questions_by_topic",questions);
            request.getSession().setAttribute("users_by_answers",userNameMap);
            request.getSession().setAttribute("user_name",user_name);
            request.getSession().setAttribute("user_ratings",userRatingsMap);



            resp="view/allThemes/questionId1.jsp";
        }

        catch (ServiceException  e){
            logger.error(e);
        }
        return resp;
    }
}
