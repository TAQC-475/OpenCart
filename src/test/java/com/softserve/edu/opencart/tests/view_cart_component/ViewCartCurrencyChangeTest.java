package com.softserve.edu.opencart.tests.view_cart_component;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.annotations.Test;

public class ViewCartCurrencyChangeTest extends LocalTestRunner {

    @Test(dataProvider = "dataForCurrencyChangeTest", dataProviderClass = ViewCartDataProvider.class)
    public void currencyChangeTest(Product mac, String usSubTotal, String usEcoTax, String usVat, String ukSubTotal, String ukEcoTax, String ukVat) {
        HomePage usHome = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert();
        softAssert.assertEquals(usHome.getProductPriceFromViewCart(mac), mac.getPrice(Currencies.US_DOLLAR));
        softAssert.assertEquals(usHome.getSubTotalPriceFromViewCart(), usSubTotal);
        softAssert.assertEquals(usHome.getEcoTaxPriceFromViewCart(), usEcoTax);
        softAssert.assertEquals(usHome.getVATFromViewCart(), usVat);
        softAssert.assertEquals(usHome.getTotalSumFromViewCart(), mac.getPrice(Currencies.US_DOLLAR));

        HomePage ukHome = usHome.chooseCurrency(Currencies.POUND_STERLING);
        softAssert.assertEquals(ukHome.getProductPriceFromViewCart(mac), mac.getPrice(Currencies.POUND_STERLING));
        softAssert.assertEquals(ukHome.getSubTotalPriceFromViewCart(), ukSubTotal);
        softAssert.assertEquals(ukHome.getEcoTaxPriceFromViewCart(), ukEcoTax);
        softAssert.assertEquals(ukHome.getVATFromViewCart(), ukVat);
        softAssert.assertEquals(ukHome.getTotalSumFromViewCart(),mac.getPrice(Currencies.POUND_STERLING));

        softAssert.assertAll();
    }
}
