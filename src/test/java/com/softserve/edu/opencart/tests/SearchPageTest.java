package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import org.testng.annotations.Test;

public class SearchPageTest extends EpizyUserTestRunner {

    @Test(description = "verify 'Sort by:' drop down menu")
    public void checkSortByDropDownMenu() {
        ProductsDisplayComponent productsDisplayComponent = new ProductsDisplayComponent(getDriver());
//        loadApplication().setSearchTopField();

    }
}
