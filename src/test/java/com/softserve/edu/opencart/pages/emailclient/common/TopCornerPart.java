package com.softserve.edu.opencart.pages.emailclient.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopCornerPart {
    protected WebDriver driver;

    public TopCornerPart(WebDriver driver){
        this.driver = driver;
    }
}
