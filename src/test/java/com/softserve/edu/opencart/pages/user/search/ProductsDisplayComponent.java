package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsDisplayComponent extends ProductsContainerComponent {

    private WebElement listViewButton;
    private WebElement gridViewButton;
    private WebElement productsView;
    private static Select sortByDropDownMenu;
    private Select showDropDownMenu;

    public ProductsDisplayComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        listViewButton = driver.findElement(By.id("list-view"));
        gridViewButton = driver.findElement(By.id("grid-view"));
        sortByDropDownMenu = new Select(driver.findElement(By.id("input-sort")));
        showDropDownMenu = new Select(driver.findElement(By.id("input-limit")));
    }

    // Page Object

    // listViewButton
    public void clickListViewButton() {
        if (!listViewButton.isSelected()) {
            gridViewButton.click();
        }
    }

    public boolean isListViewDisplayed() {
        return productsView.findElement(By.cssSelector(".product-list")).isDisplayed();
    }

    // gridViewButton
    public void clickGridViewButton() {
        if (!gridViewButton.isSelected()) {
            gridViewButton.click();
        }
    }

    public boolean isGridViewDisplayed() {
        return productsView.findElement(By.cssSelector(".product-grid")).isDisplayed();
    }

    // sortByDropDownMenu
    public WebElement getInputSortWebElement() {
        return sortByDropDownMenu.getWrappedElement();
    }

    public String getInputSortText() {
        return sortByDropDownMenu.getFirstSelectedOption().getText();
    }

    public void setSortByDropDownMenu(SortByFilter filter) {
        sortByDropDownMenu.selectByVisibleText(String.valueOf(filter));
    }

    public void clickSortByDropDownMenu() {
        getInputSortWebElement().click();
    }

    // showDropDownMenu
    public Select getShowDropDownMenu() {
        return showDropDownMenu;
    }

    public WebElement getShowDropDownMenuWebElement() {
        return getShowDropDownMenu().getWrappedElement();
    }

    public String getShowDropDownMenuText() {
        return getShowDropDownMenu().getFirstSelectedOption().getText();
    }

    public void setShowDropDownMenu(String text) {
        getShowDropDownMenu().selectByVisibleText(text);
    }

    public void clickShowDropDownButton() {
        getShowDropDownMenuWebElement().click();
    }

    // Functional

    // Business Logic

    public void viewProductsByList() {
        clickListViewButton();
    }

    public void viewProductsByGrid() {
        clickGridViewButton();
    }

}
