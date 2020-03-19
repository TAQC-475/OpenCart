package com.softserve.edu.opencart.data;

public class EmailUserRepository {
    public static EmailUser getVasyl(){
        return new EmailUser("https://webmail.meta.ua/",
                        "test.user.vasyl@meta.ua",
                        System.getenv().get("VASYLS_EMAIL_PASSWORD"));
    }
}
