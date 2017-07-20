package com.epam.likeit.dao.impl;

import com.epam.likeit.bean.BannedUser;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.dao.pool.DBConnectionPool;
import com.epam.likeit.dao.BannedUserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public class SQLBannedUserDAO implements BannedUserDAO {
    private final DBConnectionPool dbConnectionPool = new DBConnectionPool();
    {dbConnectionPool.createPool();}
    private static final String DELETE = "DELETE FROM banned_users WHERE id_banned_user=?";
    private static final String FIND_BY_ID = "SELECT id_banned_user,id_user,id_admin,reason_of_ban,date_of_ban,ban_duration FROM banned_users WHERE id_banned_user=?";
    private static final String FIND_BY_USER_ID = "SELECT id_banned_user,id_user,id_admin,reason_of_ban,date_of_ban,ban_duration FROM banned_users WHERE id_user=?";
    private static final String FIND_ALL = "SELECT id_banned_user,id_user,id_admin,reason_of_ban,date_of_ban,ban_duration FROM banned_users ORDER BY id_banned_user";
    private static final String INSERT = "insert into banned_users(id_banned_user,id_user,id_admin,reason_of_ban,date_of_ban,ban_duration) VALUES(null,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE banned_users SET  WHERE id_banned_user=?";






    public static void main(String[] args) throws DAOException {
        SQLBannedUserDAO sqlBannedUserDAO = new SQLBannedUserDAO();
      System.out.print(sqlBannedUserDAO.read(16).getBanDuration());





    }





    @Override
    public void createBannedUser(BannedUser bannedUser) throws DAOException {

        try {


            Connection connection = dbConnectionPool.getConnection();


            PreparedStatement statement = connection.prepareStatement(INSERT);


            statement.setInt(1, bannedUser.getIdUser());
            statement.setInt(2, bannedUser.getIdAdmin());
            statement.setString(3, bannedUser.getReasonOfBan());
            statement.setDate(4, bannedUser.getDateOfBan());
            statement.setInt(5, bannedUser.getBanDuration());

            statement.executeUpdate();


            dbConnectionPool.closeConnection(connection,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public BannedUser read(int idBannedUser) throws DAOException{
        BannedUser bannedUser=new BannedUser();
        try
        {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,idBannedUser);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                bannedUser.setIdBannedUser(resultSet.getInt("id_banned_user"));
                bannedUser.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                bannedUser.setIdAdmin(resultSet.getInt("id_admin"));
                bannedUser.setReasonOfBan(resultSet.getString("reason_of_ban"));
                bannedUser.setDateOfBan(resultSet.getDate("date_of_ban"));
                bannedUser.setBanDuration(resultSet.getInt("ban_duration"));

            }

            dbConnectionPool.closeConnection(connection,statement);
        }
        catch(SQLException e){}
        return bannedUser;

    }

    public void update(BannedUser bannedUser) throws DAOException {


        Connection connection = dbConnectionPool.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setInt(1, bannedUser.getIdUser());
            statement.setInt(2, bannedUser.getIdAdmin());
            statement.setString(3, bannedUser.getReasonOfBan());
            statement.setDate(4, bannedUser.getDateOfBan());
            statement.setInt(5, bannedUser.getBanDuration());
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);



        } catch (SQLException e) {
            //e.printStackTrace();

        }

    }





    @Override
    public void deleteBannedUser(int idBannedUser) throws DAOException {

        try {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setInt(1,idBannedUser);
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeUpdate();

            dbConnectionPool.closeConnection(connection,statement);
        }

        catch(Exception e  ){
            e.printStackTrace();
        }
    }


    @Override
    public List<BannedUser> getAll() throws DAOException  {
        List<BannedUser> bannedUsers = new ArrayList<BannedUser>();
        try {


            Connection connection = dbConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) { //делаем цикл по всем полученным записям

                BannedUser bannedUser = new BannedUser(); //создаем объект для аккаунта
                bannedUser.setIdBannedUser(resultSet.getInt("id_banned_user"));
                bannedUser.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                bannedUser.setIdAdmin(resultSet.getInt("id_admin"));
                bannedUser.setReasonOfBan(resultSet.getString("reason_of_ban"));
                bannedUser.setDateOfBan(resultSet.getDate("date_of_ban"));
                bannedUser.setBanDuration(resultSet.getInt("ban_duration"));

                bannedUsers.add(bannedUser); //добавляем созданный объект-аккаунт в список
            }

            dbConnectionPool.closeConnection(connection,statement);

        } catch (Exception e) {

        }

        return bannedUsers;
    }

    @Override


    public BannedUser readByUserId(int id_user) throws DAOException {
        BannedUser bannedUser=new BannedUser();
        try
        {

            Connection connection = dbConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_USER_ID);
            statement.setInt(1,id_user);
            ResultSet resultSet = statement.executeQuery(); //выполняем запрос и получаем результат

            if(resultSet.next()) {
                bannedUser.setIdBannedUser(resultSet.getInt("id_banned_user"));
                bannedUser.setIdUser(resultSet.getInt("id_user")); //из результатов запроса
                bannedUser.setIdAdmin(resultSet.getInt("id_admin"));
                bannedUser.setReasonOfBan(resultSet.getString("reason_of_ban"));
                bannedUser.setDateOfBan(resultSet.getDate("date_of_ban"));
                bannedUser.setBanDuration(resultSet.getInt("ban_duration"));

            }

            dbConnectionPool.closeConnection(connection,statement);
        }
        catch(SQLException e){}
        return bannedUser;

    }
}
