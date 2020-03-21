package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class SearchTestRunner extends EpizyUserTestRunner {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod()
    public void searchInput() {
        loadApplication()
                .successfulSearch(ProductRepository.getAllProducts());
    }

    public SearchSuccessPage successPage() {
        return new SearchSuccessPage(getDriver());
    }
}