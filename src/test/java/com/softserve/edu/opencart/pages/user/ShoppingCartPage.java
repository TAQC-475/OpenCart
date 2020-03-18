package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.pages.user.common.ShoppingCartProductComponent;
import com.softserve.edu.opencart.pages.user.common.ShoppingCartProductsContainerComponent;
import com.softserve.edu.opencart.tools.RegularExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartPage extends BreadCrumbPart {
    private WebElement shoppingCartExpectedText;

    private ShoppingCartProductsContainerComponent shoppingCartProductsContainerComponent;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    public void initElements() {
        shoppingCartExpectedText = driver.findElement(By.xpath("//div[@id = 'content']/h1[contains (text(), 'Shopping Cart')]"));
        shoppingCartProductsContainerComponent = new ShoppingCartProductsContainerComponent(driver);
    }

    public WebElement getShoppingCartExpectedText() {
        return shoppingCartExpectedText;
    }

    public ShoppingCartProductsContainerComponent getShoppingCartProductsContainerComponent() {
        return shoppingCartProductsContainerComponent;
    }

    public ShoppingCartPage refreshShoppingCartPageByProduct(Product product) {
        this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product)
                .clickRefreshButton();
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage removeShoppingCartComponentFromContainerByProduct(Product product) {
        this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product)
                .clickRemoveButton();
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage setQuantity(Product product, String quantity) {
        ShoppingCartProductComponent shoppingCartProductComponent = this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product);
        shoppingCartProductComponent.getQuantity().clear();
        shoppingCartProductComponent.getQuantity().sendKeys(quantity);
        return refreshShoppingCartPageByProduct(product);

    }

    public BigDecimal calculateProductCorrectTotalPrice(Product product) {
        ShoppingCartProductComponent productComponent = this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product);
        BigDecimal quantity = new BigDecimal(productComponent.getQuantityText());
        String unitPrice = productComponent.getUnitPriceText();
        BigDecimal bdPrice = new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(unitPrice);
        BigDecimal totalPrice = bdPrice.multiply(quantity);
        return totalPrice;
    }

    public BigDecimal calculateOrderCorrectTotalPrice(List<BigDecimal> productsCorrectTotalPrices) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (BigDecimal decimal : productsCorrectTotalPrices) {
            totalPrice = totalPrice.add(decimal);
        }
        return totalPrice;
    }
}
