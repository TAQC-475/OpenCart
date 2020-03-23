package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListMessagePage extends WishListPage {
  public static final String PRODUCT_REMOVED = "Success: You have modified your wish list!";
  public static final String PRODUCT_ADDED_TO_CART = "Success: You have added %s to your shopping cart!";

  private WebElement removeMessage;
  private WebElement addToCartMessage;
  private WebElement crossButton;

  private WaitUtils waitUtils;


  public WishListMessagePage(WebDriver driver) {
    super(driver);
    initElements();
  }

  /**
   * This method initializations all elements on page.
   */
  private void initElements() {
    removeMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
    addToCartMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
    crossButton = driver.findElement(By.xpath("//div[@class = 'alert alert-success']//button"));
    waitUtils = new WaitUtils(driver, 10);
  }


  /**
   * This method gets remove Alert message.
   */
  public WebElement getRemoveMessage() {
    return removeMessage;
  }

  /**
   * This method gets add product to cart alert message.
   */
  public WebElement getAddToCartMessage() {
    return addToCartMessage;
  }

  /**
   * This method gets cross button.
   */
  public WebElement getCrossButton() {
    return crossButton;
  }

  /**
   * This method clicks on cross button.
   */
  public void clickCrossButton() {
    getCrossButton().click();
  }

  /**
   * This method gets remove alert message text.
   */
  public String getRemoveMessageText() {
    waitUtils.waitForAlertVisibility();
    return getRemoveMessage().getText();
  }

  /**
   * This method gets add to cart message text.
   */
  public String getAddToCartMessageText() {
    return getAddToCartMessage().getText();
  }

  /**
   * This method clicks on cross button.
   */
  public WishListPage clickOnCrossButton() {
    clickCrossButton();
    return new WishListPage(driver);
  }

}
