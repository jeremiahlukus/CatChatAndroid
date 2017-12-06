package com.jparrack.catchat.util;


public class ObjectImage {
    private String email;
    private String url;

    public ObjectImage(){

    }

    public ObjectImage(String email, String url) {
        this.email = email;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
