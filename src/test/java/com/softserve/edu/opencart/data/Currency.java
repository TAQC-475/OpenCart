package com.softserve.edu.opencart.data;

import org.openqa.selenium.WebElement;

public final class Currency implements ICurrency {
    private String titleField;
    private String codeField;
    private String symbolLeftField;
    private String symbolRightField;
    private String decimalPlacesField;
    private double valueField;
    private String StatusButton;

    public void setTitleField(String titleField) {
        this.titleField = titleField;
    }

    public void setCodeField(String codeField) {
        this.codeField = codeField;
    }

    public void setSymbolLeftField(String symbolLeftField) {
        this.symbolLeftField = symbolLeftField;
    }

    public void setSymbolRightField(String symbolRightField) {
        this.symbolRightField = symbolRightField;
    }

    public void setDecimalPlacesField(String decimalPlacesField) {
        this.decimalPlacesField = decimalPlacesField;
    }

    public void setValueField(double valueField) {
        this.valueField = valueField;
    }

    public void setStatusButton(String statusButton) {
        StatusButton = statusButton;
    }

    public String getCurrencyTitleField() {
        return null;
    }

    public String getCurrencyCodeField() {
        return null;
    }

    public String getCurrencySymbolLeftField() {
        return null;
    }

    public String getCurrencySymbolRightField() {
        return null;
    }

    public String getCurrencyDecimalPlacesField() {
        return null;
    }

    public double getCurrencyValueField() {
        return 0;
    }

    public String getCurrencyStatusButton() {
        return null;
    }
}
