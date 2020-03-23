package com.softserve.edu.opencart.tests.view_cart_component;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductOptionsSet;
import com.softserve.edu.opencart.data.ProductOptionsSetRepository;
import com.softserve.edu.opencart.data.ProductRepository;
import org.testng.annotations.DataProvider;

public class ViewCartDataProvider {
    //Products
    Product mac = ProductRepository.getMacBook();
    Product iphone = ProductRepository.getIPhone();
    Product appleCinema = ProductRepository.getAppleCinema30();
    ProductOptionsSet appleCinemaOptions = ProductOptionsSetRepository.getAppleCinema30OptionsSet();

    //cart
    String emptyCartMessage = "Your shopping cart is empty!";
    String emptyCartSummary = "0 item(s) - $0.00";
    int cartSize;
    String cartAmount;
    String cartPrice;

    //Mac prices data
    String usSubTotal = "500.00";
    String usEcoTax = "2.00";
    String usVat = "100.00";
    String ukSubTotal = "306.25";
    String ukEcoTax = "1.23";
    String ukVat = "61.25";

    //Multiple products price data
    String allSubTotal = "601.00";
    String allEcoTax = "4.00";
    String allVat = "120.20";
    String allTotal = "725.20";

    //Allert message name
    String alertMessage = "Success: You have added %s to your shopping cart!";

    @DataProvider
    public Object[][] dataForCurrencyChangeTest() {
        return new Object[][]{{mac, usSubTotal, usEcoTax, usVat, ukSubTotal, ukEcoTax, ukVat}};
    }

    @DataProvider
    public Object[][] dataForProductRemovingTest() {
        cartSize = 0;
        cartAmount = "0";
        cartPrice = "0.00";
        return new Object[][]{{mac, cartSize, cartAmount, cartPrice, emptyCartSummary, emptyCartMessage}};
    }

    @DataProvider
    public Object[][] dataForMultiplyProductsTest() {
        cartSize = 2;
        return new Object[][]{{mac, iphone, cartSize, allSubTotal, allEcoTax, allVat, allTotal}};
    }

    @DataProvider
    public Object[][] dataForAddingTest() {
        cartSize = 3;
        cartAmount = "4";
        return new Object[][]{{iphone, mac, appleCinema, appleCinemaOptions, alertMessage, cartSize, cartAmount}};
    }
}
