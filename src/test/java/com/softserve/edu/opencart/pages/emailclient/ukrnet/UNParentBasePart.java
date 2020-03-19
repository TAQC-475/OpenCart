package com.softserve.edu.opencart.pages.emailclient.ukrnet;

import org.openqa.selenium.WebDriver;

public abstract class UNParentBasePart {

    protected WebDriver driver;

    public UNParentBasePart(WebDriver driver){
        this.driver = driver;
    }
}
