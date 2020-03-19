package com.softserve.edu.opencart.data;

public class EmailUserRepository {
    public static EmailUser getVasyl(){
        return new EmailUser("https://accounts.ukr.net/",
                        "test.user.vasyl@ukr.net",
                        System.getenv().get("VASYLS_EMAIL_PASSWORD"));
    }
}
