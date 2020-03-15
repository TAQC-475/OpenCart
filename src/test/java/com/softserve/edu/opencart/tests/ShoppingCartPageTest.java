package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends EpizyUserTestRunner {
    @Test
    public void priceTest() {
        loadApplication().gotoLoginPage()
                        .successfulLogin(UserRepository.get()
                        .getDefault())
                        .clickLogo();
        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(super.getDriver());
        productsContainerComponent.getProductComponentByName(ProductRepository.getMacBook()).clickAddToCartButton();
        presentationSleep();
        productsContainerComponent.getProductComponentByName(ProductRepository.getIPhone()).clickAddToCartButton();
        presentationSleep();
        loadApplication().clickShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(super.getDriver());
    }
}
