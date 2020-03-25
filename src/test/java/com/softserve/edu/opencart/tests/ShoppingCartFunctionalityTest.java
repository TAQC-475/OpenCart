package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.data_provider_repository.DataForShoppingCartFunctionalityTest;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTest extends LocalTestRunner {

    /**
     * loading application, logging in, adding products to shopping cart, clicking update button
     * and verifying that message about successful refresh is present
     * @param testUser testUser from UserRepository
     * @param product1 product form ProductRepository
     * @param product2 product form ProductRepository
     */
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

        Assert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutSuccessfulRefresh())
                , "Message about successful refresh is not present");
    }

    /**
     * loading application, logging in, adding products to shopping cart, setting quantity for each product,
     * calculating expected sub-total price and verifying that expected and actual prices are equal
     * @param testUser testUser from UserRepository
     * @param product1 product form ProductRepository
     * @param product2 product form ProductRepository
     */
    @Test(dataProvider = "dataForFunctionalityTest", dataProviderClass = DataForShoppingCartFunctionalityTest.class)
    public void verifySubTotalPriceCalculatesCorrectly(User testUser, Product product1, Product product2) {
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
                .setQuantity(product1, product1.getQuantity())
                .setQuantity(product2, product2.getQuantity());

        Assert.assertTrue(shoppingCartPage.areExpectedAndActualSubTotalPricesEqual()
                , "Expected and actual sub-total prices aren't equal");
    }

    /**
     * loading application, logging in, adding products to shopping cart, clicking remove button
     * and verifying that product is actually removed
     * @param testUser testUser from UserRepository
     * @param product1 product form ProductRepository
     * @param product2 product form ProductRepository
     */
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

        Assert.assertTrue(shoppingCartPage.verifyProductRemoved(product1),String.format("Product %s was not removed", product1));
    }

    /**
     * loading application, logging in, adding product to shopping cart, entering user shipping data,
     * choosing shipping method, verifying that message about applying shipping method
     * and verifying that expected and actual total prices are equal
     * @param testUser testUser from UserRepository
     * @param product product form ProductRepository
     */
    @Test(dataProvider = "dataForShippingAndTaxesTest", dataProviderClass = DataForShoppingCartFunctionalityTest.class)
    public void verifyApplyingShippingMethodAndTotalPriceCalculatesCorrectly(User testUser, Product product) {
        ShoppingCartPage shoppingCartPage = loadApplication()
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

        softAssert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutApplyingShippingMethod())
                , "There is no apply shipping message");
        softAssert.assertTrue(shoppingCartPage.areExpectedAndActualTotalPricesEqual(), "Expected and actual prices are not equal");
        softAssert.assertAll();
    }
}