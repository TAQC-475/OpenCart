package com.softserve.edu.opencart.tests.wishlist;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.data_provider_repository.WishListDataProvider;
import com.softserve.edu.opencart.pages.user.common.wishlist.WishListEmptyPage;
import com.softserve.edu.opencart.pages.user.common.wishlist.WishListMessagePage;
import com.softserve.edu.opencart.pages.user.common.wishlist.WishListPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends LocalTestRunner {

  @BeforeMethod
  public void logIn() {
    loadApplication()
        .gotoLoginPage()
        .successfulLogin(UserRepository.get().getMrAndersonUser())
        .gotoHomePage();
  }

  @AfterMethod
  public void cleanWishList() {
    int i = new WishListPage(getDriver()).getWishListComponentNumber();
    if (i > 0) {
      new WishListPage(getDriver()).removeAllProductFromWishList();
    }
  }

  /**
   * This method check if button 'Remove from wish list' works.
   */
  @Test(priority = 1, dataProvider = "iPodClassic", dataProviderClass = WishListDataProvider.class)
  public void removeFromWishListTest(Product iPodClassic) {

    String actual = loadApplication()
            .successfulSearch(iPodClassic)
            .AddToWishButtonByName(iPodClassic)
            .gotoWishListPage()
            .deleteProductFromWishList(iPodClassic).getRemoveMessageText();

    Assert.assertTrue(actual.contains(WishListMessagePage.PRODUCT_REMOVED));
  }

  /**
   * This method check if Wish List is empty after removed all products.
   */
  @Test(priority = 2, dataProvider = "productsList", dataProviderClass = WishListDataProvider.class)
  public void emptyWishListTest(List<Product> products) {
    String actual = loadApplication()
        .addProductsToWishList(products)
        .gotoWishListPage()
        .removeAllProductFromWishList()
        .getLabelText();

    Assert.assertTrue(actual.contains(WishListEmptyPage.EMPTY_WISH_LIST_MESSAGE));

  }

  /**
   * This method check if button 'Add to shopping cart' works.
   */
  @Test(priority = 3, dataProvider = "macBook", dataProviderClass = WishListDataProvider.class)
  public void addToCartFromWishListTest(Product macBook) {

    String actual = loadApplication()
        .gotoHomePage()
        .addProductToWishList(macBook)
        .gotoWishListPage()
        .addProductToCart(macBook)
        .getAddToCartMessageText();

    //check message
    Assert.assertTrue(actual.contains
        (String.format(WishListMessagePage.PRODUCT_ADDED_TO_CART, macBook.getName())));

  }

  /**
   * This method verify whether the number of added elements
   * are the same to the number of items that are displayed on
   * the page.
   */
  @Test(priority = 4, dataProvider = "productsList", dataProviderClass = WishListDataProvider.class)
  public void numberEqualityTest(List<Product> products) {

    int actual = loadApplication()
        .addProductsToWishList(products)
        .gotoWishListPage()
        .getAmountComponentsInWishList();

    Assert.assertEquals(actual, products.size());

  }


}
