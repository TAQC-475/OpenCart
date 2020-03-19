package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public abstract class SearchTestRunner extends EpizyUserTestRunner {
    public static final String INPUT_SEARCH_ALL_PRODUCTS = "%";
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void searchInput() {
        loadApplication()
                .successfulSearch(INPUT_SEARCH_ALL_PRODUCTS);
    }

    public SearchSuccessPage successPage() {
        return new SearchSuccessPage(getDriver());
    }
}