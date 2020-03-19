package com.softserve.edu.opencart.pages.emailclient.ukrnet;

import org.openqa.selenium.WebDriver;

public abstract class BaseParentEmailPart {

    protected WebDriver driver;

    public BaseParentEmailPart(WebDriver driver){
        this.driver = driver;
    }
}
