package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Product;
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

    public int getShoppingCartProductComponentCount() {
        return getShoppingCartProductComponents().size();
    }

    public List<String> getShoppingCartProductComponentNames() {
        List<String> shoppingCartProductComponentNames = new ArrayList<>();
        for (ShoppingCartProductComponent current : getShoppingCartProductComponents()) {
            shoppingCartProductComponentNames.add(current.getProductNameText());
        }
        return shoppingCartProductComponentNames;
    }

    protected ShoppingCartProductComponent getShoppingCartProductComponentByName(String productName) {
        ShoppingCartProductComponent result = null;
        for (ShoppingCartProductComponent current : getShoppingCartProductComponents()) {
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

    public String getShoppingCartProductModelByName(String productName) {
        return getShoppingCartProductComponentByName(productName).getModelText();
    }

    public String getShoppingCartProductQuantityByName(String productName) {
        return getShoppingCartProductComponentByName(productName).getQuantityText();
    }

    public String getShoppingCartProductUnitPriceByName(String productName) {
        return getShoppingCartProductComponentByName(productName).getUnitPriceText();
    }

    public String getShoppingCartProductTotalPriceByName(String productName) {
        return getShoppingCartProductComponentByName(productName).getTotalPriceText();
    }

    public void clickOnShoppingCartProductComponentNameButtonByName(String productName) {
        getShoppingCartProductComponentByName(productName).clickOnProductName();
    }

    public void clickOnShoppingCartProductComponentRefreshButtonByName(String productName) {
        getShoppingCartProductComponentByName(productName).clickRefreshButton();
    }

    public void clickOnShoppingCartProductComponentRemoveButtonByName(String productName) {
        getShoppingCartProductComponentByName(productName).clickRemoveButton();
    }

    public String getShoppingCartProductComponentModelByProduct(Product product) {
        return getShoppingCartProductModelByName(product.getName());
    }

    public String getShoppingCartProductComponentQuantityByProduct(Product product) {
        return getShoppingCartProductQuantityByName(product.getName());
    }

    public String getShoppingCartProductComponentUnitPriceByProduct(Product product) {
        return getShoppingCartProductUnitPriceByName(product.getName());
    }

    public String getShoppingCartProductComponentTotalPriceByProduct(Product product) {
        return getShoppingCartProductTotalPriceByName(product.getName());
    }

    public void clickOnShoppingCartProductComponentNameButtonByProduct(Product product) {
        clickOnShoppingCartProductComponentNameButtonByName(product.getName());
    }

    public void clickOnShoppingCartProductComponentRefreshButtonByProduct(Product product) {
        clickOnShoppingCartProductComponentRefreshButtonByName(product.getName());
    }

    public void clickOnShoppingCartProductComponentRemoveButtonByProduct(Product product) {
        clickOnShoppingCartProductComponentRemoveButtonByName(product.getName());
    }

    public ShoppingCartProductComponent getShoppingCartProductComponentByName(Product product) {
        return getShoppingCartProductComponentByName(product.getName());
    }
}
