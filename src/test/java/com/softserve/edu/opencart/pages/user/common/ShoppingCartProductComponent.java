package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.tools.RegularExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class ShoppingCartProductComponent {
    private WebElement shoppingCartProductLayout;

    private WebElement image;
    private WebElement productName;
    private WebElement model;
    private WebElement quantity;
    private WebElement unitPrice;
    private WebElement totalPrice;
    private WebElement refreshButton;
    private WebElement removeButton;

    public ShoppingCartProductComponent(WebElement shoppingCartProductLayout) {
        this.shoppingCartProductLayout = shoppingCartProductLayout;
        initElements();
    }

    public void initElements() {
        image = shoppingCartProductLayout.findElement(By.xpath(".//td[@class = 'text-center']/a"));
        productName = shoppingCartProductLayout.findElement(By.xpath(".//td[@class = 'text-left']/a"));
        model = shoppingCartProductLayout.findElement(By.xpath(".//td[@class = 'text-left'][2]"));
        quantity = shoppingCartProductLayout.findElement(By.xpath(".//input[@type = 'text']"));
        refreshButton = shoppingCartProductLayout.findElement(By.xpath(".//button[@data-original-title = 'Update']"));
        removeButton = shoppingCartProductLayout.findElement(By.xpath(".//button[@data-original-title = 'Remove']"));
        unitPrice = shoppingCartProductLayout.findElement(By.xpath(".//td[@class = 'text-right'][last()-1]"));
        totalPrice = shoppingCartProductLayout.findElement(By.xpath(".//td[@class = 'text-right'][last()]"));
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getProductName() {
        return productName;
    }

    public String getProductNameText() {
        return getProductName().getText();
    }

    public void clickOnProductName() {
        getProductName().click();
    }

    public WebElement getModel() {
        return model;
    }

    public String getModelText() {
        return getModel().getText();
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public String getQuantityText() {
        return getQuantity().getAttribute("value");
    }

    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public String getUnitPriceText() {
        return getUnitPrice().getText();
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public String getTotalPriceText() {
        return getTotalPrice().getText();
    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public void clickRefreshButton(){
        getRefreshButton().click();
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public void clickRemoveButton(){
        getRemoveButton().click();
    }

    public BigDecimal calculateProductCorrectTotalPrice() {
        BigDecimal quantity = new BigDecimal(this.getQuantityText());
        BigDecimal bdPrice = new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(this.getUnitPriceText());
        BigDecimal totalPrice = bdPrice.multiply(quantity);
        return totalPrice;
    }
}
