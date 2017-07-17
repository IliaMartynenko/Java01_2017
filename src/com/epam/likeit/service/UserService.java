package com.epam.likeit.service;

import com.epam.likeit.bean.User;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface UserService {
    void registration(User user) throws ServiceException;
    void deleteUser(int id) throws ServiceException;
    void addUser(User user) throws ServiceException;
    int signIn(String login,String password) throws ServiceException;
    void updateUser(User user) throws ServiceException;
    User getUser(int id) throws ServiceException;
    List<User> getAllUsers() throws ServiceException;







}
