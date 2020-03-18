package com.softserve.edu.opencart.data;

public class EmailUser {
    private String emailServiceUrl;
    private String login;
    private  String password;

    public EmailUser(String emailServiceUrl, String email, String password) {
        this.emailServiceUrl = emailServiceUrl;
        this.login = email;
        this.password = password;
    }

    public String getEmailServiceUrl() {
        return emailServiceUrl;
    }

    public String getEmail() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public void setEmailServiceUrl(String emailServiceUrl) {
        this.emailServiceUrl = emailServiceUrl;
    }

    public void setEmail(String email) {
        this.login = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmailUser{" +
                "emailServiceUrl='" + emailServiceUrl + '\'' +
                ", email='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
