package com.epam.likeit.service.impl;

import com.epam.likeit.bean.Admin;
import com.epam.likeit.dao.AdminDAO;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.AdminService;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class AdminServiceImpl implements AdminService {
    private final DAOFactory daoObjectFactory= DAOFactory.getInstance();
    private final AdminDAO adminDAO=daoObjectFactory.getAdminDAO();

    @Override
    public void deleteAdmin(int id) throws ServiceException {
        try {
            adminDAO.deleteAdmin(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }

    }

    @Override
    public void addAdmin(Admin admin) throws ServiceException {
        try {
            adminDAO.createAdmin(admin);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }

    }

    @Override
    public Admin getAdmin(int id) throws ServiceException {
        Admin admin;
        try {
            admin = adminDAO.read(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() throws ServiceException {
        List<Admin> admins;
        try {
            admins = adminDAO.getAll();
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return admins;
    }

    public int signIn(String login, String password) throws ServiceException {
        try {
            int id=adminDAO.signIn(login, password);
            return id;

        }


        catch(DAOException e){throw new ServiceException(e);}

    }



}
