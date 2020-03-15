package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProductsContainerComponent {
    private final String SHOPPING_CART_PRODUCT_COMPONENT_XPATH = "//div[@class = 'table-responsive']//table[@class = 'table table-bordered']/tbody/tr";

    protected WebDriver driver;

    private List<ShoppingCartProductComponent> shoppingCartProductComponents;

    public ShoppingCartProductsContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void initElements() {
        shoppingCartProductComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(SHOPPING_CART_PRODUCT_COMPONENT_XPATH))) {
            shoppingCartProductComponents.add(new ShoppingCartProductComponent(current));
        }
    }

    public List<ShoppingCartProductComponent> getShoppingCartProductComponents() {
        return shoppingCartProductComponents;
    }

    public int getShoppingCartProductComponentCount(){
        return getShoppingCartProductComponents().size();
    }
}
