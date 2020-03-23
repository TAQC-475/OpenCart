package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartFunctionalityTest extends EpizyUserTestRunner {

    @DataProvider
    public Object[][] dataForSumAndRefreshTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getMacBookForShoppingCart(), ProductRepository.getIPhoneForShoppingCart()}};
    }

    @DataProvider
    public Object[][] dataForFunctionalityTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getMacBookForShoppingCart(), ProductRepository.getIPhoneForShoppingCart(), 2}};
    }

    @DataProvider
    public Object[][] dataForShippingAndTaxesTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getIPhoneForShoppingCart()}};
    }

    @Test(dataProvider = "dataForSumAndRefreshTest")
    public void checkSumTest(User testUser, Product product1, Product product2) {
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
        Assert.assertTrue(shoppingCartPage.areCorrectAndActualSubTotalPricesEqual());
    }

    @Test(dataProvider = "dataForSumAndRefreshTest")
    public void refreshButtonTest(User testUser, Product product1, Product product2) {
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

    @Test(dataProvider = "dataForFunctionalityTest")
    public void removeButtonTest(User testUser, Product product1, Product product2, int numberBeforeRemoving) {
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
                .removeShoppingCartComponentFromContainerByProduct(product1);

        verifyProductRemoved(product1.getName());
    }

    @Test(dataProvider = "dataForFunctionalityTest")
    public void shoppingCartFunctionalityTest(User testUser, Product product1, Product product2, int sizeBeforeRemoving) {

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

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(shoppingCartPage.areCorrectAndActualSubTotalPricesEqual(), "Expected and Actual Sub Total prices are not equal");

        shoppingCartPage = shoppingCartPage.refreshShoppingCartPageByProduct(product2);
        softAssert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutSuccessfulRefresh()), "There is no refresh success message");

        shoppingCartPage = shoppingCartPage.removeShoppingCartComponentFromContainerByProduct(product1);
        softAssert.assertEquals(shoppingCartPage.sizeDifferenceBeforeAndAfterRemoving(sizeBeforeRemoving), 1, "Difference before and after removing is not 1");

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

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(shoppingCartPage.isElementPresent(shoppingCartPage.getMessageAboutApplyingShippingMethod()));

        softAssert.assertTrue(shoppingCartPage.areCorrectAndActualTotalPricesEqual());

        softAssert.assertAll();
    }

    private void verifyProductRemoved(String expectedRemovedItem) {
        new ShoppingCartPage(getDriver())
                .getShoppingCartProductsContainerPage()
                .getShoppingCartProductComponents()
                .forEach(shoppingCartProductComponent ->
                        Assert.assertNotEquals(shoppingCartProductComponent.getProductNameText(),
                                expectedRemovedItem,
                                String.format("Product %s was not removed", expectedRemovedItem)));
    }
}
