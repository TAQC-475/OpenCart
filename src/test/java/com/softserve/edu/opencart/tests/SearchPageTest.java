package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.SortByFilter;
import org.testng.annotations.Test;

public class SearchPageTest extends EpizyUserTestRunner {
    public static final String INPUT_SEARCH_VALUE = "Mac";

    @Test(description = "verify 'Sort by:' drop down menu")
    public void checkSortByDropDownMenu(Product product) {
        loadApplication()
                .successfulSearch(product)
                .sortProductsByCriteria(SortByFilter.NAME_AZ);
        //TODO assert
    }

    @Test(description = "verify 'Show:' drop down menu")
    public void checkShowDropDownMenu(Product product){
        loadApplication()
                .successfulSearch(product)
                .showProductsByCount(CountOfProducts.FIFTEEN);
        //TODO assert
    }


}
