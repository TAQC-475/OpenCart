package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.tools.RegularExpression;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends BreadCrumbPart {
    private WebElement shoppingCartExpectedText;

    private By messageAboutSuccessfulRefresh = By.xpath("//div[contains (text(), 'Success: You have modified your shopping cart!')]");
    private By messageAboutApplyingShippingMethod = By.xpath("//div[contains (text(), 'Success: Your shipping estimate has been applied')]");

    private ShoppingCartProductsContainer shoppingCartProductsContainer;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    public void initElements() {
        shoppingCartExpectedText = driver.findElement(By.xpath("//div[@id = 'content']/h1[contains (text(), 'Shopping Cart')]"));
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
        return driver.findElement(By.xpath("//a[contains (text(), 'Shipping & Taxes')]"));
    }

    public ShoppingCartProductsContainer getShoppingCartProductsContainer() {
        return shoppingCartProductsContainer;
    }

    /**
     * checks if shipping and taxes accordion is expanded, if not, clicks on it and returns page, if expanded just returns new page
     *
     * @return new ShippingAndTaxesComponent page
     */
    public ShippingAndTaxesComponent goToShippingAndTaxesComponent() {
        By shippingAndTaxesComponentExpanded = By.xpath("//a[@aria-expanded = 'true' and contains (text(), 'Estimate Shipping & Taxes')]");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        if (isElementPresent(shippingAndTaxesComponentExpanded)) {
            return new ShippingAndTaxesComponent(driver);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getShippingAndTaxes().click();
        return new ShippingAndTaxesComponent(driver);
    }

    /**
     * finds container component by product from param and clicks refresh button
     *
     * @param product
     * @return refreshed ShoppingCartPage
     */
    public ShoppingCartPage refreshShoppingCartPageByProduct(Product product) {
                getShoppingCartProductsContainer()
                .getContainerComponentByProduct(product)
                .clickRefreshButton();
        waitUtils.setImplicitWait(0);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(messageAboutSuccessfulRefresh));
        waitUtils.setImplicitWait(10);
        return new ShoppingCartPage(driver);
    }

    /**
     * finds container component by product from param and clicks remove button
     *
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
     * finds container component by product from param, clears current quantity and sets quantity from param
     *
     * @param product
     * @param quantity quantity of products
     * @return refreshed ShoppingCartPage with entered input quantity
     */
    public ShoppingCartPage setQuantity(Product product, String quantity) {
        ShoppingCartContainerComponent shoppingCartProductComponent = getShoppingCartProductsContainer()
                .getContainerComponentByProduct(product);
        shoppingCartProductComponent.getQuantity().clear();
        shoppingCartProductComponent.getQuantity().sendKeys(quantity);
        return refreshShoppingCartPageByProduct(product);
    }

    /**
     * driver adds element lo list if element is found, if not list is empty
     *
     * @param by element to check
     * @return true if list is not empty, false if empty
     */
    public boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    /**
     * gets text from sub-total price field and returns BigDecimal value
     *
     * @return BigDecimal value from sub-total price field
     */
    public BigDecimal getActualSubTotalPrice() {
        WebElement subTotal = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//strong[contains (text(), 'Sub-Total')]/parent::td/following-sibling::td"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(subTotal.getText());
    }

    /**
     * gets text from flat shipping rate field and returns BigDecimal value
     *
     * @return BigDecimal value from flat shipping rate field
     */
    public BigDecimal getOrderFlatShippingRate() {
        WebElement flatShippingRate = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//strong[contains (text(), 'Flat Shipping Rate')]/parent::td/following-sibling::td"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(flatShippingRate.getText());
    }

    /**
     * gets text from total price field and returns BigDecimal value
     *
     * @return BigDecimal value from total price field
     */
    public BigDecimal getActualTotalPrice() {
        WebElement total = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//tr[last()]/td[not (child::strong)]"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(total.getText());
    }

    /**
     * gets product container from ShoppingCartPage and returns total price of products in it
     *
     * @return BigDecimal value of calculated orders total price
     */
    public BigDecimal getExpectedSubTotalPrice() {
        return getShoppingCartProductsContainer().calculateExpectedSubTotalPrice();
    }

    /**
     * checks if expected and actual sub-total prices are equal
     *
     * @return true if sub-total prices are equal, false if they don't
     */
    public boolean areExpectedAndActualSubTotalPricesEqual() {
        return getShoppingCartProductsContainer().calculateExpectedSubTotalPrice().equals(getActualSubTotalPrice());
    }

    /**
     * checks if expected and actual total prices are equal
     *
     * @return true if total prices are equal, false if they don't
     */
    public boolean areExpectedAndActualTotalPricesEqual() {
        BigDecimal expectedTotalPrice = getExpectedSubTotalPrice().add(getOrderFlatShippingRate());
        return expectedTotalPrice.equals(getActualTotalPrice());
    }

    /**
     * goes through container components list and checks if product form param is not present in it
     * @param expectedRemovedItem product expected to be removed
     * @return false if product is present in  list, true if don't
     */
    public boolean verifyProductRemoved(Product expectedRemovedItem) {
        for (ShoppingCartContainerComponent component : getShoppingCartProductsContainer().getContainerComponents()) {
            if (component.getProductNameText().equals(expectedRemovedItem.getName())) {
                return false;
            }
        }
        return true;
    }
}
