package com.softserve.edu.opencart.data.currency;

import java.util.stream.IntStream;

public enum CurrenciesSymbol implements CharSequence {
    EURO("€"),
    POUND_STERLING("£"),
    US_DOLLAR("$"),
    UA_HRYVNIA("₴");

    String symbol;

    private CurrenciesSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public char charAt(int index) {
        return 1;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    public String toString() {
        return symbol;
    }
}




