package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsDisplayComponent extends ProductsContainerComponent {

    private String productsGridView = ".product-grid";
    private String productsListView = ".product-list";
    private String paginationArrow = "//a[text()='%s']";
    private String paginationPage = "//li[@class='active']/span[text()='%s']";


    private WebElement listViewButton;
    private WebElement gridViewButton;
    private Select sortByDropDownMenu;
    private Select showDropDownMenu;

    public ProductsDisplayComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        listViewButton = driver.findElement(By.xpath("//*[@id='list-view']"));
        gridViewButton = driver.findElement(By.xpath("//*[@id='grid-view']"));
        sortByDropDownMenu = new Select(driver.findElement(By.id("input-sort")));
        showDropDownMenu = new Select(driver.findElement(By.id("input-limit")));
    }

    // Page Object

    // listViewButton
    public void clickListViewButton() {
        visibilityOfElement(listViewButton);
        if (!listViewButton.isSelected()) {
            listViewButton.click();
        }
    }

    public boolean isListViewDisplayed() {
        return driver.findElement(By.cssSelector(productsListView)).isDisplayed();
    }

    // gridViewButton
    public void clickGridViewButton() {
        if (!gridViewButton.isSelected()) {
            gridViewButton.click();
        }
    }

    public boolean isGridViewDisplayed() {
        return driver.findElement(By.cssSelector(productsGridView)).isDisplayed();
    }

    // sortByDropDownMenu
    public WebElement getInputSortWebElement() {
        return sortByDropDownMenu.getWrappedElement();
    }

    public String getInputSortText() {
        return sortByDropDownMenu.getFirstSelectedOption().getText();
    }

    public void clickSortByDropDownMenuButton() {
        getInputSortWebElement().click();
    }

    public boolean isSortByCorrectTextSelected(SortByFilter filter) {
        return getInputSortText().contains(filter.toString());
    }


    // showDropDownMenu
    public WebElement getShowDropDownMenuWebElement() {
        return showDropDownMenu.getWrappedElement();
    }

    public String getShowDropDownMenuText() {
        return showDropDownMenu.getFirstSelectedOption().getText();
    }

    public void clickShowDropDownButton() {
        getShowDropDownMenuWebElement().click();
    }

    public boolean isShowCorrectQuantitySelected(CountOfProducts count) {
        return getShowDropDownMenuText().contains(count.toString());
    }

    //Pagination

    public void clickNeedPage(Pagination page) {
        WebElement result = driver.findElement(By.xpath(String.format(paginationArrow, page)));
        scrollUntilButtonsVisible(result);
        if (!result.isSelected()) {
            result.click();
        }
    }

    public boolean isPageActive(String page) {
        WebElement result = driver.findElement(By.xpath(String.format(paginationPage, page)));
        scrollUntilButtonsVisible(result);
        return result.isEnabled();
    }

    // Functional

    private void visibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void scrollUntilButtonsVisible(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void setShowDropDownMenu(CountOfProducts count) {
        clickShowDropDownButton();
        showDropDownMenu.selectByVisibleText(String.valueOf(count));
    }

    public ProductsDisplayComponent setSortByDropDownMenu(SortByFilter filter) {
        clickSortByDropDownMenuButton();
        sortByDropDownMenu.selectByVisibleText(filter.toString());
        return new ProductsDisplayComponent(driver);
    }

    // Business Logic

    public void viewProductsByList() {
        clickListViewButton();
    }

    public void viewProductsByGrid() {
        clickGridViewButton();
    }

}