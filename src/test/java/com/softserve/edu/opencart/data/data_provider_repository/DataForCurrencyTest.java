package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.CurrenciesSymbol;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.DataProvider;

public class DataForCurrencyTest {
    @DataProvider
    public Object[][] currency() {
        return new Object[][]{
                {UserRepository.get().getShoppingCartUser()},
        };
    }
    @DataProvider
    public Object[][] currencyUnregisteredUser() {
        return new Object[][]{
        };
    }
}
