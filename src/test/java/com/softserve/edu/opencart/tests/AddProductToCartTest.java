package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductOptionsSet;
import com.softserve.edu.opencart.data.ProductOptionsSetRepository;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.common.AddProductAlertPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductToCartTest extends LocalTestRunner {
    SoftAssert softAssert = new SoftAssert();
    //Products
    Product iphone = ProductRepository.getIPhone();
    Product mac = ProductRepository.getMacBookForShoppingCart();
    Product appleCinema = ProductRepository.getAppleCinema30();
    ProductOptionsSet appleCinemaOptions = ProductOptionsSetRepository.getAppleCinema30OptionsSet();
    //View cart
    int productsSize = 3;
    String amount = "5";
    //Allert message name
    String alertMessage = "Success: You have added %s to your shopping cart!";

    @DataProvider
    public Object[][] dataForAddingTest() {
        return new Object[][]{{iphone, mac, appleCinema, appleCinemaOptions, alertMessage, productsSize, amount}};
    }

    @Test(dataProvider = "dataForAddingTest")
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
        softAssert.assertEquals(appleAlert.getViewCartProductSize(), productsSize);
        //ViewCart Summary
        softAssert.assertEquals(appleAlert.getViewCartComponentTotalAmount(), amount);
        softAssert.assertEquals(appleAlert.getProductNameFromViewCart(iphone), iphone.getName());
        softAssert.assertEquals(appleAlert.getProductNameFromViewCart(mac), mac.getName());
        softAssert.assertEquals(appleAlert.getProductNameFromViewCart(appleCinema), appleCinema.getName());

        softAssert.assertAll();


    }

}
