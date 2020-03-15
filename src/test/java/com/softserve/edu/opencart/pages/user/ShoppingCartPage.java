package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.pages.user.common.ShoppingCartProductsContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BreadCrumbPart {
    private WebElement shoppingCartExpectedText;

    private ShoppingCartProductsContainerComponent shoppingCartProductsContainerComponent;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    public void initElements(){
        shoppingCartExpectedText = driver.findElement(By.xpath("//div[@id = 'content']/h1[contains (text(),  'Shopping Cart')]"));
        shoppingCartProductsContainerComponent = new ShoppingCartProductsContainerComponent(driver);
    }

    public WebElement getShoppingCartExpectedText() {
        return shoppingCartExpectedText;
    }

    public ShoppingCartProductsContainerComponent getShoppingCartProductsContainerComponent() {
        return shoppingCartProductsContainerComponent;
    }
}
