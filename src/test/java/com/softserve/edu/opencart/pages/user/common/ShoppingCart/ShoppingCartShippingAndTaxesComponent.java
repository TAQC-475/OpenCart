package com.softserve.edu.opencart.pages.user.common.ShoppingCart;

import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartShippingAndTaxesComponent {
    private WebElement country;
    private WebElement regionState;
    private WebElement postCode;
    private WebElement getQuotesButton;
    protected WebDriver driver;

    public ShoppingCartShippingAndTaxesComponent(WebDriver driver) {
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

    public ShoppingCartShippingAndTaxesComponent selectCountryByName(String countryName) {
        new Select(driver.findElement(By.xpath("//select[@id = 'input-country']"))).selectByVisibleText(countryName);
        return this;
    }

    public ShoppingCartShippingAndTaxesComponent selectRegionStateByName(String regionStateName) {
        new Select(driver.findElement(By.xpath("//select[@id = 'input-zone']"))).selectByVisibleText(regionStateName);
        return this;
    }

    public ShoppingCartShippingAndTaxesComponent inputPostCode(String postCode) {
        driver.findElement(By.xpath("//input[@name = 'postcode']")).clear();
        driver.findElement(By.xpath("//input[@name = 'postcode']")).sendKeys(postCode);
        return this;
    }

    public SelectShippingMethodPage switchToSelectShippingMethodPage() {
        String shoppingCartWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@id = 'button-quote']")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new SelectShippingMethodPage(driver);
    }

    public ShoppingCartPage goToShoppingCartFromShippingAndTaxes(){
        driver.navigate().refresh();
        return new ShoppingCartPage(driver);
    }
}
