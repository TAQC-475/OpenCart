package com.softserve.edu.opencart.pages.emailclient.metaua.unlogged;

import com.softserve.edu.opencart.pages.emailclient.metaua.common.FooterServicesPart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class  UnloggedMenuBarPart extends FooterServicesPart {

    private WebElement metaUa;
    private WebElement webMail;
    private WebElement simplerMail;
    private WebElement contact;
    private WebElement blog;
    private WebElement photo;
    private WebElement video;
    private WebElement chat;
    private WebElement dating;
    private WebElement forum;

    private WebElement ruLan;
    private WebElement uaLan;

    public UnloggedMenuBarPart(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        //coming soon
    }

}
