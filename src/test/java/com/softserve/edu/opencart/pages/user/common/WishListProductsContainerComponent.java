package com.softserve.edu.opencart.pages.user.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.softserve.edu.opencart.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListProductsContainerComponent {
  private final String PRODUCT_COMPONENT_XPATH ="//div[@class='table-responsive']//tbody//tr";

  protected WebDriver driver;

  private List<WishListProductComponent> wishListComponents;

  public WishListProductsContainerComponent(WebDriver webDriver) {
    this.driver = webDriver;
    initElements();
  }
  private void initElements(){
  wishListComponents = new ArrayList<>();
  for (WebElement current: driver.findElements(By.xpath(PRODUCT_COMPONENT_XPATH))){
    wishListComponents.add(new WishListProductComponent(current));
  }
  }

  public List<WishListProductComponent> getWishListComponents() {
    return wishListComponents;
  }

  public int getWishListComponentsCount(){
    return wishListComponents.size();
  }

  public List<String> getWishListComponentNames(){
    List<String> wishListComponentNames = new ArrayList<>();
    for (WishListProductComponent current: getWishListComponents()){
      wishListComponentNames.add(current.getNameText());
    }
    return wishListComponentNames;
  }

  protected WishListProductComponent getWishListComponentByName(String productName){
    WishListProductComponent result = null;
    for (WishListProductComponent current:getWishListComponents()){
      if (current.getNameText().toLowerCase().equals(productName.toLowerCase())){
        result = current;
        break;
      }
    }
    if (result == null){
      throw new RuntimeException("ProductName: " + productName + " not Found.");
    }
    return result;
  }

  public String getWishListComponentByNameText(String productName){
    return getWishListComponentByName(productName).getNameText();
  }

  public BigDecimal getWishListComponentPriceByName(String productName){
    return getWishListComponentByName(productName).getPriceText();
  }

  public String getWishListComponentModelByName(String productName){
    return getWishListComponentByName(productName).getModelText();
  }

  public void clickWishListComponentAddToCartButtonByName(String productName){
    getWishListComponentByName(productName).clickAddToCartButton();
  }

  public void clickWishListComponentRemoveButtonByName(String productName){
    getWishListComponentByName(productName).clickRemoveFromWIshListButton();
  }

  public void clickWishListComponentNameByName(String productName){
    getWishListComponentByName(productName).clickProductName();
  }

}
