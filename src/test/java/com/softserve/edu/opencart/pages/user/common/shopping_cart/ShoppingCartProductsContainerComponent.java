package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import com.softserve.edu.opencart.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProductsContainerComponent {
    private final String shoppingCartProductComponentXpath = "//div[@class = 'table-responsive']//table[@class = 'table table-bordered']/tbody/tr";

    protected WebDriver driver;

    private List<ShoppingCartProductComponent> shoppingCartProductComponents;

    public ShoppingCartProductsContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        shoppingCartProductComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(shoppingCartProductComponentXpath))) {
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

    /**
     * goes trough the list of components present at the page, and check if component with name from param is present
     * @param productName
     * returns component with name from param
     */
    protected ShoppingCartProductComponent getProductComponentByName(String productName) {
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
        return getProductComponentByName(productName).getModelText();
    }

    public String getShoppingCartProductQuantityByName(String productName) {
        return getProductComponentByName(productName).getQuantityText();
    }

    public String getShoppingCartProductUnitPriceByName(String productName) {
        return getProductComponentByName(productName).getUnitPriceText();
    }

    public String getShoppingCartProductTotalPriceByName(String productName) {
        return getProductComponentByName(productName).getTotalPriceText();
    }

    public void clickOnShoppingCartProductComponentNameButtonByName(String productName) {
        getProductComponentByName(productName).clickOnProductName();
    }

    public void clickOnShoppingCartProductComponentRefreshButtonByName(String productName) {
        getProductComponentByName(productName).clickRefreshButton();
    }

    public void clickOnShoppingCartProductComponentRemoveButtonByName(String productName) {
        getProductComponentByName(productName).clickRemoveButton();
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

    /**
     * @param product
     * returns product component from page by product from param
     */
    public ShoppingCartProductComponent getProductComponentByProduct(Product product) {
        return getProductComponentByName(product.getName());
    }

    /**
     * Calculating shopping page order expected sub total price
     * return calculated expected subTotal price
     */
    public BigDecimal calculateExpectedSubTotalPrice() {
        List<BigDecimal> productsExpectedTotalPrices = new ArrayList<>();
        for(ShoppingCartProductComponent component: getShoppingCartProductComponents()){
            productsExpectedTotalPrices.add(component.calculateExpectedComponentTotalPrice());
        }
        BigDecimal subTotalPrice = new BigDecimal(0);
        for (BigDecimal decimal : productsExpectedTotalPrices) {
            subTotalPrice = subTotalPrice.add(decimal);
        }
        return subTotalPrice;
    }
}
