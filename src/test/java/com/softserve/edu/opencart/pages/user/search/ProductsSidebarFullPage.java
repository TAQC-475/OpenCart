package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.WebDriver;

public class ProductsSidebarFullPage extends ProductsSidebarPart {

	private ProductsDisplayComponent productsDisplayComponent;

	public ProductsSidebarFullPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		productsDisplayComponent = new ProductsDisplayComponent(driver);



	}

	// Page Object

	public ProductsDisplayComponent getProductsDisplayComponent() {
		return productsDisplayComponent;
	}

	// Functional

	// Business Logic
}
