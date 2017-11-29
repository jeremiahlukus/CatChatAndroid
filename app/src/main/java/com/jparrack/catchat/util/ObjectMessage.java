package com.jparrack.catchat.util;

/**
 * Created by phanthuhao on 11/30/17.
 */

public class ObjectMessage {
    private String emailSend;
    private String emailReceive;
    private String message;
    public ObjectMessage(){

    }

    public ObjectMessage(String emailSend, String emailReceive, String message) {
        this.emailSend = emailSend;
        this.emailReceive = emailReceive;
        this.message = message;
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
}
