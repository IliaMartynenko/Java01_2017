package com.epam.likeit.service;

import com.epam.likeit.bean.Admin;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface AdminService {
    void deleteAdmin(int id) throws ServiceException;
    void addAdmin(Admin Admin) throws ServiceException;
    Admin getAdmin(int id) throws ServiceException;
    List<Admin> getAllAdmin() throws ServiceException;
    int signIn(String login,String password) throws ServiceException;
}
