package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.Topic;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import com.epam.likeit.dao.TopicDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mts7072572 on 03.06.2017.
 */
public class SQLTopicDAO implements TopicDAO {
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();
    {dbConnectionPool.createPool();}
    private static final String DELETE = "DELETE FROM topics WHERE id_topic=?";

    private static final String FIND_BY_ID = "SELECT id_topic,topic_name FROM topics WHERE id_topic=?";
    private static final String FIND_BY_NAME = "SELECT id_topic,topic_name FROM topics WHERE topic_name=?";
    private static final String FIND_ALL = "SELECT id_topic,topic_name FROM topics ORDER BY id_topic";
    private static final String INSERT = "insert into topics(id_topic,topic_name) VALUES(null,?)";
    private static final String UPDATE = "UPDATE Topics SET topic_name=? WHERE id_topic=?";







    public static void main(String[] args) {






    }





    @Override
    public void createTopic(Topic Topic) throws DAOException {

        try {


            Connection connection = dbConnectionPool.getConnection();


            PreparedStatement statement = connection.prepareStatement(INSERT);

            statement.setString(1, Topic.getTopicName());

            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Topic read(int idTopic) throws DAOException{
        Topic Topic=new Topic();
        try
        {
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,idTopic);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                Topic.setIdTopic(resultSet.getInt("id_topic"));
                Topic.setTopicName(resultSet.getString("topic_name")); //из результатов запроса

            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);

        }
        catch(SQLException e){}
        return Topic;

    }

    public void update(Topic Topic) throws DAOException {


        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement ps = connection.prepareStatement(UPDATE);

            ps.setString(1, Topic.getTopicName());

            ps.executeUpdate();



            dbConnectionPool.closeConnection(connection,ps);

        } catch (SQLException e) {
            //e.printStackTrace();

        }


    }





    @Override
    public void deleteTopic(int idTopic) throws DAOException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setInt(1,idTopic);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);

        }

        catch(Exception e  ){
            e.printStackTrace();
        }
    }


    @Override
    public List<Topic> getAll() throws DAOException {
        List<Topic> topics = new ArrayList<Topic>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Topic topic = new Topic(); //создаем объект для аккаунта
                topic.setIdTopic(resultSet.getInt("id_topic")); //задаем значения всех полей, получая их
                topic.setTopicName(resultSet.getString("topic_name")); //из результатов запроса
                topics.add(topic);
                //добавляем созданный объект-аккаунт в список
            }

            dbConnectionPool.closeConnection(connection,statement);

        } catch (Exception e) {

        }

        return topics;
    }



    @Override
    public Topic getTopicByName(String name) throws DAOException  {
        Topic topic=new Topic();
        try
        {
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                topic.setIdTopic(resultSet.getInt("id_topic"));
                topic.setTopicName(resultSet.getString("topic_name")); //из результатов запроса

            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);

        }
        catch(SQLException e){}
        return topic;

    }
}
