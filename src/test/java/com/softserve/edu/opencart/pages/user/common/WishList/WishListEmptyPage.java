package com.softserve.edu.opencart.pages.user.common.WishList;

import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListEmptyPage extends AccountSidebarLoggedPart {

  private WebElement label;
  private WebElement continueButton;
  public static final String EMPTY_WISH_LIST_MESSAGE = "Your wish list is empty.";


  public WishListEmptyPage(WebDriver driver) {
    super(driver);
    initElements();
  }

  /**
   * This method initializations all elements on page.
   */
  private void initElements(){
    label = driver.findElement(By.xpath("//div//p[text() ='Your wish list is empty.']"));
    continueButton = driver.findElement(By.xpath("//div[@class = 'pull-right']//a[text()= 'Continue']"));
  }

  // Page Object

  /**
   * This method gets web element label.
   */
  public WebElement getLabel(){
    return label;
  }

  /**
   * This method gets web element labelText.
   */
  public String getLabelText(){
    return label.getText();
  }

  /**
   * This method gets continueButton.
   */
  public WebElement getContinueButton(){
    return continueButton;
  }

  /**
   * This method clicks on continueButton.
   */
  public void clickContinueButton(){
    getContinueButton().click();
  }

  //BL

  /**
   * This method is written to go to  My Account Page.
   */
  public MyAccountPage goToMyAccountPage(){
    clickContinueButton();
    return new MyAccountPage(driver);
  }

}
