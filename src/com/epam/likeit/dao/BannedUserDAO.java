package com.epam.likeit.dao;

import com.epam.likeit.bean.BannedUser;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public interface BannedUserDAO {
    void createBannedUser(BannedUser BannedUser) throws DAOException;
    BannedUser read(int id) throws DAOException;
    void update(BannedUser answer) throws DAOException;
    void deleteBannedUser(int idAnswer) throws DAOException;
    List<BannedUser> getAll() throws DAOException;
    BannedUser readByUserId(int id) throws DAOException;


}
