package com.epam.likeit.service;

import com.epam.likeit.bean.Topic;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface TopicService {
    void deleteTopic(int id)throws ServiceException;
    void addTopic(Topic user) throws ServiceException;
    Topic getTopic(int id) throws ServiceException;
    List<Topic> getAllTopics() throws ServiceException;
    Topic getTopicByName(String name) throws ServiceException;
}
