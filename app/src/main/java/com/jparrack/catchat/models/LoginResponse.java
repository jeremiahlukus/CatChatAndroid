package com.jparrack.catchat.models;

public class LoginResponse {

    private String uuid;

    private String message;

    public LoginResponse(String uuid, String message) {
        this.uuid = uuid;
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public String getMessage() {
        return message;
    }
}
