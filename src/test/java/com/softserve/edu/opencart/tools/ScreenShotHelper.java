package com.softserve.edu.opencart.tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotHelper {
    private WebDriver driver;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";

    public ScreenShotHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenShot() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./img/" + currentTime + "_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "./img/" + currentTime + "_screenshot";
    }

    public void takePageSource(String fileName) {
        String pageSource = driver.getPageSource();
        Path path = Paths.get(fileName + ".txt");
        byte[] strToBytes = pageSource.getBytes();
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keepPageSourceStatus(){
        takePageSource(takeScreenShot());
    }
}
