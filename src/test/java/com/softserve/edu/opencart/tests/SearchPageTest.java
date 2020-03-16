package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.annotations.Test;

public class SearchPageTest extends EpizyUserTestRunner {
    public static final String INPUT_SEARCH_VALUE = "Mac";

    @Test(description = "verify 'Sort by:' drop down menu")
    public void checkSortByDropDownMenu(Product product) {
        SearchSuccessPage searchSuccessPage = loadApplication()
                .successfulSearch(product)
                .sortProductsByCriteria(SortByFilter.NAME_AZ);

    }
}
