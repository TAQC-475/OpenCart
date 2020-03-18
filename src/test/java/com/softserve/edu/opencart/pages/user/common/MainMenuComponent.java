package com.softserve.edu.opencart.pages.user.common;
// added by Volodymyr

import com.softserve.edu.opencart.data.MenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenuComponent {

    protected final String LIST_SUB_CATEGOIES_CSSSELECTOR = "div.dropdown-inner ul.list-unstyled li";

    private MenuItems categoryItem;
    private List<WebElement> menuItemList;

    private WebDriver driver;

    private DropdownComponent dropdownComponent;

    public MainMenuComponent(WebDriver driver) {
        this.driver = driver;

        initElements();
    }

    private void initElements() {
        // init elements
        menuItemList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
//        menuItemList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//li/a"));
        dropdownComponent = new DropdownComponent(driver, By.cssSelector(LIST_SUB_CATEGOIES_CSSSELECTOR));  // hardcode

    }

    // Page Object
    public List<WebElement> getMenuItemList() {
        return menuItemList;
    }

    private Integer getMenuItemNumber(MenuItems categoryItem) {
        return getMenuItemList().indexOf(categoryItem);
    }

    public MainMenuComponent clickMenuItem(){
        getMenuItemList().get(getMenuItemNumber(categoryItem)).click();
        return new MainMenuComponent(driver);
    }

    public DropdownComponent getDropdownComponent() {
        return dropdownComponent;
    }

    public void clickByPartialName(MenuItem menuItem) {
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
