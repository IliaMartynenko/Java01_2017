package com.epam.likeit.dao.pool;

/**
 * Created by mts7072572 on 14.07.2017.
 */
public class ConnectionPoolException extends Exception {
    private  static final long serialVersionUID= 1L;

    public ConnectionPoolException(String message, Exception e) {
        super(message,e);
    }
}
