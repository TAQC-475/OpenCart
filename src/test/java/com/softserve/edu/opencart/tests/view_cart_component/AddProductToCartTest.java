package com.softserve.edu.opencart.tests.view_cart_component;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductOptionsSet;
import com.softserve.edu.opencart.pages.user.common.AddProductAlertPage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.annotations.Test;

public class AddProductToCartTest extends LocalTestRunner {

    @Test(dataProvider = "dataForAddingTest", dataProviderClass = ViewCartDataProvider.class)
    public void productAddingTest(Product iphone, Product mac, Product appleCinema, ProductOptionsSet appleCinemaOptions, String alertMessage, int productsSize, String amount) {
        AddProductAlertPage iphoneAlert = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(iphone);
        softAssert.assertTrue(iphoneAlert.getAlertMessage().isDisplayed());
        softAssert.assertEquals(iphoneAlert.getAlertMessageText(), String.format(alertMessage, iphone.getName()));
        AddProductAlertPage macAlert = iphoneAlert
                .gotoHomePage()
                .getProductComponentsContainer()
                .openProductFromContainer(mac)
                .addProductSetQuantity(mac.getQuantity());
        softAssert.assertTrue(macAlert.getAlertMessage().isDisplayed());
        softAssert.assertEquals(macAlert.getAlertMessageText(), String.format(alertMessage, mac.getName()));
        AddProductAlertPage appleAlert = macAlert
                .gotoHomePage()
                .getProductComponentsContainer()
                .openProductFromContainer(appleCinema)
                .addProductWithOptionsSetQuantity(appleCinemaOptions, appleCinema.getQuantity());
        softAssert.assertTrue(appleAlert.getAlertMessage().isDisplayed());
        softAssert.assertEquals(appleAlert.getAlertMessageText(), String.format(alertMessage, appleCinema.getName()));
        softAssert.assertEquals(appleAlert.getProductsSizeFromViewCart(), productsSize);
        //ViewCart Summary
        softAssert.assertEquals(appleAlert.getViewCartButtonTotalAmount(), amount);
        softAssert.assertEquals(appleAlert.getProductNameFromViewCart(iphone), iphone.getName());
        softAssert.assertEquals(appleAlert.getProductNameFromViewCart(mac), mac.getName());
        softAssert.assertEquals(appleAlert.getProductNameFromViewCart(appleCinema), appleCinema.getName());

        softAssert.assertAll();


    }

}
