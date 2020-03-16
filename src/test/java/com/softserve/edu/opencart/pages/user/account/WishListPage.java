package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.common.WishListProductsContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends AccountSidebarLoggedPart {
	private WebElement continueButton;

	private WishListProductsContainerComponent wishListProductsContainerComponent;

	public WishListPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		continueButton = driver.findElement(By.xpath("//a[text()='Continue']"));
		wishListProductsContainerComponent = new WishListProductsContainerComponent(driver);
	}

	public WishListProductsContainerComponent getWishListProductsContainerComponent() {
		return wishListProductsContainerComponent;
	}
	// Page Object

	// Functional

	// Business Logic

}
