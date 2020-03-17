package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.common.WishListProductsContainerComponent;
import java.util.ArrayList;
import java.util.List;
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

  public WebElement getContinueButton() {
    return continueButton;
  }


  public WishListProductsContainerComponent getWishListProductsContainerComponent() {
    return wishListProductsContainerComponent;
  }

  public void getProductName(Product product) {
    wishListProductsContainerComponent.getWishListComponentByNameText(product.getName());
  }

  public void getProductPrice(Product product) {
    wishListProductsContainerComponent.getWishListComponentPriceByName(product.getName());
  }

  public void getProductModel(Product product) {
    wishListProductsContainerComponent.getWishListComponentModelByName(product.getName());
  }
  // Page Object

  // Functional

  public MyAccountPage goToMyAccountPage() {
    getContinueButton().click();
    return new MyAccountPage(driver);
  }

  public WishListPage deleteFromWishListByName(Product product) {
    wishListProductsContainerComponent.clickWishListComponentRemoveButtonByName(product.getName());
    return new WishListPage(driver);
  }

  public WishListPage addToCart(Product product) {
    wishListProductsContainerComponent
        .clickWishListComponentAddToCartButtonByName(product.getName());
    return new WishListPage(driver);
  }


}

// Business Logic


