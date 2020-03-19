package com.softserve.edu.opencart.pages.admin.account.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModifiedCatalogPage extends CategoriesPage {

    private WebElement success;

    public ModifiedCatalogPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        success = driver.findElement(By.cssSelector(".alert"));

    }

    public String getSuccessText() {
        return success.getText();
    }

}
