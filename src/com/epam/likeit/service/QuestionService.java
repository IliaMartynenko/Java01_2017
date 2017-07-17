package com.epam.likeit.service;

import com.epam.likeit.bean.Question;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface QuestionService {
    void addQuestion(Question question) throws ServiceException;
    void updateQuestion(Question question) throws ServiceException;
    void allowQuestion(int id) throws ServiceException;
    void deleteQuestion(int id) throws ServiceException;
    List<Question> getQuestionOrderByDate() throws ServiceException;
    Question getQuestion(int id) throws ServiceException;
    List<Question> getQuestionByTopicId(int id) throws ServiceException;

    List<Question>  getAllowedQuestions(int id_topic,String allowed) throws ServiceException;
    List<Question> getQuestionIsAllowed(String allowed) throws ServiceException;
    List<Question> getQuestionsByAnswers() throws ServiceException;

}
