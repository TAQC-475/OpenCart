package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends AccountSidebarGuestPart {

	private WebElement email;
	private WebElement continueButton;
	private WebElement backButton;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		email = driver.findElement(By.id("input-email"));
		continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
		backButton = driver.findElement(By.xpath("//a[text()='Back']"));
	}

	// Page Object

	// Functional

	public WebElement getEmail() {
		return email;
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

	public void enterEmail(String email){
		clickEmailField();
		clearEmailField();
		setEmail(email);
	}

	// Business Logic

	public LoginPage requestResetEmail(IUser user){
		enterEmail(user.getEmail());
		clickContinue();
		return new LoginPage(driver);
	}
}
