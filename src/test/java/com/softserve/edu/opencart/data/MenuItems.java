package com.softserve.edu.opencart.data;

public enum MenuItems {

    DESKTOPS("Desktops"),
    PC("PC"),
    MAC("Mac"),

    LAPTOPS_AND_NOTEBOOKS("Laptops & Notebooks"),
    MACS("Macs"),
    WINDOWS("Windows"),

    COMPONENTS("Components"),
    MICE_AND_TRACKBALLS("Mice and Trackballs"),
    MONITORS("Monitors"),
    PRINTERS("Printers"),
    SCANNERS("Scanners"),
    WEB_CAMERAS("Web Cameras"),

    TABLETS("Tablets"),
    SOFTWARE("Software"),
    PHONES_AND_PDAS("Phones & PDAs"),
    CAMERAS("Cameras"),
    MP3_PLAYERS("MP3 Players");

    private String itemName;

    private MenuItems(String itemName) {

        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
