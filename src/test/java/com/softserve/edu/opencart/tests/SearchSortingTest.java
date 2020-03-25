package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.SortByFilter;
import com.softserve.edu.opencart.data.data_provider_repository.DataForAdminTests;
import com.softserve.edu.opencart.data.data_provider_repository.DataForSearchTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSortingTest extends SearchTestRunner {

    @Test(dataProvider = "dataForSortSearchingTests", dataProviderClass = DataForSearchTests.class,
            description = "verify 'Sort by:' drop down filter")
    public void checkSortByDropDownMenu(Product product, SortByFilter actualFilter, SortByFilter expectedFilter) {
        loadApplication()
                .successfulSearch(product)
                .sortProductsByCriteria(actualFilter);

        Assert.assertTrue(successPage().isSortByCorrectCriteria(expectedFilter),
                String.format("Expect: %s, but found: %s", actualFilter, expectedFilter));
    }

    @Test(dataProvider = "dataForSortSearchingTests", dataProviderClass = DataForSearchTests.class,
            description = "verify 'Show:' drop down filter")
    public void checkShowDropDownMenu(Product product, CountOfProducts actualInput, CountOfProducts expectedInput) {
        loadApplication()
                .successfulSearch(product)
                .showProductsByCount(actualInput);

        Assert.assertTrue(successPage().isShowCorrectQuantity(expectedInput),
                String.format("Expect: %s, but found: %s", actualInput, expectedInput));
    }

    @Test(dataProvider = "dataForSortSearchingTests", dataProviderClass = DataForSearchTests.class,
            description = "verify that 'Grid and List' button works properly")
    public void checkGridAndListView(Product product) {
        loadApplication()
                .successfulSearch(product)
                .viewProductsByGrid();
        softAssert.assertTrue(successPage().isGridViewDisplayed(),
                "Grid view button isn't displayed");

        successPage()
                .viewProductsByList();
        softAssert.assertTrue(successPage().isListViewDisplayed(),
                "List view button isn't displayed");

        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForSortSearchingTests", dataProviderClass = DataForSearchTests.class,
            description = "verify pagination on 'Search' page")
    public void checkPagination(Product product, Pagination actualPage, String expectedPage) {
        loadApplication()
                .successfulSearch(product)
                .clickNeededPage(actualPage);

        Assert.assertTrue(successPage().isPageActive(expectedPage),
                String.format("Expect: %s, but found: %s", actualPage, expectedPage));
    }

    @Test(dataProvider = "DataForCyrillicProductTests", dataProviderClass = DataForAdminTests.class)
    public void searchCyrillicProduct(Product cyrillicProduct){
        String actual = loadApplication()
                .successfulSearch(cyrillicProduct)
                .getFirstProduct().getNameText();

        Assert.assertEquals(actual, cyrillicProduct.getName(),
                "Product not found");
    }
}