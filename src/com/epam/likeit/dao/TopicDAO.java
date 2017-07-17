package com.epam.likeit.dao;

import com.epam.likeit.bean.Topic;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public interface TopicDAO {
    void createTopic(Topic Topic) throws DAOException;
    Topic read(int id) throws DAOException;
    void update(Topic topic) throws DAOException;
    void deleteTopic(int idTopic) throws DAOException;
    List<Topic> getAll() throws DAOException;
    Topic getTopicByName(String name) throws DAOException;


}
