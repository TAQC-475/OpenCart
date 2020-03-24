package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;

public class WishListDataProvider {

  @DataProvider(name = "macBook")
  public Object[] macBook() {
    return new Object[]
        {ProductRepository.getMacBook()};
  }

  @DataProvider(name = "iPodClassic")
  public Object[] iPodClassic() {
    return new Object[]
         {ProductRepository.getIPodClassic()};
  }

  @DataProvider(name = "productsList")
  public Object[] productsList() {
    List<Product> products = new ArrayList<>();
    products.add(ProductRepository.getIPodClassic());
    products.add(ProductRepository.getMacBook());
    products.add(ProductRepository.getIPhone());
    return new Object[]{products};
  }


}
