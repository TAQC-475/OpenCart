package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductAlertPage extends TopPart{
    public static final String ADDED_PRODUCT_ALERT_MSG = "Success: You have added %s to your shopping cart! ";
    //
    private WebElement alertMessage;
    private WebElement alertButton;
    private WebElement productLink;
    private WebElement cartLink;

    public AddProductAlertPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        alertMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
        alertButton = driver.findElement(By.cssSelector(".alert.alert-success button"));
        productLink = alertMessage.findElement(By.xpath(".//a[contains(@href,'?route=product/product')]"));
        cartLink = alertMessage.findElement(By.xpath(".//a[contains(@href,'?route=checkout/cart')]"));
    }

    // Page Object

    // alertMessage
    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public String getAlertMessageText() {
        return getAlertMessage().getText();
    }

    // alertButton
    public WebElement getAlertButton() {
        return alertButton;
    }

    public void clickAlertButton() {
        getAlertButton().click();
    }

    public WebElement getProductLink() {
        return productLink;
    }

    public void clickProductLink() {
        getProductLink().click();
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public void clickCartLink() {
        getCartLink().click();
    }

    public ShoppingCartPage goToShoppingCartFromAlert(){
        clickCartLink();
        return new ShoppingCartPage(driver);
    }

}
