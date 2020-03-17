package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProductsSidebarEmptyPage extends ProductsSidebarPart {

    private List<WebElement> leftMenuItemList;

    public ProductsSidebarEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        leftMenuItemList = driver.findElements(By.xpath(".//div[@class='list-group']/a"));

    }

    // Page Object
    public List<WebElement> getLeftMenuItemList() {
        return leftMenuItemList;
    }

    // Functional
    private String withoutNumbers(String strInput){
        String strResult = "";
        Pattern p = Pattern.compile("[A-Z].+[^ (0-9)]");
        Matcher m = p.matcher(strInput);
        while(m.find()){
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

    public void gotoLeftMenuBar(){                      // hardcoded num of element to click on!
        getMainMenuComponent()
                .getMenuItemList()
                .get(4)
                .click();
    }

    // Business Logic
}
