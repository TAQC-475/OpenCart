package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTest extends EpizyUserTestRunner {
    @Test
    public void priceTest() {

    }
    @Test
    public void refreshTest() {
        HomePage homePage = loadApplication();
        homePage.gotoLoginPage()
                .successfulLogin(UserRepository.get().getDefault())
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartFromContainer(ProductRepository.getMacBook())
                .goToShoppingCartFromAlert()
                .refreshShoppingCartPageByProduct(ProductRepository.getMacBook())
                .removeShoppingCartComponentFromContainerByProduct(ProductRepository.getMacBook());
    }
}
