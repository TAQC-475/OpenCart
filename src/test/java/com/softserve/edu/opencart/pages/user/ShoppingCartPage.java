package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.pages.user.common.ShoppingCart.ShoppingCartShippingAndTaxesComponent;
import com.softserve.edu.opencart.pages.user.common.ShoppingCart.ShoppingCartProductComponent;
import com.softserve.edu.opencart.pages.user.common.ShoppingCart.ShoppingCartProductsContainerComponent;
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

    private ShoppingCartProductsContainerComponent shoppingCartProductsContainerComponent;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    public void initElements() {
        shoppingCartExpectedText = driver.findElement(By.xpath("//div[@id = 'content']/h1[contains (text(), 'Shopping Cart')]"));
        shippingAndTaxes = driver.findElement(By.xpath("//a[contains (text(), 'Shipping & Taxes')]"));
        shoppingCartProductsContainerComponent = new ShoppingCartProductsContainerComponent(driver);
    }

    public By getMessageAboutSuccessfulRefresh() {
        return messageAboutSuccessfulRefresh;
    }

    public WebElement getShoppingCartExpectedText() {
        return shoppingCartExpectedText;
    }

    public WebElement getShippingAndTaxes() {
        return shippingAndTaxes;
    }

    public ShoppingCartProductsContainerComponent getShoppingCartProductsContainerComponent() {
        return shoppingCartProductsContainerComponent;
    }

    public ShoppingCartShippingAndTaxesComponent goToShippingAndTaxesComponent(){
        getShippingAndTaxes().click();
        return new ShoppingCartShippingAndTaxesComponent(driver);
    }

    public ShoppingCartPage refreshShoppingCartPageByProduct(Product product) {
        this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product)
                .clickRefreshButton();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(messageAboutSuccessfulRefresh));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage removeShoppingCartComponentFromContainerByProduct(Product product) {
        this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product)
                .clickRemoveButton();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.stalenessOf(this.getShoppingCartProductsContainerComponent()
                        .getShoppingCartProductComponentByProduct(product).getProductName()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage setQuantity(Product product, String quantity) {
        ShoppingCartProductComponent shoppingCartProductComponent = this.getShoppingCartProductsContainerComponent()
                .getShoppingCartProductComponentByProduct(product);
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

    public BigDecimal getOrderSubTotalPrice() {
        WebElement subTotal = driver.findElement(By.xpath("//div[@class = 'col-sm-4 col-sm-offset-8']//strong[contains (text(), 'Sub-Total')]/parent::td/following-sibling::td"));
        return new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(subTotal.getText());
    }

    public boolean areCorrectAndActualTotalPricesEqual() {
        return getShoppingCartProductsContainerComponent().calculateOrderCorrectTotalPrice().equals(getOrderSubTotalPrice());
    }

    public int sizeDifferenceBeforeAndAfterRemoving(int sizeBeforeRemoving) {
        return sizeBeforeRemoving - getShoppingCartProductsContainerComponent().getShoppingCartProductComponentCount();
    }

//    public ShoppingCartPage assertThatSizeOfContainerComponentsIsReducingAfterDeleting(Product product){
//        int numberOfProductsBeforeRemoving = getShoppingCartProductsContainerComponent().getShoppingCartProductComponentCount();
//        ShoppingCartPage shoppingCartPage= removeShoppingCartComponentFromContainerByProduct(product);
//        int numberOfProductsAfterRemoving = shoppingCartPage.getShoppingCartProductsContainerComponent().getShoppingCartProductComponentCount();
//        Assert.assertTrue(numberOfProductsAfterRemoving < numberOfProductsBeforeRemoving);
//        return new ShoppingCartPage(driver);
//    }
}
