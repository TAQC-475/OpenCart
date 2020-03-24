package com.softserve.edu.opencart.tests.view_cart_component;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.data_provider_repository.ViewCartDataProvider;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.annotations.Test;

public class ViewCartTotalValuesTest extends LocalTestRunner {


    @Test(dataProvider = "dataForMultiplyProductsTest", dataProviderClass = ViewCartDataProvider.class)
    public void checkMultiplyProductsTotalTest(Product mac,
                                               Product iphone,
                                               int productsSize,
                                               String allSubTotal,
                                               String allEcoTax,
                                               String allVat,
                                               String allTotal){
        HomePage home = loadApplication()
                .getProductComponentsContainer()
                .addProductToCartDirectly(mac)
                .goToHomePageFromAlert()
                .getProductComponentsContainer()
                .addProductToCartDirectly(iphone)
                .goToHomePageFromAlert();
        softAssert.assertEquals(home.getProductsSizeFromViewCart(), productsSize);
        softAssert.assertEquals(home.getProductNameFromViewCart(mac), mac.getName());
        softAssert.assertEquals(home.getProductNameFromViewCart(iphone), iphone.getName());
        softAssert.assertEquals(home.getSubTotalPriceFromViewCart(), allSubTotal);
        softAssert.assertEquals(home.getEcoTaxPriceFromViewCart(), allEcoTax);
        softAssert.assertEquals(home.getVATFromViewCart(), allVat);
        softAssert.assertEquals(home.getTotalSumFromViewCart(), allTotal);

        softAssert.assertAll();
    }

}
