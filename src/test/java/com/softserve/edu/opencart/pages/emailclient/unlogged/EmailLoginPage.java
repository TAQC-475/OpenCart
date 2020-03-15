package com.softserve.edu.opencart.pages.emailclient.unlogged;

import org.openqa.selenium.WebDriver;

public class EmailLoginPage extends PortalServicesPart{
    private EmailLoginFormComponent emailLoginForm;

    public EmailLoginPage(WebDriver driver){
        super(driver);
    }
}
