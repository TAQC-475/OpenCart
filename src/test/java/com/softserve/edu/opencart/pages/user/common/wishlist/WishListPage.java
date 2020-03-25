package com.softserve.edu.opencart.pages.user.common.wishlist;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessAlertPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Wish list page.
 */
public class WishListPage extends AccountSidebarLoggedPart  {

  private WebElement continueButton;

  private WishListProductsContainerComponent wishListProductsContainerComponent;

  public WishListPage(WebDriver driver) {
    super(driver);
    initElements();
  }

  /**
   * This method initializations all elements on page.
   */
  private void initElements() {
    continueButton = driver.findElement(By.xpath("//a[text()='Continue']"));
    wishListProductsContainerComponent = new WishListProductsContainerComponent(driver);
  }

  // Page Object

  /**
   * This method gets continue button.
   */
  public WebElement getContinueButton() {
    return continueButton;
  }

  /**
   * This method clicks on continue button.
   */
  public void clickContinueButton() {
    getContinueButton().click();
  }

  /**
   * This method gets Wish List Table Container Component.
   */
  public WishListProductsContainerComponent getWishListProductsContainerComponent() {
    return wishListProductsContainerComponent;
  }

  //Currency
  /**
   * This method gets a web element where is the price and currency of products which is in the wish list
   */
  public WebElement getPrice() {
    return driver.findElement(By.xpath("//div[@class='price']"));
  }
  /**
   * This method gets a text of price and currency of products which is in the wish list
   */
  public String getPriceText() {
    return getPrice().getText();
  }

  //Functional

  /**
   * This method gets product name.
   */
  public String getProductName(Product product) {
    return wishListProductsContainerComponent.getWishListComponentByName(product).getNameText();
  }

  /**
   * This method gets product price.
   */
  public void getProductPrice(Product product) {
    wishListProductsContainerComponent.getWishListComponentPriceByName(product);
  }

  /**
   * This method gets product module.
   */
  public void getProductModel(Product product) {
    wishListProductsContainerComponent.getWishListComponentModelByName(product);
  }

  /**
   * This method gets products amount.
   */
  public int getAmountComponentsInWishList(){
    return wishListProductsContainerComponent.getWishListComponentsCount();
  }

  //BL
  /**
   * This method is changed currency and return this page with choose currency
   */
  public WishListPage chooseCurrency(Currencies currency) {
    clickCurrencyByPartialName(currency);
    return new WishListPage(driver);
  }

  /**
   * This method is written to go to MyAccountPage.
   */
  public MyAccountPage goToMyAccountPage() {
    clickContinueButton();
    return new MyAccountPage(driver);
  }

  /**
   * This method deletes product from wish list.
   */
  public WishListMessagePage deleteProductFromWishList(Product product) {
    wishListProductsContainerComponent.clickWishListComponentRemoveButtonByName(product);
    return new WishListMessagePage(driver);
  }

  /**
   * This method add list of products to wish list.
   */
  public SearchSuccessAlertPage addProductsToWishList(List<Product> products){
    for (Product product: products){
      successfulSearch(product)
          .AddToWishButtonByName(product);
    }
    return new SearchSuccessAlertPage(driver);
  }

  /**
   * This method add product to shopping cart .
   */
  public WishListMessagePage addProductToCart(Product product) {
    wishListProductsContainerComponent
        .clickWishListComponentAddToCartButtonByName(product);
    return new WishListMessagePage(driver);
  }

  /**
   * This method is written to go to WishListMessagePage.
   */
  public WishListMessagePage goToWishListMessagePage() {
    return new WishListMessagePage(driver);
  }

  /**
   * This method clears wish list.
   */
  public WishListEmptyPage removeAllProductFromWishList(){
    List<WebElement> closeButtons = driver.findElements(By.cssSelector(".text-right .fa.fa-times"));
    while (closeButtons.size() > 0) {
      closeButtons.get(0).click();
      closeButtons = driver.findElements(By.cssSelector(".text-right .fa.fa-times"));
    }
    return new WishListEmptyPage(driver);
  }


}






