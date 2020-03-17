package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTest extends EpizyUserTestRunner {
    @Test
    public void priceTest() {
        loadApplication().gotoLoginPage()
                .successfulLogin(UserRepository.get().getDefault())
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(ProductRepository.getIPhone())
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(ProductRepository.getMacBook())
                .goToHomePageFromAlert()
                .goToShoppingCartPage()
                .calculateCorrectTotalPrice(ProductRepository.getIPhone());

    }
    @Test
    public void refreshTest() {
        HomePage homePage = loadApplication();
        homePage.gotoLoginPage()
                .successfulLogin(UserRepository.get().getDefault())
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(ProductRepository.getMacBook())
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(ProductRepository.getIPhone())
                .goToHomePageFromAlert()
                .goToShoppingCartPage()
                .refreshShoppingCartPageByProduct(ProductRepository.getMacBook())
                .removeShoppingCartComponentFromContainerByProduct(ProductRepository.getIPhone());
    }
}
