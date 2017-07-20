package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.BannedUser;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.BannedUserService;
import com.epam.likeit.service.QuestionService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class BanUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp=null;
        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        BannedUserService bannedUserService=serviceFactory.getBannedUserService();
        BannedUser bannedUser=new BannedUser();
        try {
        bannedUser.setIdUser(Integer.parseInt(request.getParameter("id_user")));
        bannedUser.setBanDuration(Integer.parseInt(request.getParameter("duration")));
        bannedUser.setReasonOfBan(request.getParameter("reason_of_ban"));
        bannedUser.setDateOfBan(new Date(System.currentTimeMillis()));
        bannedUser.setIdAdmin(1);
        bannedUserService.addBannedUser(bannedUser);
        resp="view/admin/operationsWithUser.jsp";
        }

        catch(ServiceException e){
            e.printStackTrace();
            }



        return resp;
    }

}
