package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends AccountSidebarLoggedPart {

	private WebElement password;
	private WebElement confirmPassword;
	private WebElement continueButton;
	private WebElement backButton;

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		password = driver.findElement(By.id("input-password"));
		confirmPassword = driver.findElement(By.id("input-confirm"));
		continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
		backButton = driver.findElement(By.xpath("//a[text()='Back']"));
	}

	// Page Object

	public WebElement getPassword() { return password; }

	public WebElement getConfirmPassword() { return confirmPassword; }

	public WebElement getContinueButton() { return continueButton; }

	public WebElement getBackButton() { return backButton; }

	public void clickPassword(){ getPassword().click();}

	public void clearPassword(){ getPassword().clear();}

	public void setPassword(String password){ getPassword().sendKeys(password);}

	public void clickConfirmPassword(){ getConfirmPassword().click();}

	public void clearConfirmPassword(){getConfirmPassword().clear();}

	public void setConfirmPassword(String confirmPassword){ getConfirmPassword().sendKeys(confirmPassword);}

	public void clickContinue(){ getContinueButton().click();}
	// Functional

	// Business Logic

	public void enterPassword(String password){
		clickPassword();
		clearPassword();
		setPassword(password);
	}

	public void enterConfirmPassword(String confirmPassword){
		clickConfirmPassword();
		clearConfirmPassword();
		setConfirmPassword(confirmPassword);
	}

	public SuccessfulUpdatePasswordLoginPage resetPassword(IUser user){
		enterPassword(user.getPassword());
		enterConfirmPassword(user.getPassword());
		clickContinue();
		return new SuccessfulUpdatePasswordLoginPage(driver);
	}

}
