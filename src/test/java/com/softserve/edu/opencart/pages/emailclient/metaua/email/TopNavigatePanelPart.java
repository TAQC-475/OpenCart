package com.softserve.edu.opencart.pages.emailclient.metaua.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopNavigatePanelPart extends LoggedMenuBarPart{

    private WebElement metaUaImage;
    private WebElement webMailLink;

    public TopNavigatePanelPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        metaUaImage = driver.findElement(By.id("mail_label_text"));
        webMailLink = driver.findElement(By.className("mail_label_text"));
    }

    //atomic
}




