package com.softserve.edu.opencart.pages.user.common.WishList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishLIstMessagePage extends WishListPage {

  public static final String PRODUCT_REMOVED = "Success: You have modified your wish list!";
  public static final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!";

  private WebElement removeMessage;
  private WebElement addToCartMessage;
  private WebElement crossButton;


  public WishLIstMessagePage(WebDriver driver) {
    super(driver);
  }

  private void initElements() {
    removeMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
    addToCartMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
    crossButton = driver.findElement(By.xpath("//div[@class = 'alert alert-success']//button"));
  }

  public WebElement getRemoveMessage() {
    return removeMessage;
  }

  public WebElement getAddToCartMessage() {
    return addToCartMessage;
  }

  public WebElement getCrossButton() {
    return crossButton;
  }

  public String getRemoveMessageText(){
    return getRemoveMessage().getText();
  }

  public String getAddToCartMessageText(){
    return getAddToCartMessage().getText();
  }
  public void clickCrossButton(){
    getCrossButton().click();
  }


  public WishListPage clickOnCrossButton(){
    clickCrossButton();
    return new WishListPage(driver);
  }


}
