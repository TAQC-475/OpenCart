package com.softserve.edu.opencart.tests.WishList;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListEmptyPage;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListMessagePage;
import com.softserve.edu.opencart.tests.EpizyUserTestRunner;
import com.softserve.edu.opencart.tests.WishList.WishListTest;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends EpizyUserTestRunner {


  @Test(priority = 1,dataProvider = "validUser",dataProviderClass = WishListDataProvider.class)
  public void removeFromWishListTest(User validUser) {

    String actual =
        loadApplication()
            .gotoLoginPage()
            .successfulLogin(validUser)
            .successfulSearch(ProductRepository.getIPodClassic())
            .AddToWishButtonByName(ProductRepository.getIPodClassic())
            .gotoWishListPage()
            .deleteProductFromWishList(ProductRepository.getIPodClassic()).getRemoveMessageText();

    Assert.assertTrue(actual.contains(WishListMessagePage.PRODUCT_REMOVED));
  }


  @Test(priority = 2, dataProvider = "data",dataProviderClass = WishListDataProvider.class)
  public void emptyWishListTest(List<Product> products) {
    String actual = loadApplication()
        .searchAndAddProductsToWishList(products)
        .gotoWishListPage()
        .removeAllProductFromWishList()
        .getLabelText();

    Assert.assertTrue(actual.contains(WishListEmptyPage.EMPTY_WISH_LIST_MESSAGE));

  }

  @Test(priority = 3)
  public void addToCartFromWishListTest() {
    String actual = loadApplication()

        .gotoHomePage()
        .addProductToWishList(ProductRepository.getMacBook())
        .gotoWishListPage()
        .addProductToCart(ProductRepository.getMacBook())
        .getAddToCartMessageText();

    //check message
    Assert.assertTrue(actual.contains
        (String.format(WishListMessagePage.PRODUCT_ADDED_TO_CART,
            ProductRepository.getProductName(ProductRepository.getMacBook()))));

  }

  //


  @Test(priority = 4, dataProvider = "data",dataProviderClass = WishListDataProvider.class)
  public void numberEqualityTest(List<Product> products) {
    int actual = loadApplication()
        .searchAndAddProductsToWishList(products)
        .gotoWishListPage()
        .getAmountComponentsInWishList();

    Assert.assertEquals(actual, products.size());

  }


}
