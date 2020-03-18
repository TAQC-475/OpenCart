package com.softserve.edu.opencart.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SystemInLeftMenuPart extends LeftMenuPart {

//    private WebElement systemOpen;
    private WebElement settings;
    private WebElement localisation;
    private WebElement tools;

    public SystemInLeftMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
//        systemOpen = driver.findElement(By.cssSelector("#menu-system.open "));
        settings = driver.findElement(By.xpath("//*[@id='menu-system']//a[contains(text(), 'Settings')]"));
        localisation = driver.findElement(By.xpath("//*[@id='menu-system']//a[contains(text(), 'Localisation')]"));
        tools = driver.findElement(By.xpath("//*[@id='menu-system']//a[contains(text(), 'Tools')]"));
    }

    public void clickLocalisation() {
        localisation.click();
    }

    public LocalisationSystemInLeftMenuPart settingsSystemInLeftMenuPart() {
        clickLocalisation();
        return new LocalisationSystemInLeftMenuPart(driver);
    }
}
