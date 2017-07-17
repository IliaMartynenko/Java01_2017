package com.epam.likeit.service.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.QuestionDAO;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class QuestionServiceImpl implements com.epam.likeit.service.QuestionService {
    private final DAOFactory daoObjectFactory=DAOFactory.getInstance();
    private final QuestionDAO questionDAO=daoObjectFactory.getQuestionDAO();

    @Override
    public List<Question> getQuestionIsAllowed(String allowed) throws ServiceException {
        List<Question> questions;
        try{
            questions=questionDAO.getQuestionIsAllowed(allowed);
        }

        catch(DAOException e){ throw new ServiceException(e);}
        return questions;

    }
    @Override
    public void addQuestion(Question question) throws ServiceException {
        try{
    questionDAO.createQuestion(question);}
    catch(DAOException e){ throw new ServiceException(e);
    }

    }

    @Override
    public List<Question> getQuestionOrderByDate() throws ServiceException {
        List<Question> questions;
        try{
           questions=questionDAO.getQuestionsOrderByDate();
        }

        catch(DAOException e){ throw new ServiceException(e);}
        return questions;

    }

    @Override
    public Question getQuestion(int id) throws ServiceException {
        Question question;
        try{
            question=questionDAO.read(id);
        }
        catch(DAOException e){throw new ServiceException(e);}

        return question;
    }

    @Override
    public List<Question> getQuestionByTopicId(int id) throws ServiceException {
        List<Question> questions;
        try{
            questions=questionDAO.getQuestionsByTopic(id);
        }
        catch(DAOException e){
            throw new ServiceException(e);
        }
        return questions;
    }

    @Override
    public void deleteQuestion(int id) throws ServiceException {
        try{
            questionDAO.deleteQuestion(id);}
        catch(DAOException e){ throw new ServiceException(e);
        }



    }

    @Override
    public List<Question> getAllowedQuestions(int id_topic,String allowed) throws ServiceException {
        List<Question> questions;
        try{
           questions= questionDAO.getQuestionAllowedByTopic(id_topic,allowed);}
        catch(DAOException e){ throw new ServiceException(e);
        }
        return questions;
    }



    @Override
    public void updateQuestion(Question question) throws ServiceException {
        try{
            questionDAO.update(question);}
        catch(DAOException e){ throw new ServiceException(e);
        }



    }

    @Override
    public void allowQuestion(int id) throws ServiceException {
        try{
            questionDAO.allowQuestion(id);}
        catch(DAOException e){ throw new ServiceException(e);
        }


    }

    public List<Question> getQuestionsByAnswers() throws ServiceException {
        List<Question> questions;
        try{
      questions= questionDAO.getQuestionsSortByAnswers();}
        catch(DAOException e){ throw new ServiceException(e);
        }
        return questions;


    }
}
