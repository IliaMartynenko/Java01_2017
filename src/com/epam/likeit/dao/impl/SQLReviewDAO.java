package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.Review;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import com.epam.likeit.dao.ReviewDAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mts7072572 on 03.06.2017.
 */
public class SQLReviewDAO implements ReviewDAO {
    private static Logger logger = Logger.getLogger(SQLReviewDAO.class.getName());
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();
    {dbConnectionPool.createPool();}
    private static final String DELETE = "DELETE FROM reviews WHERE id_reviews=?";
    private static final String FIND_BY_ID = "SELECT id_reviews,id_user,date,text_of_review,rating FROM reviews WHERE id_reviews=?";
    private static final String FIND_ALL = "SELECT id_reviews,id_user,date,text_of_review,rating FROM reviews ORDER BY id_reviews";
    private static final String INSERT = "insert into reviews(id_reviews,id_user,date,text_of_review,rating) VALUES(null,?,?,?,?)";
    private static final String UPDATE = "UPDATE reviews SET id_review=?,id_user=?,date=?,text_of_review?,rating=?  WHERE id_review=?";







    public static void main(String[] args) {




    }





    @Override
    public void createReview(Review review) throws DAOException {

        try {


            Connection connection = dbConnectionPool.getConnection();


            PreparedStatement statement = connection.prepareStatement(INSERT);

            statement.setInt(1, review.getIdUser());
            statement.setDate(2, review.getDate());
            statement.setString(3, review.getTextOfReview());
            statement.setDouble(4, review.getRating());

            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);
        } catch (SQLException e) {
            logger.error(e);
        }


    }

    public Review read(int idReview) throws DAOException{
        Review review=new Review();
        try
        {
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,idReview);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                review.setIdReviews(resultSet.getInt("id_reviews"));
                review.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                review.setDate(resultSet.getDate("date"));
                review.setRating(resultSet.getDouble("rating"));


            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }
        catch (SQLException e) {
            logger.error(e);
        }
        return review;

    }

    public void update(Review review) throws DAOException {


        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(UPDATE);


            statement.setDate(1, review.getDate());
            statement.setString(2, review.getTextOfReview());
            statement.setDouble(3, review.getRating());
            statement.setInt(4, review.getIdUser());
            statement.executeUpdate();



            dbConnectionPool.closeConnection(connection,statement);
        } catch (SQLException e) {
            logger.error(e);
        }


    }





    @Override
    public void deleteReview(int idReview) throws DAOException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setInt(1,idReview);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);
        }

        catch (SQLException e) {
            logger.error(e);
        }
    }


    @Override
    public List<Review> getAll() throws DAOException {
        List<Review> reviews = new ArrayList<Review>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Review review = new Review(); //создаем объект для аккаунта
                review.setIdReviews(resultSet.getInt("id_reviews"));
                review.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                review.setDate(resultSet.getDate("date"));
                review.setRating(resultSet.getDouble("rating"));
                review.setTextOfReview(resultSet.getString("text_of_review"));

                reviews.add(review);
                //добавляем созданный объект-аккаунт в список
            }

            dbConnectionPool.closeConnection(connection,statement);

        } catch (SQLException e) {
            logger.error(e);
        }

        return reviews;
    }
}
