package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessAlertPage;
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

  public String getProductName(Product product) {
    return wishListProductsContainerComponent.getWishListComponentByName(product).getNameText();
  }

  public void getProductPrice(Product product) {
    wishListProductsContainerComponent.getWishListComponentPriceByName(product);
  }

  public void getProductModel(Product product) {
    wishListProductsContainerComponent.getWishListComponentModelByName(product);
  }

  public int getAmountComponentsInWishList(){
    return wishListProductsContainerComponent.getWishListComponentsCount();
  }
  // Page Object

  // Functional

  public MyAccountPage goToMyAccountPage() {
    getContinueButton().click();
    return new MyAccountPage(driver);
  }


  public WishListMessagePage deleteProductFromWishList(Product product) {
    wishListProductsContainerComponent.clickWishListComponentRemoveButtonByName(product);
    return new WishListMessagePage(driver);
  }

  public SearchSuccessAlertPage searchAndAddProductsToWishList(List<Product> products){
    for (Product product: products){
      successfulSearch(product)
          .AddToWishButtonByName(product);
    }
    return new SearchSuccessAlertPage(driver);
  }



  public WishListMessagePage addProductToCart(Product product) {
    wishListProductsContainerComponent
        .clickWishListComponentAddToCartButtonByName(product);
    return new WishListMessagePage(driver);
  }

  public WishListMessagePage goToWishListMessagePage() {
    return new WishListMessagePage(driver);
  }

  public WishListEmptyPage removeAllProductFromWishList(){
    List<WebElement> closeButtons = driver.findElements(By.cssSelector(".text-right .fa.fa-times"));
    while (closeButtons.size() > 0) {
      closeButtons.get(0).click();
      closeButtons = driver.findElements(By.cssSelector(".text-right .fa.fa-times"));
    }
    return new WishListEmptyPage(driver);
  }


}



// Business Logic


