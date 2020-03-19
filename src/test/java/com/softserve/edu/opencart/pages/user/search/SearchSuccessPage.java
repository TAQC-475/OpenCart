package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.*;
import org.openqa.selenium.WebDriver;

public class SearchSuccessPage extends SearchCriteriaPart {

    private static ProductsDisplayComponent productsDisplay;

    public SearchSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
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

    public static boolean isSortByCorrectCriteria(SortByFilter filter){
        return productsDisplay.isSortByCorrectTextSelected(filter);
    }

    public static boolean isShowCorrectQuantity(CountOfProducts count){
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

    public static boolean isGridViewDisplayed() {
        return productsDisplay.isGridViewDisplayed();
    }

    public static boolean isListViewDisplayed() {
        return productsDisplay.isListViewDisplayed();
    }

    public SearchSuccessPage clickNeededPage(Pagination page){
        productsDisplay.clickNeedPage(page);
        return new SearchSuccessPage(driver);
    }

    public SearchSuccessAlertPage AddToWishButtonByName(Product product) {
        productsDisplay.clickProductComponentAddToWishButtonByName(product.getName());
        return new SearchSuccessAlertPage(driver);
    }

    public ProductInfoPage gotoProductInfo(Product product) {
        getProductsDisplay()
                .getProductComponentByName(product)
                .clickName();
        return new ProductInfoPage(driver);
    }
}