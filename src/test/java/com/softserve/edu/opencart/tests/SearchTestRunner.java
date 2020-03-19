package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class SearchTestRunner extends EpizyUserTestRunner {
    SoftAssert softAssert = new SoftAssert();
    static SortByFilter SELECT_SORT_BY_FILTER = SortByFilter.NAME_AZ;
    static CountOfProducts SELECT_SHOW_FILTER = CountOfProducts.FIFTY;

    @BeforeMethod()
    public void searchInput() {
        loadApplication()
                .successfulSearch(ProductRepository.getAllProducts());
    }

    public SearchSuccessPage successPage() {
        return new SearchSuccessPage(getDriver());
    }
}