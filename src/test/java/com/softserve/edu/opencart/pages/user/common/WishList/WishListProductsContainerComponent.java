package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.data.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *  Wish List Table Container Component class.
 */
public class WishListProductsContainerComponent {

  private final String PRODUCT_COMPONENT_XPATH = "//div[@class='table-responsive']//tbody//tr";
  private final String PRODUCT_COMPONENT_CSSSELECTOR ="#content > div.table-responsive > table > tbody > tr";

  protected WebDriver driver;

  private List<WishListProductComponent> wishListComponents;

  public WishListProductsContainerComponent(WebDriver webDriver) {
    this.driver = webDriver;
    initElements();
  }

  /**
   * This method initialisations elements.
   */
  private void initElements() {
    wishListComponents = new ArrayList<>();
    for (WebElement current : driver.findElements(By.xpath(PRODUCT_COMPONENT_XPATH))) {
      wishListComponents.add(new WishListProductComponent(current));
    }
  }

// Page Object

  /**
   * This method gets wishListTableComponents.
   */
  public List<WishListProductComponent> getWishListComponents() {
    return wishListComponents;
  }

  // Functional

  /**
   * This method gets count of table elements.
   */
  public int getWishListComponentsCount() {
    return wishListComponents.size();
  }

  /**
   * This method gets all names from table.
   */
  public List<String> getWishListComponentNames() {
    List<String> wishListComponentNames = new ArrayList<>();
    for (WishListProductComponent current : getWishListComponents()) {
      wishListComponentNames.add(current.getNameText());
    }
    return wishListComponentNames;
  }

  /**
   * This method gets table component by name.
   */
  protected WishListProductComponent getWishListComponentByName(Product product) {
    WishListProductComponent result = null;
    for (WishListProductComponent current : getWishListComponents()) {
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

  /**
   * This method gets table component price by name.
   */
  public BigDecimal getWishListComponentPriceByName(Product productName) {
    return getWishListComponentByName(productName).getPriceText();
  }

  /**
   * This method gets table component model by name.
   */
  public String getWishListComponentModelByName(Product productName) {
    return getWishListComponentByName(productName).getModelText();
  }

  /**
   * This method clicks table component add to cart button by name.
   */
  public void clickWishListComponentAddToCartButtonByName(Product productName) {
    getWishListComponentByName(productName).clickAddToCartButton();
  }

  /**
   * This method clicks table component remove button by name.
   */
  public void clickWishListComponentRemoveButtonByName(Product productName) {
    getWishListComponentByName(productName).clickRemoveFromWishListButton();
  }

  /**
   * This method clicks table component on name.
   */
  public void clickWishListComponentNameOnName(Product productName) {
    getWishListComponentByName(productName).clickProductName();
  }

}
