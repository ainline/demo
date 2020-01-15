package com.alchen.exception;

/**
 * 自定义异常信息类
 */
public class ExceptionMessage extends Exception {

    private String message;

    public ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
