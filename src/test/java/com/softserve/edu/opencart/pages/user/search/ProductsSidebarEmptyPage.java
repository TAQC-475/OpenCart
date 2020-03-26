package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static com.softserve.edu.opencart.tools.RegularExpression.cutPrefixFromSubCategory;
import static com.softserve.edu.opencart.tools.RegularExpression.cutSuffixFromCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {
    protected final String LEFT_MENU_ELEMENT = "//div[@class='list-group']/a[contains(text(),'%s')]";
    protected final String SUB_CATEGORIES_NUMBER_ONE = "//div[@class='list-group']/a[contains(text(),'-')][1]";
    protected final String SUB_CATEGORIES = "//div[@class='list-group']/a[contains(text(),'-')]";

    public ProductsSidebarEmptyPage(WebDriver driver) {
        super(driver);
    }

    // Page Object

    // Functional

    private boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public Map<String, List<String>> getLeftMenuCategoriesMap() {
        Map<String, List<String>> menuLeftCategoriesMap = new HashMap();
        for (String menuItem : getLeftMenuItemListText()) {
            System.out.println("-5");

//            if(!isVisible(menuItem)){continue;}
            String categoryText = cutSuffixFromCategory(menuItem);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(String.format(LEFT_MENU_ELEMENT,menuItem)))).build().perform();
            actions.click().perform();

            if (driver.findElements(By.xpath(SUB_CATEGORIES_NUMBER_ONE)).size() != 0) {
                List<WebElement> subCategoryElementList = driver.findElements(By.xpath(String.format(SUB_CATEGORIES, categoryText)));
                List<String> subCategoriesStringList = new ArrayList();
                for (WebElement subMenuItem : subCategoryElementList) {
                    subCategoriesStringList.add(cutPrefixFromSubCategory(subMenuItem.getText()));
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
