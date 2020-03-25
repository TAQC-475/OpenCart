package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {

    protected final String SUB_CATEGORIES = "//div[@class='list-group']/a[contains(text(),'-')]";

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

    //------------------------------------------------------------------------------------------------------------------
    public Map<String, List<String>> getLeftMenuCategoriesMap() {
        Map<String, List<String>> menuLeftCategoriesMap = new HashMap();
        for (WebElement menuItem : getLeftMenuItemList()) {
            String categoryText = withoutNumbers(menuItem.getText());
//            new Actions(driver).moveToElement(menuItem).build().perform();
//            menuItem.click();
            Actions action = new Actions(driver);
            System.out.println("0");
            action.moveToElement(menuItem).build().perform();
            System.out.println("1");
            action.click().perform();
            System.out.println("2");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (true) {  // !
                System.out.println("4");
                List<WebElement> subCategoryElementList = driver.findElements(By.xpath(String.format(SUB_CATEGORIES, categoryText)));
                System.out.println("5");
                List<String> subCategoriesStringList = new ArrayList();
                System.out.println("6");
                for (WebElement subMenuItem : subCategoryElementList) {
                    subCategoriesStringList.add(subMenuItem.getText());
                }
                menuLeftCategoriesMap.put(categoryText, subCategoriesStringList);
            } else {
                menuLeftCategoriesMap.put(categoryText, null);
            }
        }
        return menuLeftCategoriesMap;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Business Logic

}
