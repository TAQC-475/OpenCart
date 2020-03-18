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

//				DESKTOPS("Desktops"),
//				PC("PC"),
//				MAC("Mac"),
//
//				LAPTOPS_AND_NOTEBOOKS("Laptops & Notebooks"),
//				MACS("Macs"),
//				WINDOWS("Windows"),
//
//				COMPONENTS("Components"),
//				MICE_AND_TRACKBALLS("Mice and Trackballs"),
//				MONITORS("Monitors"),
//				PRINTERS("Printers"),
//				SCANNERS("Scanners"),
//				WEB_CAMERAS("Web Cameras"),
//
//				TABLETS("Tablets"),
//				SOFTWARE("Software"),
//				PHONES_AND_PDAS("Phones & PDAs"),
//				CAMERAS("Cameras"),
//				MP3_PLAYERS("MP3 Players");

	}

	// Page Object

	public ProductsDisplayComponent getProductsDisplayComponent() {
		return productsDisplayComponent;
	}

	// Functional

	// Business Logic
}
