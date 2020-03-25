package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {

    protected final String SUB_CATEGORIES_NUMBER_ONE = "//div[@class='list-group']/a[contains(text(),'-')][1]";
    protected final String SUB_CATEGORIES = "//div[@class='list-group']/a[contains(text(),'-')]";

    private List<WebElement> leftMenuItemList;

    public ProductsSidebarEmptyPage(WebDriver driver) {
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

    private boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public Map<String, List<String>> getLeftMenuCategoriesMap() throws InterruptedException {
        Map<String, List<String>> menuLeftCategoriesMap = new HashMap();
        for (WebElement menuItem : getLeftMenuItemList()) {
            System.out.println("-5");

            if(!isVisible(menuItem)){continue;}
            String categoryText = withoutNumbers(menuItem.getText());
            System.out.println("-4");
//            new Actions(driver).moveToElement(menuItem).build().perform();
            System.out.println("0");
            Actions actions = new Actions(driver);
            actions.moveToElement(menuItem).build().perform();
            System.out.println("1");
            actions.click().perform();
            System.out.println("2");

            Thread.sleep(1000);

            if (driver.findElements(By.xpath(SUB_CATEGORIES_NUMBER_ONE)).size() != 0) {
                System.out.println("4");
                List<WebElement> subCategoryElementList = driver.findElements(By.xpath(String.format(SUB_CATEGORIES, categoryText)));
                System.out.println("5");
                List<String> subCategoriesStringList = new ArrayList();
                System.out.println("6");
                for (WebElement subMenuItem : subCategoryElementList) {
                    System.out.println("7");
                    subCategoriesStringList.add(dropPrefix(subMenuItem.getText()));
                    System.out.println("8");
                }
                menuLeftCategoriesMap.put(categoryText, subCategoriesStringList);
            } else {
                menuLeftCategoriesMap.put(categoryText, null);
            }
        }
        System.out.println("10");
        return menuLeftCategoriesMap;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Business Logic

}
