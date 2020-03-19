package com.softserve.edu.opencart.data;

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

    private ICurrency getUACurrency() {
        return Currency.get()
                .setCurrencyTitleField("hrn")
                .setCurrencyCodeField("UAH")
                .setCurrencySymbolLeftField("")
                .setCurrencySymbolRightField("₴")
                .setCurrencyDecimalPlacesField("")
                .setCurrencyValueField(29)
                .setCurrencyStatusButton("")
                .build();
    }

}