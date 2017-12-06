package com.jparrack.catchat.util;


public class ObjectMessage {
    private String emailSend;
    private String emailReceive;
    private String message;
    private String urlSender;
    public ObjectMessage(){

    }

    public ObjectMessage(String emailSend, String emailReceive, String message, String urlSender) {
        this.emailSend = emailSend;
        this.emailReceive = emailReceive;
        this.message = message;
        this.urlSender = urlSender;
    }

    public String getEmailSend() {
        return emailSend;
    }

    public void setEmailSend(String emailSend) {
        this.emailSend = emailSend;
    }

    public String getEmailReceive() {
        return emailReceive;
    }

    public void setEmailReceive(String emailReceive) {
        this.emailReceive = emailReceive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrlSender() {
        return urlSender;
    }

    public void setUrlSender(String urlSender) {
        this.urlSender = urlSender;
    }
}
