package com.softserve.edu.opencart.data;

public class MenuItems {

    private String desktops;
    private String laptopsNotebooks;
    private String components;
    private String tablets;
    private String software;
    private String phonesPDAs;
    private String cameras;
    private String mp3Players;

    public MenuItems(String desktops, String laptopsNotebooks, String components, String tablets, String software, String phonesPDAs, String cameras, String mp3Players) {
        this.desktops = desktops;
        this.laptopsNotebooks = laptopsNotebooks;
        this.components = components;
        this.tablets = tablets;
        this.software = software;
        this.phonesPDAs = phonesPDAs;
        this.cameras = cameras;
        this.mp3Players = mp3Players;
    }

    public String getDesktops() {
        return desktops;
    }

    public void setDesktops(String desktops) {
        this.desktops = desktops;
    }

    public String getLaptopsNotebooks() {
        return laptopsNotebooks;
    }

    public void setLaptopsNotebooks(String laptopsNotebooks) {
        this.laptopsNotebooks = laptopsNotebooks;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getTablets() {
        return tablets;
    }

    public void setTablets(String tablets) {
        this.tablets = tablets;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getPhonesPDAs() {
        return phonesPDAs;
    }

    public void setPhonesPDAs(String phonesPDAs) {
        this.phonesPDAs = phonesPDAs;
    }

    public String getCameras() {
        return cameras;
    }

    public void setCameras(String cameras) {
        this.cameras = cameras;
    }

    public String getMp3Players() {
        return mp3Players;
    }

    public void setMp3Players(String mp3Players) {
        this.mp3Players = mp3Players;
    }
}
//    DESKTOPS("Desktops"),
//    LAPTOPS_AND_NOTEBOOKS("Laptops & Notebooks"),
//    COMPONENTS("Components"),
//    TABLETS("Tablets"),
//    SOFTWARE("Software"),
//    PHONES_AND_PDAS("Phones & PDAs"),
//    CAMERAS("Cameras"),
//    MP3_PLAYERS("MP3 Players");