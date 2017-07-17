package com.epam.likeit.service;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface AnswerService {
    void addAnswer(Answer answer) throws ServiceException;
    void deleteAnswer(int id) throws ServiceException;
    void updateAnswer(Answer answer) throws ServiceException;
    Answer getAnswer(int id) throws ServiceException;
    List<Answer> getAnswersByQuestion(int id) throws ServiceException;
    List<Answer> getAll() throws ServiceException;

}
