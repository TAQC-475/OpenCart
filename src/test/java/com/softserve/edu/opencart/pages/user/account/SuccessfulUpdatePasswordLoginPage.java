package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulUpdatePasswordLoginPage extends LoginPage{
    public static final String EXPECTED_UPDATE_MESSAGE = "Success: Your password has been successfully updated.";

    private WebElement updatePasswordMessage;

    public SuccessfulUpdatePasswordLoginPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){

        updatePasswordMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
    }

    public WebElement getUpdatePasswordMessage() {
        return updatePasswordMessage;
    }

    public String getMessageText(){
        return getUpdatePasswordMessage().getText();
    }
}
