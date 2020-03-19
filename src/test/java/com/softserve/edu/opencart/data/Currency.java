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
    IStatusButton setCurrencyStatusButton(double statusButton);
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
    private String StatusButton;



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
        return StatusButton;
    }

    public ICodeField setCurrencyTitleField(String titleField) {
        return null;
    }

    public ISymbolLeftField setCurrencyCodeField(String codeField) {
        return null;
    }

    public ISymbolRightField setCurrencySymbolLeftField(String symbolLeftField) {
        return null;
    }

    public IDecimalPlacesField setCurrencySymbolRightField(String symbolRightField) {
        return null;
    }

    public IValueField setCurrencyDecimalPlacesField(String decimalPlacesField) {
        return null;
    }

    public IStatusButton setCurrencyValueField(double valueField) {
        return null;
    }

    public IStatusButton setCurrencyStatusButton(double statusButton) {
        return null;
    }
}
