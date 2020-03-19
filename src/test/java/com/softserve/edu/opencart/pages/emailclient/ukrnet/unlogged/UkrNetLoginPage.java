package com.softserve.edu.opencart.pages.emailclient.ukrnet.unlogged;

import com.softserve.edu.opencart.data.EmailBoxName;
import com.softserve.edu.opencart.data.EmailUser;
import com.softserve.edu.opencart.pages.emailclient.ukrnet.BaseParentEmailPart;
import com.softserve.edu.opencart.pages.emailclient.metaua.email.EmailsListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UkrNetLoginPage extends BaseParentEmailPart {
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement borrowedComputer;
    private WebElement forgotPassword;
    private WebElement newEmail;

    public UkrNetLoginPage(WebDriver driver){
        super(driver);
        //this.driver = driver;
        initElements();
    }

    private void initElements(){
        loginField = driver.findElement(By.id("id-l"));
        passwordField = driver.findElement(By.id("id-p"));
        loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        borrowedComputer = driver.findElement(By.id("id-c"));
        forgotPassword = driver.findElement(By.xpath("//a[contains(@href, '/recovery?')]"));
        newEmail = driver.findElement(By.xpath("//a[contains(@href, '/registration?')]"));

    }
    public WebDriver getDriver() { return driver; }

    public WebElement getLoginField() { return loginField; }

    public WebElement getPasswordField() { return passwordField; }

    public WebElement getLoginButton() { return loginButton; }

    public WebElement getBorrowedComputer() { return borrowedComputer; }

    public WebElement getForgotPassword() { return forgotPassword; }

    public WebElement getNewEmail() { return newEmail; }

    private void clickLoginField(){ getLoginField().click();}

    private void clearLoginField(){getLoginField().clear();}

    private void setLogin(String login){getLoginField().sendKeys(login);}

    private void clickPasswordField(){ getPasswordField().click();}

    private void clearPasswordField(){getPasswordField().clear();}

    private void setPassword(String password){getPasswordField().sendKeys(password);}

    private void clickLoginButton(){getLoginButton().click();}

    //business logic

    private void enterLogin(String login){
        clickLoginField();
        clearLoginField();
        setLogin(login);
    }

    private void enterPassword(String password){
        clickPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    public EmailsListPage login(EmailUser emailUser){
        enterLogin(emailUser.getEmail());
        enterPassword(emailUser.getPassword());
        clickLoginButton();
        return new EmailsListPage(driver, EmailBoxName.INBOX);

    }
}
