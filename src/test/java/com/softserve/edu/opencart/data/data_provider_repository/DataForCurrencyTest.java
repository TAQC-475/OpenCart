package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.currency.CurrencyRepository;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForCurrencyTest {
    @DataProvider
    public Object[][] userCurrency() {
        return new Object[][]{
                {UserRepository.get().getShoppingCartUser()},
        };
    }
    @DataProvider
    public Object[][] adminCurrency(Method method) {
        return new Object[][] {
                { UserRepository.get().getAdmin(), CurrencyRepository.get().getUACurrency()},
        };
    }
}
