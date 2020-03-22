package com.softserve.edu.opencart.tests;


import com.softserve.edu.opencart.pages.user.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class EpizyUserTestRunner {
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    private Map<Long, WebDriver> drivers;

    protected WebDriver getDriver() {
        WebDriver currentWebDriver = drivers.get(Thread.currentThread().getId());
        if (currentWebDriver == null) {
            currentWebDriver = new ChromeDriver();
            //driver.manage().window().maximize();
            currentWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            drivers.put(Thread.currentThread().getId(), currentWebDriver);
        }
        return currentWebDriver;
    }


    @BeforeSuite
    public void beforeSuite() {
        drivers = new HashMap<>();
    }

    @Parameters({"url", "serverUrlLogout"})
    @BeforeClass
    public void     beforeClass(ITestContext context, String serverUrl, String serverUrlLogout) {
        //System.setProperty("webdriver.chrome.driver",
        //		EpizyUserTestRunner.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        // TODO Check Exist ChromeDriver
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
            System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
            if (entry.getKey().toLowerCase().equals("url")) {
                serverUrl = entry.getValue();
                //	break;
            }
            if (entry.getKey().toLowerCase().equals("urllogout")) {
                serverUrlLogout = entry.getValue();
            }
        }
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //if (driver != null) {
        //	driver.quit();
        //}
        for (Map.Entry<Long, WebDriver> currentWebDriver : drivers.entrySet()) {
            if (currentWebDriver.getValue() != null) {
                currentWebDriver.getValue().quit();
            }
        }
    }

    // @Before
    @Parameters({"url"})
    @BeforeMethod
    public void beforeMethod(String serverUrl) {
        getDriver().get(serverUrl);
    }

    // @After
    @Parameters({"serverUrlLogout"})
    @AfterMethod
    public void afterMethod(ITestResult result, String serverUrlLogout) throws IOException {
        // TODO Logout
        if (!result.isSuccess()) {
            System.out.println("***Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to
            takePageSource(takeScreenShot());
            // previous state, logout, etc.
        }
        getDriver().get(serverUrlLogout);
        // driver.get(SERVER_URL);
    }

    public HomePage loadApplication() {
        //return new HomePage(driver);
        return new HomePage(getDriver());
    }

    public void presentationSleep() {
        presentationSleep(1);
    }

    public void presentationSleep(Integer seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String takeScreenShot() throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./img/" + currentTime + "_screenshot.png"));
        // log.info("Screenshot was taken");
        return "./img/" + currentTime + "_screenshot";
    }

    private void takePageSource(String fileName) {
        //String pageSource = driver.getPageSource();
        String pageSource = getDriver().getPageSource();
        Path path = Paths.get(fileName + ".txt");
        byte[] strToBytes = pageSource.getBytes();
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
