package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UkrNetContentPanelPart extends UkrNetLeftEmailPanelPart {
    private WebElement search;
    private WebElement accountOptions;

    public UkrNetContentPanelPart(WebDriver driver){
        super(driver);
        initElements();

    }

    private void initElements(){
        search = driver.findElement(By.xpath("//div[@class='search']//input"));
        accountOptions = driver.findElement(By.cssSelector("a.login-button"));
    }
    //coming soon



}
