package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

public class ProductInfoPage extends BreadCrumbPart {

	private WebElement productName;
	private WebElement productPrice;

	public ProductInfoPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		productName = driver.findElement(By.cssSelector(".col-sm-4 h1"));
		productPrice = driver.findElement(By.cssSelector(".col-sm-4 h2"));
	}

	// Page Object

	public WebElement getProductName() {
		return productName;
	}

	public String getProductNameText() {
		return getProductName().getText();
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public String getProductPriceText() {
		return getProductPrice().getText();
	}
	
	// Functional

	// Business Logic

}
