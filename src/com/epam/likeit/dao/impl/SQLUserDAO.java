package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.ConnectionPoolException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import com.epam.likeit.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mts7072572 on 28.05.2017.
 */
public class SQLUserDAO implements UserDAO {
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();
    {
            dbConnectionPool.createPool();

        }
    private static final String DELETE = "DELETE FROM users WHERE id_user=?";
    private static final String DELETE_BY_NAME = "DELETE FROM users WHERE name=?";

    private static final String FIND_BY_ID = "SELECT id_user,mail,login,password,name,age,country,number_of_questions,number_of_ratings FROM users WHERE id_user=?";
    private static final String FIND_BY_NAME = "SELECT id_user,mail,login,password,name,age,country,number_of_questions,number_of_ratings FROM users WHERE name=?";
    private static final String FIND_BY_LOGIN = "SELECT id_user,mail,login,password,name,age,country,number_of_questions,number_of_ratings FROM users WHERE login=?";


    private static final String INSERT = "insert into users(id_user,mail,login,password,name,age," +
            "country,number_of_questions," +
            "number_of_ratings) VALUES(null,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE users SET mail=?, login=?, password=?, name=?, age=?, country=?, number_of_questions=?,  number_of_ratings=? WHERE id_user=?";

    private static final String GET_BY_MARK="SELECT id_user,mail,login,password,name,age,country,number_of_questions,number_of_ratings FROM users ORDER BY number_of_ratings DESC";





    public static void main(String[] args) {




    }





    @Override
    public void createUser(User user) throws DAOException {

        try {


            Connection connection = dbConnectionPool.getConnection();


            PreparedStatement statement = connection.prepareStatement(INSERT);

            statement.setString(1, user.getMail());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getCountry());
            statement.setInt(7, user.getNumberOfQuestions());

            statement.setInt(8, user.getNumberOfRatings());

            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public User read(int idUser) throws DAOException{
        User user=new User();
        try
        {
            Connection connection = dbConnectionPool.getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,idUser);
        ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                user.setId(resultSet.getInt("id_user"));
                user.setLogin(resultSet.getString("login")); //из результатов запроса
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setMail(resultSet.getString("mail"));
                user.setAge(resultSet.getInt("age"));
                user.setCountry(resultSet.getString("country"));
                user.setNumberOfQuestions(resultSet.getInt("number_of_questions"));
                user.setNumberOfRatings(resultSet.getInt("number_of_ratings"));

            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);

        }
    catch(SQLException e){
e.printStackTrace();
    }

return user;

    }

    public void update(User user) throws DAOException {


        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement ps = connection.prepareStatement(UPDATE);

            ps.setString(1, user.getMail());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setInt(5, user.getAge());
            ps.setString(6, user.getCountry());
            ps.setInt(7, user.getNumberOfQuestions());

            ps.setInt(8, user.getNumberOfRatings());

            ps.setInt(9, user.getId());
            ps.executeUpdate();




            dbConnectionPool.closeConnection(connection,ps);
        } catch (SQLException e) {
            //e.printStackTrace();

        }


    }





    @Override
    public void deleteUser(int idUser) throws DAOException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setInt(1,idUser);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);

        }


            catch(SQLException e  ){
            e.printStackTrace();
            }
    }


    @Override
    public List<User> getAll() throws DAOException {
        List<User> users = new ArrayList<User>();
        try {
            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_BY_MARK);


            while (resultSet.next()) { //делаем цикл по всем полученным записям

                User user = new User(); //создаем объект для аккаунта
                user.setId(resultSet.getInt("id_user")); //задаем значения всех полей, получая их
                user.setLogin(resultSet.getString("login")); //из результатов запроса
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setMail(resultSet.getString("mail"));
                user.setAge(resultSet.getInt("age"));
                user.setCountry(resultSet.getString("country"));
                user.setNumberOfQuestions(resultSet.getInt("number_of_questions"));

                user.setNumberOfRatings(resultSet.getInt("number_of_ratings"));


                users.add(user);
                //добавляем созданный объект-аккаунт в список
            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);


        } catch (SQLException e) {

        }

        return users;
    }


    public void deleteUserByName(String name) throws DAOException,ConnectionPoolException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE_BY_NAME);
            statement.setString(1,name);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);

        }


        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getIdByName(String name) throws DAOException,ConnectionPoolException  {
        User user=new User();
        try
        {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                user.setId(resultSet.getInt("id_user"));
                user.setLogin(resultSet.getString("login")); //из результатов запроса
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setMail(resultSet.getString("mail"));
                user.setAge(resultSet.getInt("age"));
                user.setCountry(resultSet.getString("country"));
                user.setNumberOfQuestions(resultSet.getInt("number_of_questions"));

                user.setNumberOfRatings(resultSet.getInt("number_of_ratings"));

            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }
        catch(SQLException e){

        }

        return user.getId();

    }



    public User getUserByLogin(String login) throws DAOException,ConnectionPoolException {
        User user=new User();
        try
        {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                user.setId(resultSet.getInt("id_user"));
                user.setLogin(resultSet.getString("login")); //из результатов запроса
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setMail(resultSet.getString("mail"));
                user.setAge(resultSet.getInt("age"));
                user.setCountry(resultSet.getString("country"));
                user.setNumberOfQuestions(resultSet.getInt("number_of_questions"));

                user.setNumberOfRatings(resultSet.getInt("number_of_ratings"));

            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }
        catch(SQLException e){

        }

        return user;

    }


    public int signIn(String login,String password) throws DAOException {
      List<User> users=getAll();
      for(User user:users){
          if(user.getLogin().equals(login) && password.equals(user.getPassword())){
             return user.getId();
          }
      }
      return 0;


    }








}


