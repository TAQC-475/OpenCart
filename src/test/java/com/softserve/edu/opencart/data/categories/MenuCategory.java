package com.softserve.edu.opencart.data.categories;

public class MenuCategory {

    private String name;
    private String title;
    private String parent;

    public MenuCategory(String name, String title, String parent) {
        this.name = name;
        this.title = title;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
