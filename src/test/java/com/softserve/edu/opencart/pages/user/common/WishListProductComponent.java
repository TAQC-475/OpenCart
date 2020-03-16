package com.softserve.edu.opencart.pages.user.common;

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

  private void initElements(){
    image = tableLayout.findElement(By.xpath("//div[@class='table-responsive']//td[@class='text-center']/a"));
    name = tableLayout.findElement(By.xpath("//div[@class='table-responsive']//td[@class='text-left']/a"));
    model = tableLayout.findElement(By.xpath("//tbody//td[contains(text(),'Product')]"));
    stock = tableLayout.findElement(By.xpath("//tbody//td[contains(text(),'Stock')]"));
    price = tableLayout.findElement(By.xpath("//div[@class='price']"));
    addToCartButton = tableLayout.findElement(By.xpath("//div//button[@data-original-title='Add to Cart']"));
    removeFromWIshListButton = tableLayout.findElement(By.xpath("//div//a[@data-original-title='Remove']"));

  }

  public WebElement getImage() {
    return image;
  }

  public WebElement getName() {
    return name;
  }

  public WebElement getModel() {
    return model;
  }

  public WebElement getStock() {
    return stock;
  }

  public WebElement getPrice() {
    return price;
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

  public void clickRemoveFromWIshListButton() {
    getRemoveFromWIshListButton().click();
  }
}


