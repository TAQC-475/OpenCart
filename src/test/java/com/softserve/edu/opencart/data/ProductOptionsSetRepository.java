package com.softserve.edu.opencart.data;

public final class ProductOptionsSetRepository {

    private ProductOptionsSetRepository() {
    }

    public static ProductOptionsSet getAppleCinema30OptionsSet(){
        return new ProductOptionsSet("5", "8", "single text", "1", "text area text",
                "80c214a2ebed72ade41c7938ad0984e9f3d1a8b7", "2011-03-25", "12:35", "2011-03-25 22:22");
    }
}
