package com.epam.likeit.service.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.UserDAO;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class UserServiceImpl implements com.epam.likeit.service.UserService {
    private final DAOFactory daoObjectFactory=DAOFactory.getInstance();
    private final UserDAO userDAO=daoObjectFactory.getUserDAO();

    @Override
    public void registration(User user) {

    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        try {
            userDAO.deleteUser(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            userDAO.createUser(user);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
    }

    @Override
    public User getUser(int id) throws ServiceException {
       User user;
       try{
        user=userDAO.read(id);}
       catch(DAOException e){ throw new ServiceException(e);
       }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> users;
        try{
     users=userDAO.getAll();}
        catch(DAOException e){ throw new ServiceException(e);
        }
        return users;

    }

    @Override
    public int signIn(String login, String password) throws ServiceException {
        try {
           int id=userDAO.signIn(login, password);
               return id;

        }


        catch(DAOException e){throw new ServiceException(e);}

    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try{
    userDAO.update(user);}
        catch(DAOException e){ throw new ServiceException(e);
        }
    }
}
