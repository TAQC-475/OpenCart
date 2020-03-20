package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.UserRepository;
import java.util.List;
import org.testng.annotations.Test;

public class WishListTest extends EpizyUserTestRunner {


  //  @DataProvider(name = "data")
//  private Object[][] data(){
//    Product[] products = new Product[2];
//    products[0] = ProductRepository.getIPodClassic();
//    products[0] = ProductRepository.getMacBook();
//    products[0] = ProductRepository.getIPhone();
//    return new Object[][]{products};
//  }
  @Test
  public void removeFromWishListTest() {

//   String actual =
    loadApplication().gotoLoginPage()
        .successfulLogin(UserRepository.get().getMrAndersonUser())
//        .searchAndAddProductsToWishList(products)
//        .successfulSearch(ProductRepository.getMacBook())
//        .AddToWishButtonByName(ProductRepository.getMacBook())
//        .successfulSearch(ProductRepository.getIPodClassic())
//        .AddToWishButtonByName(ProductRepository.getIPodClassic())
//        .successfulSearch(ProductRepository.getIPhone())
//        .AddToWishButtonByName(ProductRepository.getIPhone())
        .gotoWishListPage()
//           .removeAllProducts();
        .removeAllProductFromWishList();
//        .deleteProductFromWishList(ProductRepository.getIPodClassic()).getRemoveMessageText();

//    Assert.assertTrue(actual.contains(WishLIstMessagePage.PRODUCT_REMOVED));
  }

//    @Test
//    public void addToCartFromWishListTest(){
//
//    }
//
//  @Test
//  public void emptyWishListTest(){
//
//  }
//
//  @Test
//  public void addToCartFromWishList(){
//
//  }


}
