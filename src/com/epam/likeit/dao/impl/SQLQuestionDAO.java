package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.Question;
import com.epam.likeit.dao.QuestionDAO;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.ConnectionPoolException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public class SQLQuestionDAO implements QuestionDAO {
    private static Logger logger = Logger.getLogger(SQLQuestionDAO.class.getName());
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();

    {

            dbConnectionPool.createPool();

    }



    private static final String DELETE = "DELETE FROM questions WHERE id_question=?";
    private static final String FIND_BY_ID = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date FROM questions WHERE id_question=?";
    private static final String FIND_ALL_BY_TOPIC = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date FROM questions WHERE id_topic=? ORDER BY date DESC";
    private static final String FIND_ALL_ALLOWED_BY_TOPIC = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date FROM questions WHERE id_topic=? and allowed=? ORDER BY date DESC";
    private static final String FIND_ALL_BY_DATE = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,sum_of_views,allowed,date FROM questions ORDER BY date DESC";
    private static final String FIND_ALL = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,sum_of_views,allowed,date FROM questions ORDER BY id_question";
    private static final String INSERT = "insert into questions(id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date) VALUES(null,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE questions SET id_user=?,id_topic=?,question_text=?,sum_of_answers=?,allowed=?,date=?   WHERE id_question=?";
    private static final String ALLOW = "UPDATE questions SET allowed=yes   WHERE id_question=?";
    private static final String FIND_ALL_BY_ANSWERS = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date FROM questions ORDER BY sum_of_answers DESC";

    private static final String FIND_ALL_IS_ALLOWED = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date FROM questions WHERE allowed='YES' ORDER BY date DESC";
    private static final String FIND_ALL_ALLOWED = "SELECT id_question,id_user,id_topic,question_text,sum_of_answers,allowed,date FROM questions WHERE allowed=? ORDER BY date DESC";

    public static void main(String args[]) throws DAOException {
        SQLQuestionDAO sqlQuestionDAO=new SQLQuestionDAO();
        System.out.print(sqlQuestionDAO.getQuestionIsAllowed("yes").get(12).getText());

    }


    @Override
    public void createQuestion(Question question) throws DAOException {
        Connection connection = dbConnectionPool.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, question.getIdUser());
            statement.setInt(2, question.getIdTopic());
            statement.setString(3, question.getText());
            statement.setInt(4, question.getSumOfanswers());
            statement.setString(5, question.getAllowed());
            statement.setDate(6, question.getDateOfCreate());
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);


        } catch (SQLException e) {
            logger.error(e);
        }



    }

    public Question read(int idQuestion) throws DAOException {
        Question question = new Question();
        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1, idQuestion);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if (resultSet.next()) {
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));

                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

            }


            dbConnectionPool.closeConnection(connection,statement,resultSet);
        } catch (SQLException e) {
            logger.error(e);
        }
        return question;

    }

    public void update(Question question) throws DAOException {


        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(UPDATE);


            statement.setInt(1, question.getIdUser());
            statement.setInt(2, question.getIdTopic());
            statement.setString(3, question.getText());
            statement.setInt(4, question.getSumOfanswers());

            statement.setString(5, question.getAllowed());
            statement.setDate(6, question.getDateOfCreate());
            statement.setInt(7, question.getIdQuestion());
            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);

        } catch (SQLException e) {
            logger.error(e);
        }

    }


    @Override
    public void deleteQuestion(int idQuestion) throws DAOException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, idQuestion);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);

        } catch (SQLException e) {
            logger.error(e);
        }
    }


    @Override
    public List<Question> getAll() throws DAOException {
        List<Question> questions = new ArrayList<Question>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Question question = new Question(); //создаем объект для аккаунта
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));
                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

                questions.add(question); //добавляем созданный объект-аккаунт в список
            }


            dbConnectionPool.closeConnection(connection,statement);

        } catch (SQLException e) {
            logger.error(e);
        }

        return questions;
    }

    public List<Question> getQuestionsOrderByDate() throws DAOException {
        List<Question> questions = new ArrayList<Question>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_IS_ALLOWED);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Question question = new Question(); //создаем объект для аккаунта
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));
                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

                questions.add(question); //добавляем созданный объект-аккаунт в список
            }


            dbConnectionPool.closeConnection(connection,statement,resultSet);

        } catch (SQLException e) {
            logger.error(e);
        }

        return questions;
    }


    public List<Question> getQuestionsByTopic(int id_topic) throws DAOException {
        List<Question> questions = new ArrayList<Question>();
        try {


            Connection connection = dbConnectionPool.getConnection();

            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_TOPIC);
            statement.setInt(1, id_topic);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Question question = new Question(); //создаем объект для аккаунта
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));
                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

                questions.add(question); //добавляем созданный объект-аккаунт в список
            }


            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }catch (SQLException e) {
            logger.error(e);
        }

        return questions;


    }

    public List<Question> getQuestionsSortByAnswers() throws DAOException {
        List<Question> questions = new ArrayList<Question>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_BY_ANSWERS);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Question question = new Question(); //создаем объект для аккаунта
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));
                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

                questions.add(question); //добавляем созданный объект-аккаунт в список
            }


            dbConnectionPool.closeConnection(connection,statement,resultSet);

        }catch (SQLException e) {
            logger.error(e);
        }

        return questions;
    }

    public List<Question> getQuestionAllowedByTopic(int id_topic, String allowed) throws DAOException {
        List<Question> questions = new ArrayList<Question>();
        try {


            Connection connection = dbConnectionPool.getConnection();

            PreparedStatement statement = connection.prepareStatement(FIND_ALL_ALLOWED_BY_TOPIC);
            statement.setInt(1, id_topic);
            statement.setString(2, allowed);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Question question = new Question(); //создаем объект для аккаунта
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));
                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

                questions.add(question); //добавляем созданный объект-аккаунт в список
            }


            dbConnectionPool.closeConnection(connection,statement,resultSet);

        } catch (SQLException e) {
            logger.error(e);
        }

        return questions;
    }


    public List<Question> getQuestionIsAllowed(String allowed) throws DAOException {
        List<Question> questions = new ArrayList<Question>();
        try {


            Connection connection = dbConnectionPool.getConnection();

            PreparedStatement statement = connection.prepareStatement(FIND_ALL_ALLOWED);

            statement.setString(1, allowed);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Question question = new Question(); //создаем объект для аккаунта
                question.setIdQuestion(resultSet.getInt("id_question"));
                question.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                question.setIdTopic(resultSet.getInt("id_topic"));
                question.setText(resultSet.getString("question_text"));
                question.setSumOfanswers(resultSet.getInt("sum_of_answers"));
                question.setAllowed(resultSet.getString("allowed"));
                question.setDateOfCreate(resultSet.getDate("date"));

                questions.add(question); //добавляем созданный объект-аккаунт в список
            }


            dbConnectionPool.closeConnection(connection,statement,resultSet);

        } catch (SQLException e) {
            logger.error(e);
        }
        return questions;
    }







    public void allowQuestion(int id) throws DAOException {

        Connection connection = dbConnectionPool.getConnection();
        Question question=read(id);
        try {

            PreparedStatement statement = connection.prepareStatement(ALLOW);



            statement.setInt(1, question.getIdQuestion());
            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);

        } catch (SQLException e) {
            logger.error(e);
        }

    }



}
