package com.epam.likeit.service.impl;

import com.epam.likeit.bean.Topic;
import com.epam.likeit.dao.TopicDAO;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.TopicService;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class TopicServiceImpl implements TopicService {
    private final DAOFactory daoObjectFactory= DAOFactory.getInstance();
    private final TopicDAO topicDAO=daoObjectFactory.getTopicDAO();
    @Override
    public void deleteTopic(int id)throws ServiceException {
        try {
            topicDAO.deleteTopic(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
    }

    @Override
    public void addTopic(Topic topic) throws ServiceException {
        try {
            topicDAO.createTopic(topic);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }

    }

    @Override
    public Topic getTopic(int id) throws ServiceException {
        Topic topic;
        try{
        topic=topicDAO.read(id);}
        catch(DAOException e){ throw new ServiceException(e);
        }
        return topic;
    }

    @Override
    public List<Topic> getAllTopics() throws ServiceException {
        List<Topic> topics;
        try{
       topics=topicDAO.getAll();
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return topics;
    }

    @Override
    public Topic getTopicByName(String name) throws ServiceException {
        Topic topic;
        try{
        topic=topicDAO.getTopicByName(name);}
        catch(DAOException e){ throw new ServiceException(e);
        }
        return topic;
    }
}
