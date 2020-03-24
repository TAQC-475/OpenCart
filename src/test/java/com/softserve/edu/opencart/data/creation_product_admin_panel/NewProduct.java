package com.softserve.edu.opencart.data.creation_product_admin_panel;

public class NewProduct {

    private String productName;
    private String metaTagTitle;
    private String model;
    private String price;
    private String category;

    public NewProduct(String productName, String metaTagTitle, String model) {
        this.productName = productName;
        this.metaTagTitle = metaTagTitle;
        this.model = model;
    }

    public NewProduct(String productName, String metaTagTitle, String model, String price, String category) {
        this.productName = productName;
        this.metaTagTitle = metaTagTitle;
        this.model = model;
        this.price = price;
        this.category = category;
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

    public void setPrice(String price) { this.price = price; }

    public void setCategory(String category) {
        this.category = category;
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

    public String getPrice() { return price; }

    public String getCategory() { return category; }
}
