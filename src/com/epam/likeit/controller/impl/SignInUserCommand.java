package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.Admin;
import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.AdminService;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by mts7072572 on 17.07.2017.
 *
 */

public class SignInUserCommand implements Command {
  private static Logger logger = Logger.getLogger(SignInUserCommand.class.getName());


    @Override

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ServiceFactory serviceFactory= ServiceFactory.getInstance();
        UserService userService=serviceFactory.getUserService();
        AdminService adminService=serviceFactory.getAdminService();
        try {





            int id=userService.signIn(request.getParameter("login"), request.getParameter("password"));
        int id_admin=adminService.signIn(request.getParameter("login"), request.getParameter("password"));

            if (id != 0){
               User user= userService.getUser(id);
               request.getSession().setAttribute("user_id",user.getId());

                return "view/signin/helloUser";


            }
             else{
                if(id_admin!=0){
                    Admin admin=adminService.getAdmin(id);
                    request.getSession().setAttribute("admin_id",admin.getId());

                    return "view/admin/admin.jsp";
                }
            }


        }
        catch (ServiceException  e){
            logger.error(e);
        }
        return "view/signin/signError.jsp";
    }


}
