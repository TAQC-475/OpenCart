package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsDisplayComponent extends ProductsContainerComponent {
    private WaitUtils waitUtils = new WaitUtils(driver, 5);

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
        if(driver.findElements(By.xpath("//*[@id='list-view']")).size() > 0) {
            listViewButton = driver.findElement(By.xpath("//*[@id='list-view']"));
        }

        if(driver.findElements(By.xpath("//*[@id='grid-view']")).size() > 0) {
            gridViewButton = driver.findElement(By.xpath("//*[@id='grid-view']"));
        }
        if(driver.findElements(By.id("input-sort")).size()>0) {
        sortByDropDownMenu = new Select(driver.findElement(By.id("input-sort")));
        }
        if(driver.findElements(By.id("input-limit")).size()>0) {
        showDropDownMenu = new Select(driver.findElement(By.id("input-limit")));
        }
    }

    /**
     * Click List button
     */
    public void clickListViewButton() {
        waitUtils.visibilityOfElement(listViewButton);
        if (!listViewButton.isSelected()) {
            listViewButton.click();
        }
    }

    public boolean isListViewDisplayed() {
        return driver.findElement(By.cssSelector(productsListView)).isDisplayed();
    }

    /**
     * Click Grid button
     */
    public void clickGridViewButton() {
        waitUtils.visibilityOfElement(gridViewButton);
        if (!gridViewButton.isSelected()) {
            gridViewButton.click();
        }
    }

    public boolean isGridViewDisplayed() {
        return driver.findElement(By.cssSelector(productsGridView)).isDisplayed();
    }

    /**
     * Sort by: DropDown menu functionality methods
     */
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


    /**
     * Show: dropDown menu functionality methods
     */
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

    /**
     * Pagination functionality methods
     */
    public void clickNeedPage(Pagination page) {
        WebElement result = driver.findElement(By.xpath(String.format(paginationArrow, page)));
        waitUtils.scrollUntilElementVisible(result);
        if (!result.isSelected()) {
            result.click();
        }
    }

    public boolean isPageActive(String page) {
        WebElement result = driver.findElement(By.xpath(String.format(paginationPage, page)));
        waitUtils.scrollUntilElementVisible(result);
        return result.isEnabled();
    }

    // Functional

    /**
     * Choose needed number of products which will display
     */
    public void setShowDropDownMenu(CountOfProducts count) {
        clickShowDropDownButton();
        showDropDownMenu.selectByVisibleText(String.valueOf(count));
    }

    /**
     * Choose Criteria filter value of products on page
     */
    public void setSortByDropDownMenu(SortByFilter filter) {
        clickSortByDropDownMenuButton();
        sortByDropDownMenu.selectByVisibleText(filter.toString());

    }

    // Business Logic

    public void viewProductsByList() {
        clickListViewButton();
    }

    public void viewProductsByGrid() {
        clickGridViewButton();
    }

}