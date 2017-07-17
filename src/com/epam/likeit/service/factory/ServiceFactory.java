package com.epam.likeit.service.factory;


import com.epam.likeit.bean.Topic;
import com.epam.likeit.service.*;

import com.epam.likeit.service.impl.*;


/**
 * Created by mts7072572 on 13.07.2017.
 */
public final class ServiceFactory {
        private static final ServiceFactory instance = new ServiceFactory();
        private final UserService userService = new UserServiceImpl();
        private final AnswerService answerService = new AnswerServiceImpl();
        private final ReviewService reviewService = new ReviewServiceImpl();
        private final QuestionService questionService = new QuestionServiceImpl();
        private final TopicService topicService = new TopicServiceImpl();
        private final BannedUserService bannedUserService = new BannedUserImpl();

    public BannedUserService getBannedUserService() {
        return bannedUserService;
    }

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public TopicService getTopicService() {return topicService; }

    public UserService getUserService() {
        return userService;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public ReviewService getReviewService() {
        return reviewService;
    }

    public com.epam.likeit.service.QuestionService getQuestionService() {
        return questionService;
    }
}
