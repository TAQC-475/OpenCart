package com.softserve.edu.opencart.data.currency;

import com.softserve.edu.opencart.data.UserRepository;

public class CurrencyRepository {
    private static volatile CurrencyRepository instance = null;

    private CurrencyRepository(){
    }
    public static CurrencyRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new CurrencyRepository();
                }
            }
        }
        return instance;
    }
    public ICurrency getDefault() {
        return getUACurrency();

    }

    public ICurrency getUACurrency() {
        return Currency.get()
                .setCurrencyTitleField("Hryvnia")
                .setCurrencyCodeField("UAH")
                .setCurrencySymbolLeftField("")
                .setCurrencySymbolRightField("₴")
                .setCurrencyDecimalPlacesField("")
                .setCurrencyValueField(29)
                .setCurrencyStatusButton("")
                .build();
    }

}
