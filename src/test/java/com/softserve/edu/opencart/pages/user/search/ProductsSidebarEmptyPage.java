package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.softserve.edu.opencart.tools.RegularExpression.cutPrefixFromSubCategory;
import static com.softserve.edu.opencart.tools.RegularExpression.cutSuffixFromCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {
    protected final String LEFT_MENU_ELEMENT = "//div[@class='list-group']/a[contains(text(),'%s')]";
    protected final String SUB_CATEGORIES_NUMBER_ONE = "//div[@class='list-group']/a[contains(text(),'-')][1]";
    protected final String SUB_CATEGORIES = "//div[@class='list-group']/a[contains(text(),'-')]";

    public ProductsSidebarEmptyPage(WebDriver driver) {
        super(driver);
    }

    // Page Object
    private boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    // Functional
    private boolean isSubCategoriesPresent(){
        boolean present;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if(driver.findElements(By.xpath(SUB_CATEGORIES_NUMBER_ONE)).size() != 0) {
            present = true;
        }else {
            present = false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return present;
    }

    public Map<String, List<String>> getLeftMenuCategoriesMap() {
        Map<String, List<String>> menuLeftCategoriesMap = new HashMap();
        for (String menuItem : getLeftMenuItemListText()) {
//            if(!isVisible(menuItem)){continue;}
            String categoryText = cutSuffixFromCategory(menuItem);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(String.format(LEFT_MENU_ELEMENT,menuItem)))).build().perform();

            actions.click().perform();

            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until((ExpectedCondition<Boolean>) driver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return window.jQuery != undefined && jQuery.active == 0"));

            readSubCategories(menuLeftCategoriesMap, categoryText);
        }
        return menuLeftCategoriesMap;
    }

    private void readSubCategories(Map<String, List<String>> menuLeftCategoriesMap, String categoryText) {
        if (isSubCategoriesPresent()) {
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
    //------------------------------------------------------------------------------------------------------------------

    // Business Logic

}
