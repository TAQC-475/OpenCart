package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
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

  public String getProductName(Product product) {
     return wishListProductsContainerComponent.getWishListComponentByName(product).getNameText();
  }

  public void getProductPrice(Product product) {
    wishListProductsContainerComponent.getWishListComponentPriceByName(product);
  }

  public void getProductModel(Product product) {
    wishListProductsContainerComponent.getWishListComponentModelByName(product);
  }
  // Page Object

  // Functional

  public MyAccountPage goToMyAccountPage() {
    getContinueButton().click();
    return new MyAccountPage(driver);
  }


  public WishListPage deleteFromWishListByName(Product product) {
    wishListProductsContainerComponent.clickWishListComponentRemoveButtonByName(product);
    return new WishListPage(driver);
  }

  public WishListPage addToCart(Product product) {
    wishListProductsContainerComponent
        .clickWishListComponentAddToCartButtonByName(product);
    return new WishListPage(driver);
  }



}

// Business Logic


