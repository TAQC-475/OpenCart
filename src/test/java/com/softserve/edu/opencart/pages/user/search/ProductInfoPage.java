package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.pages.user.common.AddProductAlertPage;
//import com.softserve.edu.opencart.pages.user.common.ProductInfoOptionsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

public class ProductInfoPage extends BreadCrumbPart {

	private WebElement productName;
	private WebElement productPrice;
	private WebElement productQuantity;
	private WebElement addToCartButton;
//	private ProductInfoOptionsComponent productInfoOptions;

	public ProductInfoPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		productName = driver.findElement(By.cssSelector(".col-sm-4 h1"));
		productPrice = driver.findElement(By.cssSelector(".col-sm-4 h2"));
		productQuantity = driver.findElement(By.cssSelector("#input-quantity"));
		addToCartButton = driver.findElement(By.cssSelector("#button-cart"));
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

	public WebElement getProductQuantity() {
		return productQuantity;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

//	public ProductInfoOptionsComponent getProductInfoOptions() {
//		if (productInfoOptions == null) {
//			return new ProductInfoOptionsComponent(driver);
//		}
//		return productInfoOptions;
//	}

	// Functional
	public void clickAddToCartButton(){
		getAddToCartButton().click();
	}

	public void clearProductQuantity(){
		getProductQuantity().clear();
	}

	public void clickProductQuantity(){
		getProductQuantity().click();
	}

	public void setProductQuantity(String quantity){
		getProductQuantity().sendKeys(quantity);
	}

	public void inputProductQuantity(String quantity){
		clickProductQuantity();
		clearProductQuantity();
		setProductQuantity(quantity);
	}

	// Business Logic
	public AddProductAlertPage addProductDefaultQuantity(){
		clickAddToCartButton();
		return new AddProductAlertPage(driver);
	}

	public AddProductAlertPage addProductSetQuantity(String quantity){
		inputProductQuantity(quantity);
		clickAddToCartButton();
		return new AddProductAlertPage(driver);
	}

}
