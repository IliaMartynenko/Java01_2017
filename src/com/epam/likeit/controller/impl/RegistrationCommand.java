package com.epam.likeit.controller.impl;

import com.epam.likeit.bean.User;
import com.epam.likeit.controller.Command;
import com.epam.likeit.service.UserService;
import com.epam.likeit.service.exception.ServiceException;
import com.epam.likeit.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 20.07.2017.
 */
public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resp="view/signin/registrationSucess.jsp";
      try {
          ServiceFactory serviceFactory = ServiceFactory.getInstance();
          UserService userService = serviceFactory.getUserService();

          String login = request.getParameter("user_login");
          String password = request.getParameter("password");
          int age = Integer.parseInt(request.getParameter("age"));
          String name = request.getParameter("name");
          String country = request.getParameter("country");
          String mail = request.getParameter("email");
          User user = new User();
          user.setLogin(login);
          user.setPassword(password);
          user.setAge(age);
          user.setName(name);
          user.setCountry(country);
          user.setMail(mail);
          userService.addUser(user);

      }
      catch(ServiceException e){
          e.printStackTrace();
      }


return resp;
    }
}
