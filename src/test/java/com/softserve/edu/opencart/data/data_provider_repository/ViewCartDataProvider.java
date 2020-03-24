package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.*;
import org.testng.annotations.DataProvider;

public class ViewCartDataProvider {

    @DataProvider
    public Object[][] dataForCurrencyChangeTest() {
        return new Object[][]{{ProductRepository.getMacBook(),
                Currencies.US_DOLLAR,
                Currencies.POUND_STERLING,
                "500.00",
                "2.00",
                "100.00",
                "306.25",
                "1.23",
                "61.25"}};
    }

    @DataProvider
    public Object[][] dataForProductRemovingTest() {
        return new Object[][]{{ProductRepository.getMacBook(),
                0,
                "0",
                "0.00",
                "0 item(s) - $0.00",
                "Your shopping cart is empty!"}};
    }

    @DataProvider
    public Object[][] dataForMultiplyProductsTest() {
        return new Object[][]{{ProductRepository.getMacBook(),
                ProductRepository.getIPhone(),
                2,
                "601.00",
                "4.00",
                "120.20",
                "725.20"}};
    }

    @DataProvider
    public Object[][] dataForAddingTest() {
        return new Object[][]{{ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                ProductRepository.getAppleCinema30(),
                ProductOptionsSetRepository.getAppleCinema30OptionsSet(),
                "Success: You have added %s to your shopping cart!",
                3,
                "4"}};
    }
}
