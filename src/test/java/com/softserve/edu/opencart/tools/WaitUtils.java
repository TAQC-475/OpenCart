package com.softserve.edu.opencart.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtils {
    private final String ALERT_MESSAGE_CSS = ".alert.alert-success";
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitUtils(WebDriver driver, int seconds){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, seconds);
    }

    public void waitForAlertVisibility(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ALERT_MESSAGE_CSS)));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            }
        };
        return wait.until(jQueryLoad);
    }
}
