package com.epam.likeit.dao;

import com.epam.likeit.bean.Question;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 28.05.2017.
 */
public interface QuestionDAO {

    void createQuestion(Question Question) throws DAOException;
    Question read(int id) throws DAOException;
    void update(Question answer) throws DAOException;
    void deleteQuestion(int idAnswer) throws DAOException;
    void allowQuestion(int id) throws DAOException;
    List<Question> getAll() throws DAOException;
    List<Question> getQuestionsOrderByDate() throws DAOException;
    List<Question> getQuestionsByTopic(int id_topic) throws DAOException;
    List<Question> getQuestionsSortByAnswers() throws DAOException;
    List<Question> getQuestionAllowedByTopic(int id_topic,String allowed) throws DAOException;
    List<Question>  getQuestionIsAllowed(String allowed) throws DAOException;
}
