package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import com.softserve.edu.opencart.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProductsContainer {
    private final String shoppingCartContainerComponentXpath = "//div[@class = 'table-responsive']//table[@class = 'table table-bordered']/tbody/tr";

    protected WebDriver driver;

    private List<ShoppingCartContainerComponent> containerComponents;

    public ShoppingCartProductsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        containerComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(shoppingCartContainerComponentXpath))) {
            containerComponents.add(new ShoppingCartContainerComponent(current));
        }
    }

    public List<ShoppingCartContainerComponent> getContainerComponents() {
        return containerComponents;
    }

    public int getContainerComponentsCount() {
        return getContainerComponents().size();
    }

    public List<String> getContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (ShoppingCartContainerComponent current : getContainerComponents()) {
            containerComponentNames.add(current.getProductNameText());
        }
        return containerComponentNames;
    }

    /**
     * goes trough the list of components present at the page, and check if component with name from param is present
     * @param productName
     * returns component with name from param
     */
    protected ShoppingCartContainerComponent getContainerComponentByName(String productName) {
        ShoppingCartContainerComponent result = null;

        for (ShoppingCartContainerComponent current : getContainerComponents()) {
            if (current.getProductNameText().toLowerCase().equals(productName.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            throw new RuntimeException(String.format("Product with name: %s not found", productName));
        }
        return result;
    }

    public String getContainerComponentModelByName(String productName) {
        return getContainerComponentByName(productName).getModelText();
    }

    public String getContainerComponentQuantityByName(String productName) {
        return getContainerComponentByName(productName).getQuantityText();
    }

    public String getContainerComponentUnitPriceByName(String productName) {
        return getContainerComponentByName(productName).getUnitPriceText();
    }

    public String getContainerComponentTotalPriceByName(String productName) {
        return getContainerComponentByName(productName).getTotalPriceText();
    }

    public void clickContainerComponentNameButtonByName(String productName) {
        getContainerComponentByName(productName).clickOnProductName();
    }

    public void clickContainerComponentRefreshButtonByName(String productName) {
        getContainerComponentByName(productName).clickRefreshButton();
    }

    public void clickContainerComponentRemoveButtonByName(String productName) {
        getContainerComponentByName(productName).clickRemoveButton();
    }

    public String getContainerComponentModelByProduct(Product product) {
        return getContainerComponentModelByName(product.getName());
    }

    public String getContainerComponentQuantityByProduct(Product product) {
        return getContainerComponentQuantityByName(product.getName());
    }

    public String getContainerComponentUnitPriceByProduct(Product product) {
        return getContainerComponentUnitPriceByName(product.getName());
    }

    public String getContainerComponentTotalPriceByProduct(Product product) {
        return getContainerComponentTotalPriceByName(product.getName());
    }

    public void clickContainerComponentNameButtonByProduct(Product product) {
        clickContainerComponentNameButtonByName(product.getName());
    }

    public void clickContainerComponentRefreshButtonByProduct(Product product) {
        clickContainerComponentRefreshButtonByName(product.getName());
    }

    public void clickContainerComponentRemoveButtonByProduct(Product product) {
        clickContainerComponentRemoveButtonByName(product.getName());
    }

    /**
     * @param product
     * @return product component from page by product from param
     */
    public ShoppingCartContainerComponent getContainerComponentByProduct(Product product) {
        return getContainerComponentByName(product.getName());
    }

    /**
     * Calculating shopping page order expected sub-total price
     * @return calculated expected subTotal price
     */
    public BigDecimal calculateExpectedSubTotalPrice() {
        List<BigDecimal> productsExpectedTotalPrices = new ArrayList<>();
        for(ShoppingCartContainerComponent component: getContainerComponents()){
            productsExpectedTotalPrices.add(component.calculateContainerComponentExpectedTotalPrice());
        }
        BigDecimal subTotalPrice = new BigDecimal(0);
        for (BigDecimal decimal : productsExpectedTotalPrices) {
            subTotalPrice = subTotalPrice.add(decimal);
        }
        return subTotalPrice;
    }
}
