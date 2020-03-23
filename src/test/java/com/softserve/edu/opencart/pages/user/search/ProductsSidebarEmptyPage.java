package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {

    private List<WebElement> leftMenuItemList;

    public ProductsSidebarEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        leftMenuItemList = driver.findElements(By.xpath("//div[@class='list-group']/a"));

    }

    // Page Object
    public List<WebElement> getLeftMenuItemList() {
        return leftMenuItemList;
    }

    // Functional

    // Business Logic

}
