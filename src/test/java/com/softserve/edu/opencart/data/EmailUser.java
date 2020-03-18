package com.softserve.edu.opencart.data;

public class EmailUser {
    private String emailServiceUrl;
    private String email;
    private  String password;

    public EmailUser(String emailServiceUrl, String email, String password) {
        this.emailServiceUrl = emailServiceUrl;
        this.email = email;
        this.password = password;
    }

    public String getEmailServiceUrl() {
        return emailServiceUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setEmailServiceUrl(String emailServiceUrl) {
        this.emailServiceUrl = emailServiceUrl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmailUser{" +
                "emailServiceUrl='" + emailServiceUrl + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
