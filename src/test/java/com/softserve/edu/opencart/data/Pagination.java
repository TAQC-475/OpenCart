package com.softserve.edu.opencart.data;

public enum Pagination {
    NEXT_PAGE(">"),
    LAST_PAGE(">|"),
    PREVIOUS_PAGE("<"),
    FIRST_PAGE("|<");

    public String page;

    Pagination(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return page;
    }
}
