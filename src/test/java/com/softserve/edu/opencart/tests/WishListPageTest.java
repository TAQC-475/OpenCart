package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.WishListPage;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.pages.user.common.WishListProductsContainerComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListPageTest extends EpizyUserTestRunner {
  @Test
  public void removeFromWishListTest(){
  loadApplication().gotoLoginPage()
      .successfulLogin(UserRepository.get()
      .getDefault())
      .successfulSearch(ProductRepository.getMacBook())
      .AddToWishButtonByName(ProductRepository.getMacBook())
      .gotoWishListPage()
      .getWishListProductsContainerComponent()
      .clickWishListComponentRemoveButtonByName(ProductRepository.getMacBook().getName());






  }

}
