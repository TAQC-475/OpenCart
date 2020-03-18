package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ShoppingCartFunctionalityTest extends EpizyUserTestRunner {

    @DataProvider
    public Object[][] dataForSumRefreshAndRemoveTest() {
        return new Object[][]{{UserRepository.get().getDefault(), ProductRepository.getMacBook(), ProductRepository.getIPhone()}};
    }

    @Test(dataProvider = "dataForSumRefreshAndRemoveTest")
    public void checkSumTest(User testUser, Product product1, Product product2) {
        ShoppingCartPage shoppingCartPage = loadApplication().gotoLoginPage()
                .successfulLogin(testUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product1)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product2)
                .goToShoppingCartFromAlert();

        shoppingCartPage = shoppingCartPage.setQuantity(product1, "2");
        shoppingCartPage = shoppingCartPage.setQuantity(product2, "3");

        BigDecimal correctResult = shoppingCartPage.getShoppingCartProductsContainerComponent().calculateOrderCorrectTotalPrice();
        BigDecimal actualResult = shoppingCartPage.getOrderSubTotalPrice();

        Assert.assertEquals(actualResult, correctResult);
    }

    @Test(dataProvider = "dataForSumRefreshAndRemoveTest")
    public void refreshTest(User testUser, Product product1, Product product2) {
//        ShoppingCartPage shoppingCartPage = loadApplication().goToShoppingCartPage();
        ShoppingCartPage shoppingCartPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(testUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product1)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product2)
                .goToShoppingCartFromAlert();

        shoppingCartPage = shoppingCartPage.refreshShoppingCartPageByProduct(product1);

        Assert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutSuccessfulRefresh()));

        int numberOfProductsBeforeRemoving = shoppingCartPage.getShoppingCartProductsContainerComponent().getShoppingCartProductComponentCount();
        shoppingCartPage = shoppingCartPage.removeShoppingCartComponentFromContainerByProduct(product2);
        int numberOfProductsAfterRemoving = shoppingCartPage.getShoppingCartProductsContainerComponent().getShoppingCartProductComponentCount();

        Assert.assertTrue(numberOfProductsAfterRemoving < numberOfProductsBeforeRemoving);
    }
}
