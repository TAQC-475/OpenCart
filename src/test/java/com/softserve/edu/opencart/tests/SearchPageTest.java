package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import org.testng.annotations.Test;

public class SearchPageTest extends EpizyUserTestRunner {
    public static final String INPUT_SEARCH_VALUE = "Mac";

    @Test(description = "verify 'Sort by:' drop down menu")
    public void checkSortByDropDownMenu() {
        loadApplication()
                .setSearchTopField(INPUT_SEARCH_VALUE);
        loadApplication().clickSearchTopButton()
                .clickSortByDropDownMenuButton()
                .setSortByDropDownMenu(SortByFilter.NAME_AZ);

    }
}
