package com.softserve.edu.opencart.pages.user.common.ShoppingCart;

import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectShippingMethodPage {
    private WebElement flatShippingRate;
    private WebElement applyShippingButton;
    private WebElement cancelButton;

    protected WebDriver driver;

    public void initElements(){
        flatShippingRate = driver.findElement(By.xpath("//input[@value =  'flat.flat']"));
        applyShippingButton = driver.findElement(By.xpath("//input[@id =  'button-shipping']"));
        cancelButton = driver.findElement(By.xpath("//button[text() =  'Cancel']"));
    }

    public SelectShippingMethodPage(WebDriver driver) {
        this.driver = driver;
        initElements();
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

    public SelectShippingMethodPage selectFlatShippingRate(){
        driver.findElement(By.xpath("//input[@value =  'flat.flat']")).click();
        return this;
    }

    public ShoppingCartPage clickApplyShippingButton(){
        String selectShippingMethodPageWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//input[@id =  'button-shipping']")).click();
        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(selectShippingMethodPageWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
        new WaitUtils(driver, 10).waitForAlertVisibility();
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartShippingAndTaxesComponent clickCancelButton(){
        String selectShippingMethodPageWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[text() =  'Cancel']")).click();
        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(selectShippingMethodPageWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
        return new ShoppingCartShippingAndTaxesComponent(driver);
    }
}
