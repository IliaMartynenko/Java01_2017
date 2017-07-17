package com.epam.likeit.dao.daofactory;

import com.epam.likeit.dao.*;
import com.epam.likeit.dao.impl.*;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public final class DAOFactory {
    private static final DAOFactory instance=new DAOFactory();
    private  final AdminDAO sqlAdminImpl=new SQLAdminDAO();
    private final AnswerDAO sqlAnswerImpl=new SQLAnswerDAO();
    private final BannedUserDAO sqlBannedUserImpl=new SQLBannedUserDAO();
    private final QuestionDAO sqlQuestionImpl=new SQLQuestionDAO();
    private final ReviewDAO sqlReviewImpl=new SQLReviewDAO();
    private final TopicDAO sqlTopicImpl=new SQLTopicDAO();
    private final UserDAO sqlUserImpl=new SQLUserDAO();
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public AdminDAO getAdminDAO() {
        return sqlAdminImpl;
    }

    public AnswerDAO getAnswerDAO() {
        return sqlAnswerImpl;
    }

    public BannedUserDAO getBannedUserDAO() {
        return sqlBannedUserImpl;
    }



    public QuestionDAO getQuestionDAO() {
        return sqlQuestionImpl;
    }

    public ReviewDAO getReviewDAO() {
        return sqlReviewImpl;
    }

    public TopicDAO getTopicDAO() {
        return sqlTopicImpl;
    }



    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }
}
