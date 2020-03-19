package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UNContentBaseComponent {
    protected WebDriver driver;
    protected WebElement messageControls;
    protected EmailBoxName emailBoxName;

    public UNContentBaseComponent(WebDriver driver){
        this.driver = driver;

    }
    private void initElements(){
        messageControls = driver.findElement(By.cssSelector("div.controls"));
    }
}
