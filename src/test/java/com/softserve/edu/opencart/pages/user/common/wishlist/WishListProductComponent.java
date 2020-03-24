package com.softserve.edu.opencart.pages.user.common.wishlist;

import com.softserve.edu.opencart.tools.RegularExpression;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *  Wish List Component class.
 */
public final class WishListProductComponent {

  private WebElement tableLayout;
  private WebElement image;
  private WebElement name;
  private WebElement model;
  private WebElement stock;
  private WebElement price;
  private WebElement addToCartButton;
  private WebElement removeFromWIshListButton;


  public WishListProductComponent(WebElement tableLayout) {
    this.tableLayout = tableLayout;
    initElements();
  }
  /**
   * This method initializations all elements which product in wish list has.
   */
  private void initElements() {
    image = tableLayout
        .findElement(By.xpath("./td[@class='text-center']/a"));
    name = tableLayout
        .findElement(By.xpath("./td[@class='text-left']/a"));
    model = tableLayout.findElement(By.xpath("./td[@class='text-left']/a/../following-sibling::td[@class='text-left']"));
    stock = tableLayout.findElement(By.xpath("./td[@class='text-right']/div[@class='price']/../preceding-sibling::td[@class='text-right']"));
    price = tableLayout.findElement(By.xpath("./td[@class='text-right']/div[@class='price']"));
    addToCartButton = tableLayout
        .findElement(By.xpath(".//button[@data-original-title='Add to Cart']"));
    removeFromWIshListButton = tableLayout
        .findElement(By.xpath(".//a[@data-original-title='Remove']"));
  }

  // Page Object

  /**
   * This method gets tableLayout.
   */
  public WebElement getTableLayout() {
    return tableLayout;
  }

  /**
   * This method gets image.
   */
  public WebElement getImage() {
    return image;
  }

  /**
   * This method gets productName.
   */
  public WebElement getName() {
    return name;
  }

  /**
   * This method clicks on product name.
   */
  public void clickProductName(){
    getName().click();
  }

  /**
   * This method gets getNameText.
   */
  public String getNameText() {
    return getName().getText();
  }

  /**
   * This method gets product model.
   */
  public WebElement getModel() {
    return model;
  }

  /**
   * This method gets product model text.
   */
  public String getModelText(){
     return getModel().getText();
  }

  /**
   * This method gets product stock.
   */
  public WebElement getStock() {
    return stock;
  }

  /**
   * This method gets product stock text.
   */
  public String getStockText() {
    return getStock().getText();
  }

  /**
   * This method gets product price.
   */
  public WebElement getPrice() {
    return price;
  }

  /**
   * This method gets product price text.
   */
  public BigDecimal getPriceText(){
    return new RegularExpression().getBigDecimalFromTheShoppingCartField(getPrice().getText());
  }

  /**
   * This method gets add to cart button.
   */
  public WebElement getAddToCartButton() {
    return addToCartButton;
  }

  /**
   * This method clicks add to cart button.
   */
  public void clickAddToCartButton() {
    getAddToCartButton().click();
  }

  /**
   * This method gets remove button.
   */
  public WebElement getRemoveFromWIshListButton() {
    return removeFromWIshListButton;
  }

  /**
   * This method clicks remove button.
   */
  public void clickRemoveFromWishListButton() {
    getRemoveFromWIshListButton().click();
  }
}


