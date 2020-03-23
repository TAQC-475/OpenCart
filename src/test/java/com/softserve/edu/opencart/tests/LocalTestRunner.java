package com.softserve.edu.opencart.tests;


import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tools.ScreenShotHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunner {
    private String url = "http://192.168.132.130/opencart/upload/";
    private String serverUrlLogout = "http://localhost/opencart/index.php?route=account/logout";
    private final Long ONE_SECOND_DELAY = 1000L;
    private Map<Long, WebDriver> drivers;
    protected SoftAssert softAssert;

    protected WebDriver getDriver() {
        WebDriver currentWebDriver = drivers.get(Thread.currentThread().getId());
        if (currentWebDriver == null) {
            currentWebDriver = new ChromeDriver();
            currentWebDriver.manage().window().maximize();
            currentWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            drivers.put(Thread.currentThread().getId(), currentWebDriver);
        }
        return currentWebDriver;
    }

    @BeforeSuite
    public void beforeSuite() {
        drivers = new HashMap<>();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
            if (entry.getKey().toLowerCase().equals("url")) {
                url = entry.getValue();
            }
            if (entry.getKey().toLowerCase().equals("serverurllogout")) {
                serverUrlLogout = entry.getValue();
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        for (Map.Entry<Long, WebDriver> currentWebDriver : drivers.entrySet()) {
            if (currentWebDriver.getValue() != null) {
                currentWebDriver.getValue().quit();
            }
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
        getDriver().get(url);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (!result.isSuccess()) {
            System.out.println("***Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to
            new ScreenShotHelper(getDriver()).keepPageSourceStatus();
            // previous state, logout, etc.
        }
        getDriver().get(serverUrlLogout);
    }

    public HomePage loadApplication() {
        return new HomePage(getDriver());
    }

    public void presentationSleep() {
        presentationSleep(1);
    }

    public void presentationSleep(Integer seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
