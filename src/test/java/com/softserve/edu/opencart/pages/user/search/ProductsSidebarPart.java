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

    private List<WebElement> menuItemList;

    public ProductsSidebarPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        menuItemList = driver.findElements(By.xpath("//div[@class='list-group']/a"));
    }

    // Page Object

    public List<WebElement> getMenuItemList() {
        return menuItemList;
    }

    public List<String> getMenuItemListText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getMenuItemList()) {
            result.add(menuItem.getText());
        }
        return result;
    }

    // Functional

    // Business Logic
}