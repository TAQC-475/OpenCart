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
    Product mac = ProductRepository.getMacBook();
    String usSubTotal = "500.00";
    String usEcoTax = "2.00";
    String usVat = "100.00";
    String ukSubTotal = "306.25";
    String ukEcoTax = "1.23";
    String ukVat = "61.25";
    String emptyCartMessage = "Your shopping cart is empty!";
    String emptyCartSummary = "0 item(s) - $0.00";

    @DataProvider
    public Object[][] dataForCurrencyChangeTest() {
        return new Object[][]{{mac, usSubTotal, usEcoTax, usVat, ukSubTotal, ukEcoTax, ukVat}};
    }

    @DataProvider
    public Object[][] dataForProductRemovingTest() {
        return new Object[][]{{mac, emptyCartSummary, emptyCartMessage}};
    }

    @Test(dataProvider = "dataForProductRemovingTest")
    public void productRemovingTest(Product mac, String emptyCartSummary, String emptyCartMessage){
        HomePage home = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert();
        home.removeProductFromViewCart(mac);
        softAssert.assertEquals(home.getViewCartProductSize(), 0);
        softAssert.assertEquals(home.getViewCartComponentTotalText(), emptyCartSummary);
        softAssert.assertEquals(home.getViewCartComponentTotalAmount(), "0");
        softAssert.assertEquals(home.getViewCartComponentTotalSum(), "0.00");
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
        softAssert.assertEquals(mac.getPrice(Currencies.US_DOLLAR), usHome.getProductPriceFromViewCart(mac));
        softAssert.assertEquals(usHome.getProductPriceFromViewCart(mac), usHome.getTotalFromViewCart());
        softAssert.assertEquals(usSubTotal, usHome.getSubTotalPriceFromViewCart());
        softAssert.assertEquals(usEcoTax, usHome.getEcoTaxPriceFromViewCart());
        softAssert.assertEquals(usVat, usHome.getVATFromViewCart());

        HomePage ukHome = usHome.chooseCurrency(Currencies.POUND_STERLING);
        softAssert.assertEquals(mac.getPrice(Currencies.POUND_STERLING), ukHome.getProductPriceFromViewCart(mac));
        softAssert.assertEquals(ukHome.getProductPriceFromViewCart(mac), ukHome.getTotalFromViewCart());
        softAssert.assertEquals(ukSubTotal, ukHome.getSubTotalPriceFromViewCart());
        softAssert.assertEquals(ukEcoTax, ukHome.getEcoTaxPriceFromViewCart());
        softAssert.assertEquals(ukVat, usHome.getVATFromViewCart());

        softAssert.assertAll();
    }
}
