package com.softserve.edu.opencart.data;

public class EmailRepository {
    public static ResetEmailEntity getOpencartResetEmail(){
        return new ResetEmailEntity("Your Store - Password reset request",
                "http://localhost/opencart/index.php?route=account/reset");
    }
}
