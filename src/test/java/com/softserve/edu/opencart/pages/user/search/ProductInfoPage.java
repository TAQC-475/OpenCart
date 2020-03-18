package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.ProductOptionsSet;
import com.softserve.edu.opencart.pages.user.common.AddProductAlertPage;
import com.softserve.edu.opencart.pages.user.common.ProductInfoOptionsComponent;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

public class ProductInfoPage extends BreadCrumbPart {

	private WaitUtils alertPageWait;

	private WebElement productName;
	private WebElement productPrice;
	private WebElement productQuantity;
	private WebElement addToCartButton;
	private ProductInfoOptionsComponent productInfoOptions;

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
		alertPageWait = new WaitUtils(driver, 10);
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

	public ProductInfoOptionsComponent getProductInfoOptions() {
		if (productInfoOptions == null) {
			return new ProductInfoOptionsComponent(driver);
		}
		return productInfoOptions;
	}

	// Functional
	public void clickAddToCartButton(){
		getAddToCartButton().click();
		alertPageWait.waitForAlertVisibility();
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
	public void setProductOptions(ProductOptionsSet optionsSet){
		getProductInfoOptions().setProductOptionsFull(optionsSet);
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

	public AddProductAlertPage addProductWithOptionsDefaultQuantity(ProductOptionsSet optionsSet){
		setProductOptions(optionsSet);
		clickAddToCartButton();
		return new AddProductAlertPage(driver);
	}

	public AddProductAlertPage addProductWithOptionsSetQuantity(ProductOptionsSet optionsSet, String quantity){
		setProductOptions(optionsSet);
		inputProductQuantity(quantity);
		clickAddToCartButton();
		return new AddProductAlertPage(driver);
	}

}
