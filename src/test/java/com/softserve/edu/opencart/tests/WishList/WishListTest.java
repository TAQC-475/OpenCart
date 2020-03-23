package com.softserve.edu.opencart.tests.WishList;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListEmptyPage;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListMessagePage;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListPage;
import com.softserve.edu.opencart.tests.EpizyUserTestRunner;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends EpizyUserTestRunner {

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


  @Test(priority = 1, dataProvider = "iPodClassic", dataProviderClass = WishListDataProvider.class)
  public void removeFromWishListTest(Product iPodClassic) {

    String actual = loadApplication()
            .successfulSearch(iPodClassic)
            .AddToWishButtonByName(iPodClassic)
            .gotoWishListPage()
            .deleteProductFromWishList(iPodClassic).getRemoveMessageText();

    Assert.assertTrue(actual.contains(WishListMessagePage.PRODUCT_REMOVED));
  }


  @Test(priority = 2, dataProvider = "productsList", dataProviderClass = WishListDataProvider.class)
  public void emptyWishListTest(List<Product> products) {
    String actual = loadApplication()
        .searchAndAddProductsToWishList(products)
        .gotoWishListPage()
        .removeAllProductFromWishList()
        .getLabelText();

    Assert.assertTrue(actual.contains(WishListEmptyPage.EMPTY_WISH_LIST_MESSAGE));

  }

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


  @Test(priority = 4, dataProvider = "productsList", dataProviderClass = WishListDataProvider.class)
  public void numberEqualityTest(List<Product> products) {

    int actual = loadApplication()
        .searchAndAddProductsToWishList(products)
        .gotoWishListPage()
        .getAmountComponentsInWishList();

    Assert.assertEquals(actual, products.size());

  }


}
