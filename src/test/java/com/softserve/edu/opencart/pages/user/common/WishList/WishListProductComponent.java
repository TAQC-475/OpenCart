package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.pages.user.search.ProductInfoPage;
import com.softserve.edu.opencart.tools.RegularExpression;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

  public WebElement getImage() {
    return image;
  }

  public WebElement getName() {
    return name;
  }

  public void clickProductName(){
    getName().click();
  }

  public String getNameText() {

    return getName().getText();
  }

  public WebElement getModel() {
    return model;
  }

  public String getModelText(){
     return getModel().getText();
  }

  public WebElement getStock() {
    return stock;
  }

  public WebElement getPrice() {
    return price;
  }

  public BigDecimal getPriceText(){
    return new RegularExpression().getBigDecimalFromTheShoppingCartPriceField(getPrice().getText());
  }


  public WebElement getAddToCartButton() {
    return addToCartButton;
  }

  public void clickAddToCartButton() {
    getAddToCartButton().click();
  }

  public WebElement getRemoveFromWIshListButton() {
    return removeFromWIshListButton;
  }

  public void clickRemoveFromWishListButton() {
    getRemoveFromWIshListButton().click();
  }
}


