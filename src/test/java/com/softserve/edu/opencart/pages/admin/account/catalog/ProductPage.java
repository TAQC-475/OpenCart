package com.softserve.edu.opencart.pages.admin.account.catalog;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends LeftMenuPart {

    private WebElement title;
    private WebElement addNewButton;
    private WebElement copyButton;
    private WebElement deleteButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        title = driver.findElement(By.cssSelector("div.page-header h1"));
        addNewButton = driver.findElement(By.cssSelector(".pull-right > .btn-primary > .fa"));
        copyButton = driver.findElement(By.cssSelector(".btn-default"));
        deleteButton = driver.findElement(By.cssSelector(".btn-danger > .fa"));
    }

    // Page object

    public WebElement getTitle() {
        return title;
    }

    public String getTitleText(){return getTitle().getText();}

    public WebElement getAddNewButton() {
        return addNewButton;
    }

    public String getAddNewButtonText(){return getAddNewButton().getText();}

    public WebElement getCopyButton() {
        return copyButton;
    }

    public String getCopyButtonText(){return getCopyButton().getText();}

    public void clickCopyButton() {
        getCopyButton().click();
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public String getDeleteButtonText(){return getDeleteButton().getText();}

    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    // Functional

    // Business logic

    public AddProductPage gotoAddProductPage() {
        getAddNewButton().click();
        return new AddProductPage(driver);
    }
}
