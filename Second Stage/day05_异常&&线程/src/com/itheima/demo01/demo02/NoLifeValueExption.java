package com.itheima.demo01.demo02;

public class NoLifeValueExption extends RuntimeException{
    public NoLifeValueExption() {
    }

    public NoLifeValueExption(String message) {
        super(message);
    }

    public NoLifeValueExption(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLifeValueExption(Throwable cause) {
        super(cause);
    }

    public NoLifeValueExption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
