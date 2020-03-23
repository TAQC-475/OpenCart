package com.softserve.edu.opencart.data.categories;

public class MenuCategoryRepository {

    private MenuCategoryRepository(){}

    public static MenuCategory routers() {
        return new MenuCategory("Routers","test","test");
    }
}
