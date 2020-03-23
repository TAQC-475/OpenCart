package com.softserve.edu.opencart.data;

    public enum MenuItems {

        ROUTERS("Routers"),
        DESKTOPS("Desktops"),
        LAPTOPS_AND_NOTEBOOKS("Laptops & Notebooks"),
        COMPONENTS("Components"),
        TABLETS("Tablets"),
        SOFTWARE("Software"),
        PHONES_AND_PDAS("Phones & PDAs"),
        CAMERAS("Cameras"),
        MP3_PLAYERS("MP3 Players");

        private String name;

        private MenuItems(String name) {

            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }


        }