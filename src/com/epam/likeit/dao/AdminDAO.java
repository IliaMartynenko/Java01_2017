package com.epam.likeit.dao;

import com.epam.likeit.bean.Admin;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 28.05.2017.
 */
public interface AdminDAO {

    void createAdmin(Admin administrator) throws DAOException;
    Admin read(int id) throws DAOException;
    void update(Admin answer) throws DAOException;
    void deleteAdmin(int idAnswer) throws DAOException;
    List<Admin> getAll() throws DAOException;
    int signIn(String login,String password) throws DAOException ;



    }



