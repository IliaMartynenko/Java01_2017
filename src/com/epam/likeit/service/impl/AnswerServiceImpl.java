package com.epam.likeit.service.impl;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.AnswerDAO;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class AnswerServiceImpl implements com.epam.likeit.service.AnswerService {
    private final DAOFactory daoObjectFactory= DAOFactory.getInstance();
    private final AnswerDAO answerDAO=daoObjectFactory.getAnswerDAO();
    @Override
    public void addAnswer(Answer answer) throws ServiceException {
        try{
        answerDAO.createAnswer(answer);}
        catch(DAOException e){ throw new ServiceException(e);
        }
    }

    @Override
    public Answer getAnswer(int id) throws ServiceException {

        Answer answer;
        try{
        answer=answerDAO.read(id);}
        catch(DAOException e){ throw new ServiceException(e);
        }
        return answer;
    }

    @Override
    public List<Answer> getAnswersByQuestion(int id) throws ServiceException {
        List<Answer> answers;
        try {
           answers = answerDAO.getAnswerByQuestion(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return answers;
    }

    @Override
    public void deleteAnswer(int id) throws ServiceException{
        try{
        answerDAO.deleteAnswer(id);}
        catch(DAOException e){ throw new ServiceException(e);
        }

    }

    @Override
    public void updateAnswer(Answer answer) throws ServiceException {
        try {
            answerDAO.update(answer);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }

    }
    public List<Answer> getAll() throws ServiceException{
        List<Answer> answers;
        try {
         answers = answerDAO.getAll();
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return answers;
    }
}
