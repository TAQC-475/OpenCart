package com.softserve.edu.opencart.pages.admin.currencies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class CurrenciesPage extends LeftMenuPart {

    public static final String CURRENCY_UAH = "Hryvnia";
    //

  //  private WebElement currencyHryvnia;
    private WebElement refreshButton;
    private WebElement addNewButton;
    private WebElement deleteButton;

    public CurrenciesPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
//        currencyHryvnia = driver.findElement(By.xpath("//td[@class='text-left'][contains(text(),'Hryvnia')]"));
        refreshButton = driver.findElement(By.xpath("//*[@data-original-title='Refresh Currency Values']"));
        addNewButton = driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary"));
        deleteButton = driver.findElement(By.xpath("//*[@data-original-title='Delete']"));
    }

//    public WebElement getCurrencyHryvnia() {
//        return currencyHryvnia;
//    }
//
//    public String getCurrencyHryvniaText() {
//        return getCurrencyHryvnia().getText();
//    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public WebElement getAddNewButton() {
        return addNewButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void clickRefreshButton() {
        getRefreshButton().click();
    }

	public void clickAddNewButton() {
		getAddNewButton().click();
	}

	public void clickDeleteButton() {
		getDeleteButton().click();
	}


    // Business Logic
	public AddNewCurrencyPage goToAddNewCurrecyPage(){
		clickAddNewButton();
		return new AddNewCurrencyPage(driver);
	}

}
