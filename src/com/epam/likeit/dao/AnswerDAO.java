package com.epam.likeit.dao;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public interface AnswerDAO {
    void createAnswer(Answer answer) throws DAOException;
    Answer read(int id)  throws DAOException;
    void update(Answer answer) throws DAOException;
    void deleteAnswer(int idAnswer) throws DAOException;
    List<Answer> getAll() throws DAOException;
    List<Answer> getAnswerByQuestion(int id) throws DAOException;

}
