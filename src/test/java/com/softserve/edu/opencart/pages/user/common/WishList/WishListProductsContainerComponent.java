package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.data.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListProductsContainerComponent {

  private final String PRODUCT_COMPONENT_XPATH = "//div[@class='table-responsive']//tbody//tr";
//  private final String PRODUCT_COMPONENT_CSSSELECTOR ="#content > div.table-responsive > table > tbody > tr";

  protected WebDriver driver;

  private List<WishListProductComponent> wishListComponents;

  public WishListProductsContainerComponent(WebDriver webDriver) {
    this.driver = webDriver;
    initElements();
  }

  private void initElements() {
    wishListComponents = new ArrayList<>();
    for (WebElement current : driver.findElements(By.xpath(PRODUCT_COMPONENT_XPATH))) {
      wishListComponents.add(new WishListProductComponent(current));
    }
  }

  public List<WishListProductComponent> getWishListComponents() {
    return wishListComponents;
  }

  public int getWishListComponentsCount() {
    return wishListComponents.size();
  }

  public List<String> getWishListComponentNames() {
    List<String> wishListComponentNames = new ArrayList<>();
    for (WishListProductComponent current : getWishListComponents()) {
      wishListComponentNames.add(current.getNameText());
    }
    return wishListComponentNames;
  }

  protected WishListProductComponent getWishListComponentByName(Product product) {
    WishListProductComponent result = null;
//    for (WishListProductComponent current : getWishListComponents()) {
    for (WishListProductComponent current : getCorrectXPathComponents()) {
      if (current.getNameText().toLowerCase().equals(product.getName().toLowerCase())) {
        result = current;
        break;
      }
    }
    if (result == null) {
      throw new RuntimeException("ProductName: " + product.getName() + " not Found.");
    }

    return result;
  }

  private List<WishListProductComponent> getCorrectXPathComponents() {
    List<WishListProductComponent> correctList = new ArrayList<>();
    for (int i = 1; i <= getWishListComponentsCount(); i++) {
      correctList.add(new WishListProductComponent(
          driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//tr[" + i + "]")))
      );

    }
    return correctList;
  }


  public BigDecimal getWishListComponentPriceByName(Product productName) {
    return getWishListComponentByName(productName).getPriceText();
  }

  public String getWishListComponentModelByName(Product productName) {
    return getWishListComponentByName(productName).getModelText();
  }

  public void clickWishListComponentAddToCartButtonByName(Product productName) {
    getWishListComponentByName(productName).clickAddToCartButton();
  }

  public void clickWishListComponentRemoveButtonByName(Product productName) {
    for (String s : getWishListComponentNames()) {
      System.out.println(s);
    }
    for (WishListProductComponent s : getWishListComponents()) {
      System.out.println(s.getNameText());
    }
    System.out.println(getWishListComponentsCount());
    getWishListComponentByName(productName).clickRemoveFromWIshListButton();
  }

  public void clickWishListComponentNameOnName(Product productName) {
    getWishListComponentByName(productName).clickProductName();
  }

}
