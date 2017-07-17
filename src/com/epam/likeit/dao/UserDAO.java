package com.epam.likeit.dao;

import com.epam.likeit.bean.User;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 28.05.2017.
 */
public interface UserDAO {
    void createUser(User user) throws DAOException;
    User read(int id) throws DAOException;
    void update(User user) throws DAOException;
    void deleteUser(int idUser) throws DAOException;
    List<User> getAll() throws DAOException;
    int signIn(String login,String password) throws DAOException;




}

