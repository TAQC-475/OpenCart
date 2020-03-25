package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        menuItemList = driver.findElements(By.xpath("//div[@class='list-group']"));

    }

    // Page Object
    public List<WebElement> getLeftMenuItemList() { return menuItemList; }

    public void clickLeftMenuItem(String optionalName){
//        getLeftMenuItemList().
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

    private String withoutNumbers(String strInput) {
        String strResult = "";
        Pattern p = Pattern.compile("[a-zA-Z].+[^ (0-9)]");
        Matcher m = p.matcher(strInput);
        while (m.find()) {
            strResult = String.valueOf(m.group());
        }
        return strResult;
    }

    public List<String> getLeftMenuItemListText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getLeftMenuItemList()) {
            result.add(withoutNumbers(menuItem.getText()));
        }
        return result;
    }

    // Business Logic

}