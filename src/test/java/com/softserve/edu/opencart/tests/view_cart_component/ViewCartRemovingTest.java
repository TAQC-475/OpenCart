package com.softserve.edu.opencart.tests.view_cart_component;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.annotations.Test;

public class ViewCartRemovingTest extends LocalTestRunner {

    @Test(dataProvider = "dataForProductRemovingTest", dataProviderClass = ViewCartDataProvider.class)
    public void productRemovingTest(Product mac, int emptySize, String emptyQuantity, String emptyPrice, String emptyCartSummary, String emptyCartMessage){
        HomePage home = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert();
        home.removeProductFromViewCart(mac);
        softAssert.assertEquals(home.getProductsSizeFromViewCart(), emptySize);
        softAssert.assertEquals(home.getViewCartButtonTotalText(), emptyCartSummary);
        softAssert.assertEquals(home.getViewCartButtonTotalAmount(), emptyQuantity);
        softAssert.assertEquals(home.getViewCartButtonTotalSum(), emptyPrice);
        softAssert.assertTrue(home.getEmptyMsgFromViewCart().isDisplayed());
        softAssert.assertEquals(home.getEmptyMsgTextFromViewCart(), emptyCartMessage);

        softAssert.assertAll();
    }
}
