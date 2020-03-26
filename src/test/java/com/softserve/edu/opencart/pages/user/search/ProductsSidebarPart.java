package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;
import static com.softserve.edu.opencart.tools.RegularExpression.cutSuffixFromCategory;

import java.util.ArrayList;
import java.util.List;


public abstract class ProductsSidebarPart extends BreadCrumbPart {

    private List<WebElement> leftMenuItemList;

    public ProductsSidebarPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        leftMenuItemList = driver.findElements(By.xpath("//div[@class='list-group']/a"));  //

    }

    // Page Object
    public List<WebElement> getLeftMenuItemList() {
        return leftMenuItemList;
    }

    // Functional

    // check if the page is full or not
    private boolean checkFullEmptyPage() {
        try {
            return driver.findElement(By.cssSelector("#content h3")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public List<String> getLeftMenuItemListText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getLeftMenuItemList()) {
            result.add(cutSuffixFromCategory(menuItem.getText()));
        }
        return result;
    }

    // Business Logic

}