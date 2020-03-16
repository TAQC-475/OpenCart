package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.SortByFilter;
import org.openqa.selenium.WebDriver;

public class SearchSuccessPage extends SearchCriteriaPart {

    private ProductsDisplayComponent productsDisplay;

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

    // TODO Use Enum
    public SearchSuccessPage showProductsByCount(String text) {
        productsDisplay.setShowDropDownMenu(text);
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
