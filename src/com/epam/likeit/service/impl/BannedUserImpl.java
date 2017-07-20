package com.epam.likeit.service.impl;

import com.epam.likeit.bean.BannedUser;
import com.epam.likeit.dao.BannedUserDAO;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.BannedUserService;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class BannedUserImpl implements BannedUserService {
    private final DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private final BannedUserDAO bannedUserDAO = daoObjectFactory.getBannedUserDAO();

    @Override
    public void addBannedUser(BannedUser bannedUser) throws ServiceException {
        try {
            bannedUserDAO.createBannedUser(bannedUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public BannedUser getBannedUser(int id) throws ServiceException {
        BannedUser bannedUser;
        try {
            bannedUser = bannedUserDAO.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return bannedUser;
    }


    @Override
    public void deleteBannedUser(int id) throws ServiceException {
        try {
            bannedUserDAO.deleteBannedUser(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateBannedUser(BannedUser bannedUser) throws ServiceException {
        try {
            bannedUserDAO.update(bannedUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BannedUser> getAll() throws ServiceException {
        List<BannedUser> bannedUsers;
        try {
            bannedUsers = bannedUserDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return bannedUsers;
    }

    @Override
    public BannedUser readByUserId(int id) throws ServiceException {

        BannedUser bannedUser;
        try {
            bannedUser = bannedUserDAO.readByUserId(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return bannedUser;
    }

    @Override
    public boolean isBanned(int id) throws ServiceException {

        try {
            List<BannedUser> bannedUsers = bannedUserDAO.getAll();
            for (BannedUser b : bannedUsers) {
                if (b.getIdUser() == id) {
                    return true;


                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;

    }


}
