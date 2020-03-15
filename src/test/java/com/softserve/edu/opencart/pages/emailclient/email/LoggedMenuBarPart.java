package com.softserve.edu.opencart.pages.emailclient.email;

import com.softserve.edu.opencart.pages.emailclient.common.FooterServicesPart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class LoggedMenuBarPart extends FooterServicesPart {

    private WebElement metaUa;
    private WebElement webMail;
    private WebElement setting;
    private WebElement techSupport;
    private WebElement help;
    private WebElement logoutButton;

    public LoggedMenuBarPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        //coming soon
    }
}
