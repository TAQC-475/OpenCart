package com.softserve.edu.opencart.data.currency;

public interface ICurrency {
    String getCurrencyTitleField();
    String getCurrencyCodeField();
    String getCurrencySymbolLeftField();
    String getCurrencySymbolRightField();
    String getCurrencyDecimalPlacesField();
    double getCurrencyValueField();
    String getCurrencyStatusButton();
}
