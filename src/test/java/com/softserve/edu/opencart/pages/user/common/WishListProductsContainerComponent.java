package com.softserve.edu.opencart.pages.user.common;

import java.util.List;
import org.openqa.selenium.WebDriver;

public class WishListProductsContainerComponent {
  private final String PRODUCT_COMPONENT_XPATH ="//div[@class='table-responsive']//tbody//tr";

  protected WebDriver webDriver;

  private List<WishListProductComponent> productComponents;

  public WishListProductsContainerComponent(WebDriver webDriver) {
    this.webDriver = webDriver;
    initElements();
  }
  private void initElements(){

  }
}
