package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAndTaxesComponent {
    private WebElement country;
    private WebElement regionState;
    private WebElement postCode;
    private WebElement getQuotesButton;
    protected WebDriver driver;

    public ShippingAndTaxesComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        country = driver.findElement(By.xpath("//select[@id = 'input-country']"));
        regionState = driver.findElement(By.xpath("//select[@id = 'input-zone']"));
        postCode = driver.findElement(By.xpath("//input[@name = 'postcode']"));
        getQuotesButton = driver.findElement(By.xpath("//button[@id = 'button-quote']"));
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getRegionState() {
        return regionState;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getGetQuotesButton() {
        return getQuotesButton;
    }

    /**
     * selects country in country dropdown
     * @param countryName name of country which should be selected
     * @return ShippingAndTaxesComponent page with selected country
     */
    public ShippingAndTaxesComponent selectCountryByName(String countryName) {
        new Select(driver.findElement(By.xpath("//select[@id = 'input-country']"))).selectByVisibleText(countryName);
        return this;
    }

    /**
     * selects region/state in region/state dropdown
     * @param regionStateName name of region/state which should be selected
     * @return ShippingAndTaxesComponent page with selected region/state
     */
    public ShippingAndTaxesComponent selectRegionStateByName(String regionStateName) {
        new Select(driver.findElement(By.xpath("//select[@id = 'input-zone']"))).selectByVisibleText(regionStateName);
        return this;
    }

    /**
     * clears field and inputs new postcode
     * @param postCode
     * @return ShippingAndTaxesComponent page with entered postcode
     */
    public ShippingAndTaxesComponent inputPostCode(String postCode) {
        driver.findElement(By.xpath("//input[@name = 'postcode']")).clear();
        driver.findElement(By.xpath("//input[@name = 'postcode']")).sendKeys(postCode);
        return this;
    }

    /**
     * clicking getQuotes button and switches to SelectShippingMethodModalPage window
     * @return SelectShippingMethodModalPage
     */
    public SelectShippingMethodModalPage switchToSelectShippingMethodPage() {
        String shoppingCartWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@id = 'button-quote']")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new SelectShippingMethodModalPage(driver);
    }

    /**
     * refreshes page and returns ShoppingCartPage
     * @return ShoppingCartPage
     */
    public ShoppingCartPage goToShoppingCartFromShippingAndTaxes(){
        driver.navigate().refresh();
        return new ShoppingCartPage(driver);
    }
}
