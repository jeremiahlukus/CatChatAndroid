package com.jparrack.catchat.models;


public class LogOutResponse {

    private String message;

    public LogOutResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
