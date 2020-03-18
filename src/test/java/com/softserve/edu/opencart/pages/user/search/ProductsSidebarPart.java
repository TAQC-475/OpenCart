package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ProductsSidebarPart extends BreadCrumbPart {

    private WebElement desktops;
    private WebElement laptopsNotebooks;
    private WebElement components;
    private WebElement tablets;
    private WebElement software;
    private WebElement phonesPDAs;
    private WebElement cameras;
    private WebElement mp3Players;

    public ProductsSidebarPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        desktops = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Desktops')]"));
        laptopsNotebooks = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Laptops & Notebooks')]"));
        components = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Components')]"));
        tablets = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Tablets')]"));
        software = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Software')]"));
        phonesPDAs = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Phones & PDAs')]"));
        cameras = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Cameras')]"));
        mp3Players = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'MP3 Players')]"));
    }

    public WebElement getDesktops() {
        return desktops;
    }

    public String getDesktopsText() {
        return getDesktops().getText();
    }

    public void clickDesktops() {
        getDesktops().click();
    }

    public WebElement getLaptopsNotebooks() {
        return laptopsNotebooks;
    }

    public String getLaptopsNotebooksText() {
        return getLaptopsNotebooks().getText();
    }

    public void clickLaptopsNotebooks() {
        getLaptopsNotebooks().click();
    }

    public WebElement getComponents() {
        return components;
    }

    public String getComponentsText() {
        return getComponents().getText();
    }

    public void clickComponents() {
        getComponents().click();
    }

    public WebElement getTablets() {
        return tablets;
    }

    public String getTabletsText() {
        return getTablets().getText();
    }

    public void clickTablets() {
        getTablets().click();
    }

    public WebElement getSoftware() {
        return software;
    }

    public String getSoftwareText() {
        return getSoftware().getText();
    }

    public void clickSoftware() {
        getSoftware().click();
    }

    public WebElement getPhonesPDAs() {
        return phonesPDAs;
    }

    public String getPhonesPDAsText() {
        return getPhonesPDAs().getText();
    }

    public void clickPhonesPDAs() {
        getPhonesPDAs().click();
    }

    public WebElement getCameras() {
        return cameras;
    }

    public String getCamerasText() {
        return getCameras().getText();
    }

    public void clickCameras() {
        getCameras().click();
    }

    public WebElement getMp3Players() {
        return mp3Players;
    }

    public String getMp3PlayersText() {
        return getMp3Players().getText();
    }

    public void clickMp3Players() {
        getMp3Players().click();
    }

    // Page Object

    // Functional

    // Business Logic
}