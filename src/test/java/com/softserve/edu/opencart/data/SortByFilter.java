package com.softserve.edu.opencart.data;

public enum SortByFilter {
    /**
     * Created for 'Sort by' dropdown menu on Search Page;
     */

    NAME_AZ("Name (A - Z)"),
    NAME_ZA("Name (Z - A)"),
    PRICE_LOW_HIGH("Price (Low > High)"),
    PRICE_HIGH_LOW("Price (High > Low)"),
    RATING_HIGHEST("Rating (Highest)"),
    RATING_LOWEST("Rating (Lowest)"),
    MODEL_AZ("Model (A - Z)"),
    MODEL_ZA("Model (Z - A)");

    private String filter;

    SortByFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return filter;
    }
}