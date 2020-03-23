package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.search.ProductInfoPage;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsContainerComponent {
    public final String PRODUCT_NOT_FOUND = "There is no product that matches the search criteria.";
    private final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";
    //
    protected WebDriver driver;
    //
    private List<ProductComponent> productComponents;
    private WaitUtils alertPageWait;

    public ProductsContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
            productComponents.add(new ProductComponent(current));
        }
        alertPageWait = new WaitUtils(driver, 10);
    }

    // Page Object

    // productComponents
    public List<ProductComponent> getProductComponents() {
        return productComponents;
    }

    // Functional

    public int getProductComponentsCount() {
        return getProductComponents().size();
    }

    public List<String> getProductComponentNames() {
        List<String> productComponentNames = new ArrayList<>();
        for (ProductComponent current : getProductComponents()) {
            productComponentNames.add(current.getNameText());
        }
        return productComponentNames;
    }

    protected ProductComponent getProductComponentByName(String productName) {
        ProductComponent result = null;
        for (ProductComponent current : getProductComponents()) {
            if (current.getNameText().toLowerCase()
                    .equals(productName.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            throw new RuntimeException("ProductName: " + productName + " not Found.");
        }
        return result;
    }

    // TODO Change to Product
    public String getProductComponentPriceByName(String productName) {
        return getProductComponentByName(productName).getPriceText();
    }

    // TODO Change to Product
    public String getProductComponentDescriptionByName(String productName) {
        return getProductComponentByName(productName).getPartialDescriptionText();
    }

    public void clickProductComponentAddToCartButton(Product product) {
        getProductComponentByName(product.getName()).clickAddToCartButton();
    }

    // TODO Change to Product
    public void clickProductComponentAddToWishButtonByName(String productName) {

        getProductComponentByName(productName).clickAddToWishButton();
    }

    public void clickProductComponentNameLink(Product product) {
        getProductComponentByName(product.getName()).clickName();
    }

    public String getProductComponentPriceByProduct(Product product) {
        return getProductComponentPriceByName(product.getName());
    }

    public String getProductComponentDescriptionByProduct(Product product) {
        return getProductComponentDescriptionByName(product.getName());
    }

    // Business Logic

    public ProductComponent getProductComponentByName(Product product) {
        return getProductComponentByName(product.getName());
    }

    public AddProductAlertPage addProductToCartDirectly(Product product) {
        clickProductComponentAddToCartButton(product);
        alertPageWait.waitForAlertVisibility();
        return new AddProductAlertPage(driver);
    }

    public ProductInfoPage openProductFromContainer(Product product) {
        clickProductComponentNameLink(product);
        return new ProductInfoPage(driver);
    }

    public ProductComponent getFirstProduct()
    {
        WebElement firstProduct = driver.findElement(By.cssSelector("#content .product-layout:nth-child(1)"));
        return new ProductComponent(firstProduct);
    }

}
