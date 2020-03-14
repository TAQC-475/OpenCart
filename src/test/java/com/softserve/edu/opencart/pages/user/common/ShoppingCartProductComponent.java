package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartProductComponent {
    private WebElement shoppingCartProductLayout;

    private WebElement image;
    private WebElement productName;
    private WebElement model;
    private WebElement quantity;
    private WebElement unitPrice;
    private WebElement totalPrice;

    public ShoppingCartProductComponent(WebElement shoppingCartProductLayout) {
        this.shoppingCartProductLayout = shoppingCartProductLayout;
        initElements();
    }

    public void initElements(){
        image = shoppingCartProductLayout.findElement(By.xpath("/td[@class = 'text-center']/a"));
    }

    public WebElement getImage() {
        return image;
    }
}
