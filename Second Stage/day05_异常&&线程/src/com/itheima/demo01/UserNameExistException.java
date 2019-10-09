package com.itheima.demo01;

public class UserNameExistException extends Exception{
    public UserNameExistException() {
    }

    public UserNameExistException(String message) {
        super(message);
    }

    public UserNameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameExistException(Throwable cause) {
        super(cause);
    }

    public UserNameExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
