package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UNRightContentPanelBasePart extends UNLeftEmailPanelPart {
    protected WebElement search;
    protected WebElement accountOptions;
    protected WebElement messageControls;

    public UNRightContentPanelBasePart(WebDriver driver){
        super(driver);
        initElements();

    }

    private void initElements(){
        search = driver.findElement(By.xpath("//div[@class='search']//input"));
        accountOptions = driver.findElement(By.cssSelector("a.login-button"));
    }
    //coming soon



}
