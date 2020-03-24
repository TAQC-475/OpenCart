package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.data_provider_repository.DataForShoppingCartFunctionalityTest;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTest extends LocalTestRunner {

    @Test(dataProvider = "dataForFunctionalityTest", dataProviderClass = DataForShoppingCartFunctionalityTest.class)
    public void verifyUpdateButtonRefreshesThePage(User testUser, Product product1, Product product2) {
        ShoppingCartPage shoppingCartPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(testUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product1)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product2)
                .goToShoppingCartFromAlert()
                .refreshShoppingCartPageByProduct(product1);

        Assert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutSuccessfulRefresh()));
    }

    @Test(dataProvider = "dataForFunctionalityTest", dataProviderClass = DataForShoppingCartFunctionalityTest.class)
    public void verifySubTotalPriceCalculatesCorrectly(User testUser, Product product1, Product product2) {
        ShoppingCartPage shoppingCartPage = loadApplication().gotoLoginPage()
                .successfulLogin(testUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product1)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product2)
                .goToShoppingCartFromAlert()
                .setQuantity(product1, product1.getQuantity())
                .setQuantity(product2, product2.getQuantity());

        Assert.assertTrue(shoppingCartPage.areExpectedAndActualSubTotalPricesEqual());
    }

    @Test(dataProvider = "dataForFunctionalityTest", dataProviderClass = DataForShoppingCartFunctionalityTest.class)
    public void verifyThatRemoveButtonRemovesProduct(User testUser, Product product1, Product product2) {
        ShoppingCartPage shoppingCartPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(testUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product1)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(product2)
                .goToShoppingCartFromAlert()
                .removeComponentByProduct(product1);

        Assert.assertTrue(shoppingCartPage.verifyProductRemoved(product1.getName()));
    }

    @Test(dataProvider = "dataForShippingAndTaxesTest", dataProviderClass = DataForShoppingCartFunctionalityTest.class)
    public void verifyApplyingShippingAndTotalPriceCalculatesCorrectly(User testUser, Product product) {
        ShoppingCartPage shoppingCartPage =
                loadApplication()
                        .gotoLoginPage()
                        .successfulLogin(testUser)
                        .gotoHomePage()
                        .getProductComponentsContainer()
                        .addProductToCartDirectly(product)
                        .goToShoppingCartFromAlert()
                        .goToShippingAndTaxesComponent()
                        .selectCountryByName(testUser.getCountry())
                        .selectRegionStateByName(testUser.getRegionState())
                        .inputPostCode(testUser.getPostCode())
                        .switchToSelectShippingMethodPage()
                        .selectFlatShippingRate()
                        .clickApplyShippingButton();

        softAssert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutApplyingShippingMethod()), "There is no apply shipping message");
        softAssert.assertTrue(shoppingCartPage.areExpectedAndActualTotalPricesEqual(), "Expected and actual prices are not equal");
        softAssert.assertAll();
    }
}
