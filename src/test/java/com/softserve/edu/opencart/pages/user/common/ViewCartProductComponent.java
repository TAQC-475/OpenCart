package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewCartProductComponent {

    private WebElement product;
    //
    private WebElement image;
    private WebElement name;
    private WebElement quantity;
    private WebElement price;
    private WebElement removeButton;

    public ViewCartProductComponent(WebElement product) {
        this.product = product;
        initElements();
    }

    private void initElements() {
        image = product.findElement(By.xpath("./td[@class='text-center']/a"));
        name = product.findElement(By.xpath("./td[@class='text-left']"));
        quantity = product.findElement(By.xpath("./td[@class='text-right'][1]"));
        price = product.findElement(By.xpath("./td[@class='text-right'][2]"));
        removeButton = product.findElement(By.xpath("./td[@class='text-center']/button"));
    }

    public WebElement getProduct() {
        return product;
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getName() {
        return name;
    }

    public String getNameText() {
        return getName().getText();
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public String getQuantityText() {
        return getQuantity().getText();
    }

    public WebElement getPrice() {
        return price;
    }

    public String getPriceText() {
        return getPrice().getText();
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public void removeProductFromCart() {
        getRemoveButton().click();
    }

}
