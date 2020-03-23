package com.softserve.edu.opencart.data.creationProductAdminPanel;

public final class NewProductRepository {

    public NewProductRepository() {
    }

    public static NewProduct cyrillicProduct(){
        return new NewProduct("Самсунг", "Самсунг", "Цьогорічний");
    }
    public static NewProduct router(){
        return new NewProduct("Router TP-LINK", "TP-LINK", "TL-WR841N");
    }
}
