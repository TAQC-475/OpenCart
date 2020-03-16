package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import com.softserve.edu.opencart.pages.user.account.LoginPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.common.AddProductAlertPage;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTest extends EpizyUserTestRunner {
    @Test
    public void priceTest() {
        HomePage homePage = loadApplication();
        LoginPage loginPage = homePage.gotoLoginPage();
        MyAccountPage myAccountPage = loginPage.successfulLogin(UserRepository.get().getDefault());
        homePage = myAccountPage.gotoHomePage();
        AddProductAlertPage addProductAlertPage = homePage.getProductComponentsContainer()
                                                          .addProductToCartFromContainer(ProductRepository.getMacBook());
        presentationSleep(3);
        ShoppingCartPage shoppingCartPage = addProductAlertPage.goToShoppingCartFromAlert();
        presentationSleep(3);
//        shoppingCartPage.getShoppingCartProductsContainerComponent()
//                        .getShoppingCartProductComponentByProduct(ProductRepository.getMacBook())
//                        .clickRefreshButton();
        shoppingCartPage = shoppingCartPage.refreshShoppingCartPageByProduct(ProductRepository.getMacBook());
        shoppingCartPage.getShoppingCartProductsContainerComponent()
                        .getShoppingCartProductComponentByProduct(ProductRepository.getMacBook())
                        .clickRemoveButton();
//        loadApplication().gotoLoginPage()
//                        .successfulLogin(UserRepository.get()
//                        .getDefault())
//                        .clickLogo();
//        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(super.getDriver());
//        productsContainerComponent.getProductComponentByName(ProductRepository.getMacBook()).clickAddToCartButton();
//        presentationSleep();
//        productsContainerComponent.getProductComponentByName(ProductRepository.getIPhone()).clickAddToCartButton();
//        presentationSleep();
//        loadApplication().clickShoppingCart();
//        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(super.getDriver());
    }
}
