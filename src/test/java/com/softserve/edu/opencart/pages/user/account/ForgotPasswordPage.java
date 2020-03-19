package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.EmailUser;
import com.softserve.edu.opencart.pages.emailclient.metaua.unlogged.EmailLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends AccountSidebarGuestPart {

	private WebElement emailField;
	private WebElement continueButton;
	private WebElement backButton;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		emailField = driver.findElement(By.id("input-email"));
		continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
		backButton = driver.findElement(By.xpath("//a[text()='Back']"));
	}

	// Page Object

	// Functional

	public WebElement getEmail() {
		return emailField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public void setEmail(String email){
		getEmail().sendKeys(email);
	}

	public void clickEmailField(){
		getEmail().click();
	}

	public void clearEmailField(){ getEmail().clear(); }

	public void clickContinue(){ //private for atomic methods?
		getContinueButton().click();
	}

	public void getEmailLoginPage(String emailLoginUrl){
		driver.get(emailLoginUrl);
	}

	public void enterEmail(String email){
		clickEmailField();
		clearEmailField();
		setEmail(email);
	}


	public EmailLoginPage requestResetEmail(EmailUser user){
		enterEmail(user.getEmail());
		clickContinue();
		getEmailLoginPage(user.getEmailServiceUrl());
		return new EmailLoginPage(driver);
	}
}
