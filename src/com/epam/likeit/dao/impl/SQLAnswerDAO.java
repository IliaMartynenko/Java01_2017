package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.Answer;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import com.epam.likeit.dao.AnswerDAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mts7072572 on 03.06.2017.
 */
public class SQLAnswerDAO implements AnswerDAO {
    private static Logger logger = Logger.getLogger(SQLAnswerDAO.class.getName());
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();
    {dbConnectionPool.createPool();}
    private static final String DELETE = "DELETE FROM answers WHERE id_answer=?";

    private static final String FIND_BY_ID = "SELECT id_answer,id_question,id_user,answer_text,date_of_answer,sum_of_ratings FROM answers WHERE id_answer=?";
    private static final String FIND_ALL = "SELECT id_answer,id_question,id_user,answer_text,date_of_answer,sum_of_ratings FROM answers ORDER BY id_answer";
    private static final String FIND_ALL_BY_QUESTION = "SELECT id_answer,id_question,id_user,answer_text,date_of_answer,sum_of_ratings FROM answers WHERE id_question=? ORDER BY id_answer";
    private static final String INSERT = "insert into answers(id_answer,id_question,id_user,answer_text,date_of_answer,sum_of_ratings) VALUES(null,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE answers SET id_question=?, id_user=?,answer_text=?, date_of_answer=?, sum_of_ratings=? WHERE id_answer=?";







    public static void main(String[] args) {

        SQLAnswerDAO sqlAnswerDAO = new SQLAnswerDAO();
        Answer f=new Answer();





    }





    @Override
    public void createAnswer(Answer answer) throws DAOException {

        try {


            Connection connection = dbConnectionPool.getConnection();


            PreparedStatement statement = connection.prepareStatement(INSERT);

            statement.setInt(1, answer.getIdQuestion());
            statement.setInt(2, answer.getIdUser());
            statement.setString(3, answer.getAnswerText());
            statement.setDate(4, answer.getDateOfAnswer());
            statement.setInt(5, answer.getSumOfRatings());


            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);
        }  catch (SQLException e) {

            logger.error(e);
        }


    }

    public Answer read(int idAnswer) throws DAOException{
        Answer answer=new Answer();
        try
        {
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,idAnswer);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                answer.setIdAnswer(resultSet.getInt("id_answer"));
                answer.setIdQuestion(resultSet.getInt("id_question")); //из результатов запроса
                answer.setIdUser(resultSet.getInt("id_user"));
                answer.setAnswerText(resultSet.getString("answer_text"));
                answer.setDateOfAnswer(resultSet.getDate("date_of_answer"));
                answer.setSumOfRatings(resultSet.getInt("sum_of_ratings"));


            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }
        catch (SQLException e) {

            logger.error(e);
        }
        return answer;

    }

    public void update(Answer answer) throws DAOException {


        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setInt(1, answer.getIdQuestion());
            statement.setInt(2, answer.getIdUser());
            statement.setString(3, answer.getAnswerText());
            statement.setDate(4, answer.getDateOfAnswer());
            statement.setInt(5, answer.getSumOfRatings());

            statement.setInt(6, answer.getIdAnswer());
            statement.executeUpdate();




            dbConnectionPool.closeConnection(connection,statement);
        }  catch (SQLException e) {

            logger.error(e);
        }


    }





    @Override
    public void deleteAnswer(int idAnswer) throws DAOException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setInt(1,idAnswer);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);
        }

        catch (SQLException e) {

            logger.error(e);
        }
    }


    @Override
    public List<Answer> getAll() throws DAOException  {
        List<Answer> Answers = new ArrayList<Answer>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Answer answer = new Answer(); //создаем объект для аккаунта
                answer.setIdAnswer(resultSet.getInt("id_answer"));
                answer.setIdQuestion(resultSet.getInt("id_question")); //из результатов запроса
                answer.setIdUser(resultSet.getInt("id_user"));
                answer.setAnswerText(resultSet.getString("answer_text"));
                answer.setDateOfAnswer(resultSet.getDate("date_of_answer"));
                answer.setSumOfRatings(resultSet.getInt("sum_of_ratings"));

                Answers.add(answer);
                //добавляем созданный объект-аккаунт в список
            }

            dbConnectionPool.closeConnection(connection,statement);

        }  catch (SQLException e) {

            logger.error(e);
        }

        return Answers;
    }


    public List<Answer> getAnswerByQuestion(int id_question) throws DAOException {
        List<Answer> answers=new ArrayList<Answer>();


        try
        {
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_QUESTION);
            statement.setInt(1,id_question);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Answer answer = new Answer(); //создаем объект для аккаунта
                answer.setIdAnswer(resultSet.getInt("id_answer"));
                answer.setIdQuestion(resultSet.getInt("id_question")); //из результатов запроса
                answer.setIdUser(resultSet.getInt("id_user"));
                answer.setAnswerText(resultSet.getString("answer_text"));
                answer.setDateOfAnswer(resultSet.getDate("date_of_answer"));
                answer.setSumOfRatings(resultSet.getInt("sum_of_ratings"));


                answers.add(answer);
                //добавляем созданный объект-аккаунт в список
            }

            dbConnectionPool.closeConnection(connection,statement);
        }
        catch (SQLException e) {

            logger.error(e);
        }
        return answers;

    }


}
