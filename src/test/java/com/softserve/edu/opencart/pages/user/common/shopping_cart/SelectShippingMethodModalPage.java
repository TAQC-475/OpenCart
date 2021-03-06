package com.softserve.edu.opencart.pages.user.common.shopping_cart;

import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectShippingMethodModalPage {
    private WebElement flatShippingRate;
    private WebElement applyShippingButton;
    private WebElement cancelButton;

    protected WebDriver driver;

    public SelectShippingMethodModalPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        flatShippingRate = driver.findElement(By.xpath("//input[@value =  'flat.flat']"));
        applyShippingButton = driver.findElement(By.xpath("//input[@id =  'button-shipping']"));
        cancelButton = driver.findElement(By.xpath("//button[text() =  'Cancel']"));
    }

    public WebElement getFlatShippingRate() {
        return flatShippingRate;
    }

    public WebElement getApplyShippingButton() {
        return applyShippingButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    /**
     * clicks flat shipping rate checkbox
     *
     * @return SelectShippingMethodModalPage with selected flat shipping rate checkbox
     */
    public SelectShippingMethodModalPage selectFlatShippingRate() {
        driver.findElement(By.xpath("//input[@value =  'flat.flat']")).click();
        return this;
    }

    /**
     * handling current window, clicking apply shipping button and switching driver to shopping cart page window
     *
     * @return ShoppingCartPage
     */
    public ShoppingCartPage clickApplyShippingButton() {
        String selectShippingMethodPageWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//input[@id =  'button-shipping']")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(selectShippingMethodPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        new WaitUtils(driver, 10).waitForAlertVisibility();
        return new ShoppingCartPage(driver);
    }
}
