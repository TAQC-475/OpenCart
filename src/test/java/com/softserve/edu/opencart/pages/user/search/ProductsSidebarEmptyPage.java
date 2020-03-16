package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {

    private List<WebElement> leftMenuItemList;

    public ProductsSidebarEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        leftMenuItemList = driver.findElements(By.xpath(".//div[@class='list-group']/a")); // (".//aside[@id='column-left']/div/a"));

    }

    // Page Object
    public List<WebElement> getLeftMenuItemList() {
        return leftMenuItemList;
    }

    // Functional
    public List<String> getLeftMenuItemListText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getLeftMenuItemList()) {
            result.add(menuItem.getText());
        }
        return result;
    }

    public void gotoLeftMenuBar(){
        getMainMenuComponent()
                .getMenuItemList()
                .get(4)
                .click();// hardcoded num of element to click!
    }

    // Business Logic
}
