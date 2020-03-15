package com.softserve.edu.opencart.pages.user.common;
// added by Volodymyr

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainMenuComponent {

    private List<WebElement> menuItemList;

    private WebDriver driver;

    public MainMenuComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        menuItemList = driver.findElements(By.xpath(".//ul[@class='nav navbar-nav']/li"));

    }

    // Page Object
    public List<WebElement> getMenuItemList() {
        return menuItemList;
    }

    // Functional
    public List<String> getMenuItemListText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getMenuItemList()) {
            result.add(menuItem.getText());
        }
        return result;
    }

    // Business Logic

}
