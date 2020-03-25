package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import com.softserve.edu.opencart.tools.RegularExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class ShoppingCartContainerComponent {
    private WebElement shoppingCartContainerComponent;

    private WebElement productName;
    private WebElement model;
    private WebElement quantity;
    private WebElement unitPrice;
    private WebElement totalPrice;
    private WebElement refreshButton;
    private WebElement removeButton;

    public ShoppingCartContainerComponent(WebElement shoppingCartProductComponent) {
        this.shoppingCartContainerComponent = shoppingCartProductComponent;
        initElements();
    }

    public void initElements() {
        productName = shoppingCartContainerComponent.findElement(By.xpath("./td[@class = 'text-left']/a"));
        model = shoppingCartContainerComponent.findElement(By.xpath("./td[@class = 'text-left']/a/../following-sibling::td[@class = 'text-left' and not (div)]"));
        quantity = shoppingCartContainerComponent.findElement(By.xpath(".//input[@type = 'text']"));
        refreshButton = shoppingCartContainerComponent.findElement(By.xpath(".//button[@data-original-title = 'Update']"));
        removeButton = shoppingCartContainerComponent.findElement(By.xpath(".//button[@data-original-title = 'Remove']"));
        unitPrice = shoppingCartContainerComponent.findElement(By.xpath("./td[@class = 'text-right'][last()-1]"));
        totalPrice = shoppingCartContainerComponent.findElement(By.xpath("./td[@class = 'text-right'][last()]"));
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

    public void clickRefreshButton() {
        getRefreshButton().click();
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public void clickRemoveButton() {
        getRemoveButton().click();
    }

    /**
     * multiplies product quantity and unit price
     *
     * @return BigDecimal value of products total price
     */
    public BigDecimal calculateContainerComponentExpectedTotalPrice() {
        BigDecimal quantity = new BigDecimal(getQuantityText());
        BigDecimal bdPrice = new RegularExpression().getBigDecimalFromPriceField(getUnitPriceText());
        return bdPrice.multiply(quantity);
    }
}
