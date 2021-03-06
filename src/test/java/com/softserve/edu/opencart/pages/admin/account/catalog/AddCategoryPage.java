package com.softserve.edu.opencart.pages.admin.account.catalog;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCategoryPage extends LeftMenuPart {

    private WebElement inputName;
    private WebElement inputTitle;
    private WebElement dataButton;
    private WebElement inputParent;
    private WebElement addToTopMenu;
    private WebElement saveButton;

    public AddCategoryPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        inputName = driver.findElement(By.id("input-name1"));
        inputTitle = driver.findElement(By.id("input-meta-title1"));
        dataButton = driver.findElement(By.xpath("//a[@href='#tab-data']"));
        inputParent = driver.findElement(By.cssSelector("#input-parent"));
        addToTopMenu = driver.findElement(By.cssSelector("#input-top"));
        saveButton = driver.findElement(By.cssSelector(".btn-primary > .fa"));
    }

    public AddCategoryPage typeName(String arg){
        inputName.click();
        inputName.clear();
        inputName.sendKeys(arg);
        return this;
    }

    public AddCategoryPage typeTitle(String arg) {
        inputTitle.click();
        inputTitle.clear();
        inputTitle.sendKeys(arg);
        return this;
    }

    public AddCategoryPage clickDataButton(){
        dataButton.click();
        return this;
    }

    public AddCategoryPage typeParent(String arg){
        inputParent.click();
        inputParent.clear();
        inputParent.sendKeys(arg);
        return this;
    }

    public AddCategoryPage clickAddToTopMenu(){
        addToTopMenu.click();
        return this;
    }

    public ModifiedCatalogPage gotoModifiedCatalogPage() {
        saveButton.click();
        return new ModifiedCatalogPage(driver);
    }

}
