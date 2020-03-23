package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewCartButtonTest extends EpizyUserTestRunner {
    SoftAssert softAssert = new SoftAssert();
    //Products
    Product mac = ProductRepository.getMacBook();
    Product iphone = ProductRepository.getIPhone();
    //Empty cart
    String emptyCartMessage = "Your shopping cart is empty!";
    String emptyCartSummary = "0 item(s) - $0.00";
    int emptySize = 0;
    String emptyQuantity = "0";
    String emptyPrice = "0.00";
    //Mac prices data
    String usSubTotal = "500.00";
    String usEcoTax = "2.00";
    String usVat = "100.00";
    String ukSubTotal = "306.25";
    String ukEcoTax = "1.23";
    String ukVat = "61.25";
    //Together price data
    int productsSize = 2;
    String allSubTotal = "601.00";
    String allEcoTax = "4.00";
    String allVat = "120.20";
    String allTotal = "725.20";

    @DataProvider
    public Object[][] dataForCurrencyChangeTest() {
        return new Object[][]{{mac, usSubTotal, usEcoTax, usVat, ukSubTotal, ukEcoTax, ukVat}};
    }

    @DataProvider
    public Object[][] dataForProductRemovingTest() {
        return new Object[][]{{mac, emptySize, emptyQuantity, emptyPrice, emptyCartSummary, emptyCartMessage}};
    }

    @DataProvider
    public Object[][] dataForMultiplyProductsTest() {
        return new Object[][]{{mac, iphone, productsSize, allSubTotal, allEcoTax, allVat, allTotal}};
    }

    @Test(dataProvider = "dataForProductRemovingTest")
    public void productRemovingTest(Product mac, int emptySize, String emptyQuantity, String emptyPrice, String emptyCartSummary, String emptyCartMessage){
        HomePage home = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert();
        home.removeProductFromViewCart(mac);
        softAssert.assertEquals(home.getViewCartProductSize(), emptySize);
        softAssert.assertEquals(home.getViewCartComponentTotalText(), emptyCartSummary);
        softAssert.assertEquals(home.getViewCartComponentTotalAmount(), emptyQuantity);
        softAssert.assertEquals(home.getViewCartComponentTotalSum(), emptyPrice);
        softAssert.assertTrue(home.getViewCartEmptyMsg().isDisplayed());
        softAssert.assertEquals(home.getViewCartEmptyMsgText(), emptyCartMessage);

        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForCurrencyChangeTest")
    public void currencyChangeTest(Product mac, String usSubTotal, String usEcoTax, String usVat, String ukSubTotal, String ukEcoTax, String ukVat) {
        HomePage usHome = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert();
        softAssert.assertEquals(usHome.getProductPriceFromViewCart(mac), mac.getPrice(Currencies.US_DOLLAR));
        softAssert.assertEquals(usHome.getSubTotalPriceFromViewCart(), usSubTotal);
        softAssert.assertEquals(usHome.getEcoTaxPriceFromViewCart(), usEcoTax);
        softAssert.assertEquals(usHome.getVATFromViewCart(), usVat);
        softAssert.assertEquals(usHome.getTotalFromViewCart(), mac.getPrice(Currencies.US_DOLLAR));

        HomePage ukHome = usHome.chooseCurrency(Currencies.POUND_STERLING);
        softAssert.assertEquals(ukHome.getProductPriceFromViewCart(mac), mac.getPrice(Currencies.POUND_STERLING));
        softAssert.assertEquals(ukHome.getSubTotalPriceFromViewCart(), ukSubTotal);
        softAssert.assertEquals(ukHome.getEcoTaxPriceFromViewCart(), ukEcoTax);
        softAssert.assertEquals(ukHome.getVATFromViewCart(), ukVat);
        softAssert.assertEquals(ukHome.getTotalFromViewCart(),mac.getPrice(Currencies.POUND_STERLING));

        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForMultiplyProductsTest")
    public void checkMultiplyProductsTotalTest(Product mac, Product iphone, int productsSize, String allSubTotal, String allEcoTax, String allVat, String allTotal){
        HomePage home = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(iphone)
                .goToHomePageFromAlert();
        softAssert.assertEquals(home.getViewCartProductSize(), productsSize);
        softAssert.assertEquals(home.getProductNameFromViewCart(mac), mac.getName());
        softAssert.assertEquals(home.getProductNameFromViewCart(iphone), iphone.getName());
        softAssert.assertEquals(home.getSubTotalPriceFromViewCart(), allSubTotal);
        softAssert.assertEquals(home.getEcoTaxPriceFromViewCart(), allEcoTax);
        softAssert.assertEquals(home.getVATFromViewCart(), allVat);
        softAssert.assertEquals(home.getTotalFromViewCart(), allTotal);

        softAssert.assertAll();
    }
}
