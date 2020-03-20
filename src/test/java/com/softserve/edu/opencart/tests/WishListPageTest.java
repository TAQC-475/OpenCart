package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.WishList.WishLIstMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListPageTest extends EpizyUserTestRunner {

  @Test
  public void removeFromWishListTest(){

   String actual =  loadApplication().gotoLoginPage()
        .successfulLogin(UserRepository.get().getMrAndersonUser())
        .successfulSearch(ProductRepository.getMacBook())
        .AddToWishButtonByName(ProductRepository.getMacBook())
        .successfulSearch(ProductRepository.getIPodClassic())
        .AddToWishButtonByName(ProductRepository.getIPodClassic())
        .successfulSearch(ProductRepository.getIPhone())
        .AddToWishButtonByName(ProductRepository.getIPhone())
        .gotoWishListPage()
        .deleteProductFromWishList(ProductRepository.getIPodClassic()).getRemoveMessageText();


    Assert.assertTrue(actual.contains(WishLIstMessagePage.PRODUCT_REMOVED));
//        .goToWIshLIstPageByAlert()
//        .getWishListProductsContainerComponent()
//        .clickWishListComponentRemoveButtonByName(ProductRepository.getIPodClassic().getName());



  }

}
