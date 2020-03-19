package com.softserve.edu.opencart.pages.admin.currencies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class CurrenciesPage extends LeftMenuPart {

    public static final String EXPECTED_TITLE_MESSAGE = "Currencies";
    //
	private WebDriver driver;

    private WebElement title;
    private WebElement refreshButton;
    private WebElement addNewButton;
    private WebElement deleteButton;

    public CurrenciesPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        title = driver.findElement(By.cssSelector("div.page-header h1"));
        refreshButton = driver.findElement(By.xpath("//*[@data-original-title='Refresh Currency Values']"));
        addNewButton = driver.findElement(By.xpath("//*[@data-original-title='Add New']"));
        deleteButton = driver.findElement(By.xpath("//*[@data-original-title='Delete']"));
    }


    public WebElement getTitle() {
        return title;
    }

    public String getTitleText() {
        return getTitle().getText();
    }

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
