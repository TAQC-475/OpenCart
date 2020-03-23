package com.softserve.edu.opencart.tests.WishList;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;

public class WishListDataProvider {

  @DataProvider(name = "validUser")
  public Object[] validUser() {
    return new Object[]{UserRepository.get().getMrAndersonUser()};
  }

  @DataProvider(name = "data")
  public Object[] data() {
    List<Product> products = new ArrayList<>();
    products.add(ProductRepository.getIPodClassic());
    products.add(ProductRepository.getMacBook());
    products.add(ProductRepository.getIPhone());
    return new Object[]{products};
  }


}
