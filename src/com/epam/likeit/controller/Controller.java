package com.epam.likeit.controller;

import com.epam.likeit.bean.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mts7072572 on 13.07.2017.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String commandName;
        Command executionCommand;
        commandName = request.getParameter("command");

        executionCommand = provider.getCommand(commandName);
        String resp;
        resp = executionCommand.execute(request,response);
        response.sendRedirect(resp);
    }
}

