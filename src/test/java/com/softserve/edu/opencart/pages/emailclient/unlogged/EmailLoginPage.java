package com.softserve.edu.opencart.pages.emailclient.unlogged;

import com.softserve.edu.opencart.pages.emailclient.email.EmailsListPage;
import org.openqa.selenium.WebDriver;

public class EmailLoginPage extends UnloggedMenuBarPart {
    private LoginFormComponent loginForm;

    public EmailLoginPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        loginForm = new LoginFormComponent(driver);
    }

    public EmailsListPage login(/*...*/){//need a user
        return loginForm.login(/**/);
    }
}
