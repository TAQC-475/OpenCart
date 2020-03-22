package com.softserve.edu.opencart.data.creationProductAdminPanel;

public class NewProduct {

    private String productName;
    private String metaTagTitle;
    private String model;

    public NewProduct(String productName, String metaTagTitle, String model) {
        this.productName = productName;
        this.metaTagTitle = metaTagTitle;
        this.model = model;
    }

    //setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setMetaTagTitle(String metaTagTitle) {
        this.metaTagTitle = metaTagTitle;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //getters

    public String getProductName() {
        return productName;
    }

    public String getMetaTagTitle() {
        return metaTagTitle;
    }

    public String getModel() {
        return model;
    }
}
