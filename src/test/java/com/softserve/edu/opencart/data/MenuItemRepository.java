package com.softserve.edu.opencart.data;

public class MenuItemRepository {

    private MenuItemRepository(){
    }

    //    DESKTOPS("Desktops"),
//    LAPTOPS_AND_NOTEBOOKS("Laptops & Notebooks"),
//    COMPONENTS("Components"),
//    TABLETS("Tablets"),
//    SOFTWARE("Software"),
//    PHONES_AND_PDAS("Phones & PDAs"),
//    CAMERAS("Cameras"),
//    MP3_PLAYERS("MP3 Players");

    public static MenuItems getMainMenuItemsSet(){
        return new MenuItems("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software",
                "Phones & PDAs", "Cameras", "MP3 Players");
    }
}
