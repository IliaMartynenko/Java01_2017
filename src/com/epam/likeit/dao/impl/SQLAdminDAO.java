package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.Admin;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import com.epam.likeit.dao.AdminDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public class SQLAdminDAO implements AdminDAO {
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();
    {dbConnectionPool.createPool();}

    private static final String DELETE = "DELETE FROM admins WHERE id_admin=?";

    private static final String FIND_BY_ID = "SELECT id_admin,login,password,mail,name,country,year_of_birth FROM admins WHERE id_admin=?";
    private static final String FIND_BY_LOGIN = "SELECT id_admin,login,password,mail,name,country,year_of_birth FROM admins WHERE login=?";
    private static final String FIND_ALL = "SELECT id_admin,login,password,mail,name,country,year_of_birth FROM admins ORDER BY id_admin";
    private static final String INSERT = "insert into admins(id_admin,login,password,mail,name," +
            "country,year_of_birth) VALUES(null,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE admins SET  login=?, password=?, mail=?, name=?,country=?,year_of_birth=?  WHERE id_admin=?";






    public static void main(String[] args) {



    }





    @Override
    public void createAdmin(Admin admin)  throws DAOException {

        try {

           dbConnectionPool.createPool();
            Connection connection = dbConnectionPool.getConnection();


            PreparedStatement statement = connection.prepareStatement(INSERT);

            statement.setString(1, admin.getLogin());
            statement.setString(2, admin.getPassword());
            statement.setString(3, admin.getMail());
            statement.setString(4, admin.getName());
            statement.setString(5, admin.getCountry());
            statement.setInt(6, admin.getYearOfBirthday());
           
            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Admin read(int idAdmin) throws DAOException{
        Admin admin=new Admin();
        try
        {
            dbConnectionPool.createPool();
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,idAdmin);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                admin.setId(resultSet.getInt("id_admin"));
                admin.setLogin(resultSet.getString("login")); //из результатов запроса
                admin.setPassword(resultSet.getString("password"));
                admin.setName(resultSet.getString("mail"));
                admin.setMail(resultSet.getString("name"));
                admin.setCountry(resultSet.getString("country"));
                admin.setYearOfBirthday(resultSet.getInt("year_of_birth"));

            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }
        catch(SQLException e){}
        return admin;

    }

    public void update(Admin admin) throws DAOException {

        dbConnectionPool.createPool();
        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement ps = connection.prepareStatement(UPDATE);


            ps.setString(1, admin.getLogin());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getMail());
            ps.setString(4, admin.getName());
            ps.setString(5, admin.getCountry());
            ps.setInt(6, admin.getYearOfBirthday());

            ps.setInt(7, admin.getId());
            ps.executeUpdate();




            dbConnectionPool.closeConnection(connection,ps);

        } catch (SQLException e) {
            //e.printStackTrace();

        }

    }





    @Override
    public void deleteAdmin(int idAdmin) throws DAOException {

        try {
            dbConnectionPool.createPool();
            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setInt(1,idAdmin);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();
            dbConnectionPool.closeConnection(connection,statement);
        }

        catch(Exception e  ){
            e.printStackTrace();
        }
    }


    @Override
    public List<Admin> getAll() throws DAOException  {
         DBConnectionPool dbConnectionPool = new DBConnectionPool();
        List<Admin> admins = new ArrayList<Admin>();
        try {

            dbConnectionPool.createPool();
            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                Admin admin = new Admin(); //создаем объект для аккаунта
                admin.setId(resultSet.getInt("id_admin"));
                admin.setLogin(resultSet.getString("login")); //из результатов запроса
                admin.setPassword(resultSet.getString("password"));
                admin.setName(resultSet.getString("mail"));
                admin.setMail(resultSet.getString("name"));
                admin.setCountry(resultSet.getString("country"));
                admin.setYearOfBirthday(resultSet.getInt("year_of_birth"));

                admins.add(admin); //добавляем созданный объект-аккаунт в список
            }
            dbConnectionPool.closeConnection(connection,statement,resultSet);

        } catch (Exception e) {
e.printStackTrace();
        }

        return admins;
    }


    public Admin getAdminByLogin(String login) throws DAOException  {
        Admin admin=new Admin();
        try
        {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                admin.setId(resultSet.getInt("id_admin"));
                admin.setLogin(resultSet.getString("login")); //из результатов запроса
                admin.setPassword(resultSet.getString("password"));
                admin.setName(resultSet.getString("name"));
                admin.setMail(resultSet.getString("mail"));
                admin.setYearOfBirthday(resultSet.getInt("year_of_birth"));
                admin.setCountry(resultSet.getString("country"));




            }

            dbConnectionPool.closeConnection(connection,statement,resultSet);
        }
        catch(SQLException e){

        }

        return admin;

    }
    public int signIn(String login,String password) throws DAOException {
        List<Admin> admins=getAll();
        for(Admin admin:admins){
            if(admin.getLogin().equals(login) && password.equals(admin.getPassword())){
                return admin.getId();
            }
        }
        return 0;


    }
 
}
