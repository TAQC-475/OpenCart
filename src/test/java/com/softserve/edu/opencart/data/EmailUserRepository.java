package com.softserve.edu.opencart.data;

public class EmailUserRepository {
    public static EmailUser getVasyl(){
        return new EmailUser("https://webmail.meta.ua/",
                        "test.user.vasyl",
                        System.getenv("VASYLS_PASSWORD"));
    }
}
