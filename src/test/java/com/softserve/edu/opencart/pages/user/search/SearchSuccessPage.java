package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSuccessPage extends SearchCriteriaPart {

    private ProductsDisplayComponent productsDisplay;

    public SearchSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        productsDisplay = new ProductsDisplayComponent(driver);
    }

    // Page Object

    // productsDisplay

    public ProductsDisplayComponent getProductsDisplay() {
        return productsDisplay;
    }

    // Functional

    // Business Logic

    public SearchSuccessPage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        return new SearchSuccessPage(driver);
    }

    public SearchSuccessPage sortProductsByCriteria(SortByFilter filter) {
        productsDisplay.setSortByDropDownMenu(filter);
        return new SearchSuccessPage(driver);
    }

    public SearchSuccessPage showProductsByCount(CountOfProducts count) {
        productsDisplay.setShowDropDownMenu(count);
        return new SearchSuccessPage(driver);
    }

    public boolean isSortByCorrectCriteria(SortByFilter filter) {
        return productsDisplay.isSortByCorrectTextSelected(filter);
    }

    public boolean isShowCorrectQuantity(CountOfProducts count) {
        return productsDisplay.isShowCorrectQuantitySelected(count);
    }

    public SearchSuccessPage viewProductsByList() {
        productsDisplay.viewProductsByList();
        return new SearchSuccessPage(driver);
    }

    public SearchSuccessPage viewProductsByGrid() {
        productsDisplay.viewProductsByGrid();
        return new SearchSuccessPage(driver);
    }

    public boolean isGridViewDisplayed() {
        return productsDisplay.isGridViewDisplayed();
    }

    public boolean isListViewDisplayed() {
        return productsDisplay.isListViewDisplayed();
    }

    public boolean isPageActive(String page) {
        return productsDisplay.isPageActive(page);
    }

    public SearchSuccessPage clickNeededPage(Pagination page) {
        productsDisplay.clickNeedPage(page);
        return new SearchSuccessPage(driver);
    }

    public SearchSuccessAlertPage AddToWishButtonByName(Product product) {
        productsDisplay.clickProductComponentAddToWishButtonByName(product.getName());
        new WaitUtils(driver, 10).waitForAlertVisibility();
        return new SearchSuccessAlertPage(driver);
    }

    public ProductInfoPage gotoProductInfo(Product product) {
        getProductsDisplay()
                .getProductComponentByName(product)
                .clickName();
        return new ProductInfoPage(driver);
    }

    public ProductComponent getFirstProduct() {
        WebElement firstProduct = driver.findElement(By.cssSelector("#content .product-layout:nth-child(1)"));
        return new ProductComponent(firstProduct);
    }
    public ProductInfoPage clickFirstProduct()
    {
        getFirstProduct().clickName();
        return new ProductInfoPage(driver);
    }
}