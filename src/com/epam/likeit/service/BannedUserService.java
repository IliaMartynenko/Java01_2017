package com.epam.likeit.service;


import com.epam.likeit.bean.BannedUser;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface BannedUserService {
    void addBannedUser(BannedUser bannedUser) throws ServiceException;
    void deleteBannedUser(int id) throws ServiceException;
    void updateBannedUser(BannedUser bannedUser) throws ServiceException;
    BannedUser getBannedUser(int id) throws ServiceException;
    List<BannedUser> getAll() throws ServiceException;
    boolean isBanned(int id)  throws ServiceException;
    BannedUser readByUserId(int id) throws ServiceException;
}
