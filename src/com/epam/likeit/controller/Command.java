package com.epam.likeit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
