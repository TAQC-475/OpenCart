package com.softserve.edu.opencart.data;

public enum CountOfProducts {

    FIFTEEN(15),
    TWENTY_FIVE(25),
    FIFTY(50),
    SEVENTY_FIVE(75),
    ONE_HUNDRED(100);

    private int filter;

    CountOfProducts(int filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return ((String.valueOf(filter)));
    }
}