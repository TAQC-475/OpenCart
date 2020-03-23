package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTest extends LocalTestRunner {
    @DataProvider
    public Object[][] dataForFunctionalityTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getMacBookForShoppingCart(), ProductRepository.getIPhoneForShoppingCart()}};
    }

    @DataProvider
    public Object[][] dataForShippingAndTaxesTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getIPhoneForShoppingCart()}};
    }

    @Test(dataProvider = "dataForFunctionalityTest")
    public void shoppingCartFunctionalityTest(User testUser, Product product1, Product product2) {

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

        softAssert.assertTrue(shoppingCartPage.areExpectedAndActualSubTotalPricesEqual(), "Expected and Actual Sub Total prices are not equal");

        shoppingCartPage = shoppingCartPage.refreshShoppingCartPageByProduct(product2);
        softAssert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutSuccessfulRefresh()), "There is no refresh success message");

        shoppingCartPage = shoppingCartPage.removeComponentByProduct(product1);
        verifyProductRemoved(product1.getName());

        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForShippingAndTaxesTest")
    public void shippingAndTaxesTest(User testUser, Product product) {
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

    private void verifyProductRemoved(String expectedRemovedItem) {
        new ShoppingCartPage(getDriver())
                .getShoppingCartProductsContainer()
                .getContainerComponents()
                .forEach(shoppingCartProductComponent ->
                        softAssert.assertNotEquals(shoppingCartProductComponent.getProductNameText(),
                                expectedRemovedItem,
                                String.format("Product %s was not removed", expectedRemovedItem)));
    }

//    @Test(dataProvider = "dataForFunctionalityTest")
//    public void checkSumTest(User testUser, Product product1, Product product2) {
//        ShoppingCartPage shoppingCartPage = loadApplication().gotoLoginPage()
//                .successfulLogin(testUser)
//                .gotoHomePage()
//                .getProductComponentsContainer()
//                .addProductToCartDirectly(product1)
//                .goToHomePageFromAlert()
//                .getProductComponentsContainer()
//                .addProductToCartDirectly(product2)
//                .goToShoppingCartFromAlert()
//                .setQuantity(product1, product1.getQuantity())
//                .setQuantity(product2, product2.getQuantity());
//        Assert.assertTrue(shoppingCartPage.areCorrectAndActualSubTotalPricesEqual());
//    }
//
//    @Test(dataProvider = "dataForFunctionalityTest")
//    public void refreshButtonTest(User testUser, Product product1, Product product2) {
//        ShoppingCartPage shoppingCartPage = loadApplication()
//                .gotoLoginPage()
//                .successfulLogin(testUser)
//                .gotoHomePage()
//                .getProductComponentsContainer()
//                .addProductToCartDirectly(product1)
//                .goToHomePageFromAlert()
//                .getProductComponentsContainer()
//                .addProductToCartDirectly(product2)
//                .goToShoppingCartFromAlert()
//                .refreshShoppingCartPageByProduct(product1);
//
//        Assert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutSuccessfulRefresh()));
//    }
//
//    @Test(dataProvider = "dataForFunctionalityTest")
//    public void removeButtonTest(User testUser, Product product1, Product product2) {
//        ShoppingCartPage shoppingCartPage = loadApplication()
//                .gotoLoginPage()
//                .successfulLogin(testUser)
//                .gotoHomePage()
//                .getProductComponentsContainer()
//                .addProductToCartDirectly(product1)
//                .goToHomePageFromAlert()
//                .getProductComponentsContainer()
//                .addProductToCartDirectly(product2)
//                .goToShoppingCartFromAlert()
//                .removeComponentByProduct(product1);
//
//        verifyProductRemoved(product1.getName());
//    }
}
