package com.softserve.edu.opencart.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocalisationSystemInLeftMenuPart extends SystemInLeftMenuPart {

//    private WebElement localisationOpen;
    private WebElement storeLocation;
    private WebElement languages;
    private WebElement currencies;

    public LocalisationSystemInLeftMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }
    private void initElements() {
//        localisationOpen = driver.findElement(By.cssSelector("#menu-system > ul > li.open > a"));
        storeLocation = driver.findElement(By.xpath("//*[@id=\"menu-system\"]//a[contains(text(), 'Store')]"));
        languages = driver.findElement(By.xpath("//*[@id=\"menu-system\"]//a[contains(text(), 'Languages')]"));
        currencies = driver.findElement(By.xpath("//*[@id=\"menu-system\"]//a[contains(text(), 'Currencies')]"));
    }
}
