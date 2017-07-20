package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.bean.Question;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.AnswerService;
import com.epam.likeit.service.BannedUserService;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class AddAnswerCommand implements Command {
    ServiceFactory serviceFactory=ServiceFactory.getInstance();
    AnswerService answerService=serviceFactory.getAnswerService();
    BannedUserService bannedUserService = serviceFactory.getBannedUserService();
    UserService userService=serviceFactory.getUserService();
    QuestionService questionService=serviceFactory.getQuestionService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("id_user") == null) {
            return "view/errors/answerError.jsp";
        }
        else {
            String resp = null;
            int id_question = Integer.parseInt(request.getParameter("id_question"));

            try {
                Question question = questionService.getQuestion(id_question);
                Map<Integer, String> userNameMap = new HashMap<Integer, String>();
                Map<Integer, Integer> userRatingsMap = new HashMap<Integer, Integer>();
                int id_user = Integer.parseInt(request.getParameter("id_user"));
                boolean isBanned = bannedUserService.isBanned(id_user);
                if (isBanned) {
                    request.getSession().setAttribute("banned_user", bannedUserService.readByUserId(id_user));
                    resp = "view/errors/banError.jsp";
                } else {

                    Answer answer = new Answer();
                    answer.setIdUser(id_user);
                    answer.setAnswerText(request.getParameter("answer"));
                    answer.setIdQuestion(id_question);
                    answer.setDateOfAnswer(new Date(System.currentTimeMillis()));
                    answerService.addAnswer(answer);
                    question.setSumOfanswers(question.getSumOfanswers() + 1);
                    questionService.updateQuestion(question);
                    List<Answer> answerList = answerService.getAnswersByQuestion(id_question);


                    for (Answer answer1 : answerList) {
                        int id_answer = answer1.getIdAnswer();
                        User user1 = userService.getUser(answer1.getIdUser());
                        userNameMap.put(id_answer, user1.getName());
                        userRatingsMap.put(id_answer, user1.getNumberOfRatings());
                    }
                    request.getSession().setAttribute("user_ratings", userRatingsMap);
                    request.getSession().setAttribute("answers", answerList);
                    request.getSession().setAttribute("users_by_answers", userNameMap);


                    resp = "view/allThemes/questionId1.jsp";

                    return resp;

                }

            } catch (ServiceException e) {
            }
            return resp;
        }

    }

}

