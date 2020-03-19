package com.softserve.edu.opencart.data;

import org.openqa.selenium.WebElement;

interface ITitleField {
    ICodeField setCurrencyTitleField(String titleField);
}

interface ICodeField {
    ISymbolLeftField setCurrencyCodeField(String codeField);
}

interface ISymbolLeftField {
    ISymbolRightField setCurrencySymbolLeftField(String symbolLeftField);
}

interface ISymbolRightField {
    IDecimalPlacesField setCurrencySymbolRightField(String symbolRightField);
}

interface IDecimalPlacesField {
    IValueField setCurrencyDecimalPlacesField(String decimalPlacesField);
}

interface IValueField {
    IStatusButton setCurrencyValueField(double valueField);
}

interface IStatusButton {
    IStatusButton setCurrencyStatusButton(String statusButton);
}


public final class Currency implements
        ITitleField, ICodeField, ISymbolLeftField,
        ISymbolRightField, IDecimalPlacesField, IValueField, IStatusButton {
    private String titleField;
    private String codeField;
    private String symbolLeftField;
    private String symbolRightField;
    private String decimalPlacesField;
    private double valueField;
    private String statusButton;


    public String getCurrencyTitleField() {
        return titleField;
    }

    public String getCurrencyCodeField() {
        return codeField;
    }

    public String getCurrencySymbolLeftField() {
        return symbolLeftField;
    }

    public String getCurrencySymbolRightField() {
        return symbolRightField;
    }

    public String getCurrencyDecimalPlacesField() {
        return decimalPlacesField;
    }

    public double getCurrencyValueField() {
        return valueField;
    }

    public String getCurrencyStatusButton() {
        return statusButton;
    }

    public ICodeField setCurrencyTitleField(String titleField) {
        this.titleField = titleField;
        return this;
    }

    public ISymbolLeftField setCurrencyCodeField(String codeField) {
        this.codeField = codeField;
        return this;
    }

    public ISymbolRightField setCurrencySymbolLeftField(String symbolLeftField) {
        this.symbolLeftField = symbolLeftField;
        return this;
    }

    public IDecimalPlacesField setCurrencySymbolRightField(String symbolRightField) {
        this.symbolRightField = symbolRightField;
        return this;
    }

    public IValueField setCurrencyDecimalPlacesField(String decimalPlacesField) {
        this.decimalPlacesField = decimalPlacesField;
        return this;
    }

    public IStatusButton setCurrencyValueField(double valueField) {
        this.valueField = valueField;
        return this;
    }

    public IStatusButton setCurrencyStatusButton(String statusButton) {
        this.statusButton = statusButton;
        return this;
    }
}
