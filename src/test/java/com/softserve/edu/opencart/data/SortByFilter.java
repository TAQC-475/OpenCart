package com.softserve.edu.opencart.data;

public enum SortByFilter {
    /**
    Created for 'Sort by' dropdown menu on Search Page;
     */

    NAMEAZ("Name (A - Z)"),
    NAMEZA("Name (Z - A)"),
    PRICELOWHIGH("Price (Low > High)"),
    PRICEHIGHLOW("Price (High > Low)"),
    RATINGHIGHEST("Rating (Highest)"),
    RATINGLOWEST("Rating (Lowest)"),
    MODELAZ("Model (A - Z)"),
    MODELZA("Model (Z - A)");

    private String filter;

    SortByFilter(String  filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return filter;
    }
}
