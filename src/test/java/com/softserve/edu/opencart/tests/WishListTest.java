package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListMessagePage;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WishListTest extends EpizyUserTestRunner {


    @DataProvider(name = "data")
  private Object[] data(){
    List<Product> products = new ArrayList<>();
      products.add(ProductRepository.getIPodClassic());
      products.add(ProductRepository.getMacBook());
      products.add(ProductRepository.getIPhone());
    return new Object[]{products};
  }
  @Test(dataProvider = "data")
  public void removeFromWishListTest(List<Product> products) {

//    List<Product> products = new ArrayList<>();
//    products.add(ProductRepository.getIPodClassic());
//    products.add(ProductRepository.getMacBook());
//    products.add(ProductRepository.getIPhone());

   String actual =
    loadApplication().gotoLoginPage()
        .successfulLogin(UserRepository.get().getMrAndersonUser())
        .searchAndAddProductsToWishList(products)
//        .successfulSearch(ProductRepository.getMacBook())
//        .AddToWishButtonByName(ProductRepository.getMacBook())
//        .successfulSearch(ProductRepository.getIPodClassic())
//        .AddToWishButtonByName(ProductRepository.getIPodClassic())
//        .successfulSearch(ProductRepository.getIPhone())
//        .AddToWishButtonByName(ProductRepository.getIPhone())
        .gotoWishListPage()
//           .removeAllProducts();
//        .removeAllProductFromWishList()
        .deleteProductFromWishList(ProductRepository.getIPodClassic()).getRemoveMessageText();

    Assert.assertTrue(actual.contains(WishListMessagePage.PRODUCT_REMOVED));
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
