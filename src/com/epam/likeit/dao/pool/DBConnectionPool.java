package com.epam.likeit.dao.pool;


import com.epam.likeit.dao.impl.SQLTopicDAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class DBConnectionPool {
    private static Logger logger = Logger.getLogger(SQLTopicDAO.class.getName());


    private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(20, true);
    private static String url = "jdbc:mysql://localhost:3306/likeit?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "1111";


    public void createPool()  {
        for (int i = 0; i < 10; i++) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                pool.add(DriverManager.getConnection(url, user, password));
            } catch (SQLException | ClassNotFoundException e) {
                logger.error(e);
            }
        }
    }



    public synchronized Connection getConnection() {
        Connection conn = null;
        try {


            conn = pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn,Statement statement) {




            try {
                pool.put(conn);


            }

            catch (InterruptedException e) {
                logger.error(e);
            }
            try{statement.close();}
            catch(SQLException e){
                e.printStackTrace();
            }



    }

    public void closeConnection(Connection conn,Statement statement,ResultSet resultSet) {



        if (conn != null) {
            try {
                pool.put(conn);

            }catch (InterruptedException e) {
                logger.error(e);
            }
            try{statement.close();
            resultSet.close();}

            catch (SQLException e) {
                logger.error(e);
            }


        }
    }



}

