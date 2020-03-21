package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListEmptyPage;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListMessagePage;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListPage;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WishListTest extends EpizyUserTestRunner {
//  @BeforeClass
//  private void logIn(){
//    loadApplication()
//        .gotoLoginPage()
//        .successfulLogin(UserRepository.get().getMrAndersonUser());
//  }

  @DataProvider(name = "data")
  private Object[] data() {
    List<Product> products = new ArrayList<>();
    products.add(ProductRepository.getIPodClassic());
    products.add(ProductRepository.getMacBook());
    products.add(ProductRepository.getIPhone());
    return new Object[]{products};
  }

  @Test(priority = 1)
  public void removeFromWishListTest() {

//    List<Product> products = new ArrayList<>();
//    products.add(ProductRepository.getIPodClassic());
//    products.add(ProductRepository.getMacBook());
//    products.add(ProductRepository.getIPhone());

    String actual =
        loadApplication()
            .gotoLoginPage()
            .successfulLogin(UserRepository.get().getMrAndersonUser())
        .successfulSearch(ProductRepository.getIPodClassic())
        .AddToWishButtonByName(ProductRepository.getIPodClassic())
//        .successfulSearch(ProductRepository.getIPhone())
//        .AddToWishButtonByName(ProductRepository.getIPhone())
            .gotoWishListPage()
//           .removeAllProducts();
//        .removeAllProductFromWishList()
            .deleteProductFromWishList(ProductRepository.getIPodClassic()).getRemoveMessageText();


    Assert.assertTrue(actual.contains(WishListMessagePage.PRODUCT_REMOVED));
  }

  @Test(priority = 2)
  public void addToCartFromWishListTest() {
    String actual = loadApplication()
//          .gotoLoginPage()
//          .successfulLogin(UserRepository.get().getMrAndersonUser())
        .gotoHomePage()
        .addProductToWishList(ProductRepository.getMacBook())
        .gotoWishListPage()
        .addProductToCart(ProductRepository.getMacBook())
        .getAddToCartMessageText();

    //check message
    Assert.assertTrue(actual.contains
        (String.format(WishListMessagePage.PRODUCT_ADDED_TO_CART,
            ProductRepository.getMacBook().getName())));

  }

  //
  @Test(priority = 3, dataProvider = "data")
  public void emptyWishListTest(List<Product> products) {
    String actual = loadApplication()
        .searchAndAddProductsToWishList(products)
        .gotoWishListPage()
        .removeAllProductFromWishList()
        .getLabelText();

    Assert.assertTrue(actual.contains(WishListEmptyPage.EMPTY_WISH_LIST_MESSAGE));

  }
@Test(priority = 4, dataProvider = "data")
public void numberEqualityTest(List<Product> products) {
    int actual = loadApplication()
        .searchAndAddProductsToWishList(products)
        .gotoWishListPage()
        .getAmountComponentsInWishList();

    Assert.assertEquals(actual,products.size());

}


}
