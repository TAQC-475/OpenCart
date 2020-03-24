package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.DataProvider;

public class DataForShoppingCartFunctionalityTest {
    @DataProvider
    public Object[][] dataForFunctionalityTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getMacBookForShoppingCart(), ProductRepository.getIPhoneForShoppingCart()}};
    }

    @DataProvider
    public Object[][] dataForShippingAndTaxesTest() {
        return new Object[][]{{UserRepository.get().getShoppingCartUser(), ProductRepository.getIPhoneForShoppingCart()}};
    }
}
