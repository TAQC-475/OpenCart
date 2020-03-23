package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.tools.RegularExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends BreadCrumbPart {
    private WebElement shoppingCartExpectedText;
    private WebElement shippingAndTaxes;

    private By messageAboutSuccessfulRefresh = By.xpath("//div[contains (text(), 'Success: You have modified your shopping cart!')]");
    private By messageAboutApplyingShippingMethod = By.xpath("//div[contains (text(), 'Success: Your shipping estimate has been applied')]");

    private ShoppingCartProductsContainer shoppingCartProductsContainer;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    public void initElements() {
        shoppingCartExpectedText = driver.findElement(By.xpath("//div[@id = 'content']/h1[contains (text(), 'Shopping Cart')]"));
        shippingAndTaxes = driver.findElement(By.xpath("//a[contains (text(), 'Shipping & Taxes')]"));
        shoppingCartProductsContainer = new ShoppingCartProductsContainer(driver);
    }

    public By getMessageAboutSuccessfulRefresh() {
        return messageAboutSuccessfulRefresh;
    }

    public By getMessageAboutApplyingShippingMethod() {
        return messageAboutApplyingShippingMethod;
    }

    public WebElement getShoppingCartExpectedText() {
        return shoppingCartExpectedText;
    }

    public WebElement getShippingAndTaxes() {
        return shippingAndTaxes;
    }

    public ShoppingCartProductsContainer getShoppingCartProductsContainer() {
        return shoppingCartProductsContainer;
    }

    /**
     * checks if shipping and taxes accordion is expanded, if not, clicks on it and returns page, if expanded just returns new page
     * @return new ShippingAndTaxesComponent page
     */
    public ShippingAndTaxesComponent goToShippingAndTaxesComponent() {
        By shippingAndTaxesComponentExpanded = By.xpath("//a[@aria-expanded = 'true' and contains (text(), 'Estimate Shipping & Taxes')]");
        if(!driver.findElements(shippingAndTaxesComponentExpanded).isEmpty()){
            return new ShippingAndTaxesComponent(driver);
        }
//        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
//        if(isElementPresent(shippingAndTaxesComponentExpanded)){
//            return new ShippingAndTaxesComponent(driver);
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getShippingAndTaxes().click();
        return new ShippingAndTaxesComponent(driver);
    }

    /**
     * finds product component by product from param and clicks refresh button
     * @param product
     * @return refreshed ShoppingCartPage
     */
    public ShoppingCartPage refreshShoppingCartPageByProduct(Product product) {
        this.getShoppingCartProductsContainer()
                .getContainerComponentByProduct(product)
                .clickRefreshButton();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(messageAboutSuccessfulRefresh));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new ShoppingCartPage(driver);
    }

    /**
     * finds product component by product from param and clicks remove button
     * @param product
     * @return new ShoppingCartPage after removing a component
     */
    public ShoppingCartPage removeComponentByProduct(Product product) {
        this.getShoppingCartProductsContainer()
                .getContainerComponentByProduct(product)
                .clickRemoveButton();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.stalenessOf(this.getShoppingCartProductsContainer()
                        .getContainerComponentByProduct(product).getProductName()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new ShoppingCartPage(driver);
    }

    /**
     * finds product component by product from param, clears current quantity and sets quantity from param
     * @param product
     * @param quantity
     * @return refreshed ShoppingCartPage
     */
    public ShoppingCartPage setQuantity(Product product, String quantity) {
        ShoppingCartContainerComponent shoppingCartProductComponent = getShoppingCartProductsContainer()
                .getContainerComponentByProduct(product);
        shoppingCartProductComponent.getQuantity().clear();
        shoppingCartProductComponent.getQuantity().sendKeys(quantity);
        return refreshShoppingCartPageByProduct(product);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public BigDecimal getActualSubTotalPrice() {
        WebElement subTotal = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//strong[contains (text(), 'Sub-Total')]/parent::td/following-sibling::td"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartField(subTotal.getText());
    }

    public BigDecimal getOrderFlatShippingRate(){
        WebElement flatShippingRate = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//strong[contains (text(), 'Flat Shipping Rate')]/parent::td/following-sibling::td"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartField(flatShippingRate.getText());
    }

    public BigDecimal getActualTotalPrice(){
        WebElement total = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//tr[last()]/td[not (child::strong)]"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartField(total.getText());
    }

    public BigDecimal getExpectedSubTotalPrice(){
        return getShoppingCartProductsContainer().calculateExpectedSubTotalPrice();
    }

    public boolean areExpectedAndActualSubTotalPricesEqual() {
        return getShoppingCartProductsContainer().calculateExpectedSubTotalPrice().equals(getActualSubTotalPrice());
    }

    public boolean areExpectedAndActualTotalPricesEqual(){
        BigDecimal expectedTotalPrice = getExpectedSubTotalPrice().add(getOrderFlatShippingRate());
        return expectedTotalPrice.equals(getActualTotalPrice());
    }
}
