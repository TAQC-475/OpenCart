package com.softserve.edu.opencart.pages.emailclient.unlogged;

import org.openqa.selenium.WebDriver;

public class EmailLoginPage extends UnloggedMenuBarPart {
    private LoginFormComponent loginForm;

    public EmailLoginPage(WebDriver driver){
        super(driver);
    }
}
