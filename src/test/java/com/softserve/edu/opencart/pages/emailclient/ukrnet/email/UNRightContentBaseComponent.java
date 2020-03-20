package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UNRightContentBaseComponent {
    protected WebDriver driver;

    public UNRightContentBaseComponent(WebDriver driver){
        this.driver = driver;
    }
}
