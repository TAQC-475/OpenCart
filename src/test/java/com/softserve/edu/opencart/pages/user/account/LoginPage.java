package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public class LoginPage extends AccountSidebarGuestPart {

	private WebElement email;
	private WebElement password;
	private WebElement loginButton;
	private WebElement forgottenPassword;

	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		email = driver.findElement(By.name("email"));
		password = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
		forgottenPassword = driver.findElement(By.xpath("//form//a[contains(@href, 'account/forgotten')]"));
	}

	// Page Object

	// Functional
	
	// email

	public WebElement getForgottenPassword() {
		return forgottenPassword;
	}

	public WebElement getEmail() {
		return email;
	}

    public String getEmailText() {
        return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmailField() {
		getEmail().clear();
	}

	public void clickEmailField() {
		getEmail().click();
	}

	public void setEmail(String email) {
		getEmail().sendKeys(email);
	}

	// password
	public WebElement getPassword() {
		return password;
	}

    public String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

	public void clearPasswordField() {
		getPassword().clear();
	}

	public void clickPasswordField() {
		getPassword().click();
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	// loginButton
	public WebElement getLoginButton() {
		return loginButton;
	}

    public String getLoginButtonText() {
        return getLoginButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

	public void clickLoginButton() {
		getLoginButton().click();
	}

	public void clickForgottenPassword(){
		getForgottenPassword().click();
	}

	// Functional

	private void enterEmail(String email) {
		clickEmailField();
		clearEmailField();
		setEmail(email);
	}

	private void enterPassword(String password) {
		clickPasswordField();
		clearPasswordField();
		setPassword(password);
	}

	public void fillLogin(IUser user) {
		enterEmail(user.getEmail());
		enterPassword(user.getPassword());
		clickLoginButton();
	}

	// Business Logic

	public MyAccountPage successfulLogin(IUser validUser){
		fillLogin(validUser);
		return new MyAccountPage(driver);
	}

	public UnsuccessfulLoginPage unsuccessfulLogin(IUser invalidUser){
		fillLogin(invalidUser);
		return new UnsuccessfulLoginPage(driver);
	}

	public ForgotPasswordPage gotoForgotPasswordPage(){
		clickForgottenPassword();
		return new ForgotPasswordPage(driver);
	}
}
