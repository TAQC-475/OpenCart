package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddProductAlertPage extends BreadCrumbPart {
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
        cartLink = alertMessage.findElement(By.xpath(".//a[text() = 'shopping cart']"));
    }

    // Page Object

    // alertMessage
    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public String getAlertMessageText() {
        String alert = getAlertMessage().getText();
        return alert.substring(0, alert.lastIndexOf("!")+1);
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
//        Actions builder = new Actions(driver);
//        builder.moveToElement(cartLink).build().perform();
        return cartLink;
    }

    public void clickCartLink() {
        getCartLink().click();
    }

    public ShoppingCartPage goToShoppingCartFromAlert() {
        clickCartLink();
        return new ShoppingCartPage(driver);
    }

    public HomePage goToHomePageFromAlert() {
        driver.navigate().refresh();
        return new HomePage(driver);
    }
}
