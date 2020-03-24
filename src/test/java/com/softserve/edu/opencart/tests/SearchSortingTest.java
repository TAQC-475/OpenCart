package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.data.SortByFilter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SearchSortingTest extends SearchTestRunner {

    //TODO error messages

    @DataProvider (name = "dataForSortSearchingTests")
    private Object[][] dataForSortSearchingTests(Method method) {
        String testCase = method.getName();
        if ("checkSortByDropDownMenu".equalsIgnoreCase(testCase)){
        return new Object[][]{{
                SortByFilter.MODEL_AZ,
                SortByFilter.MODEL_AZ}};}
        else if ("checkShowDropDownMenu".equalsIgnoreCase(testCase)){
            return new Object[][]{{
                    CountOfProducts.FIFTY,
                    CountOfProducts.FIFTY}};
        }else if ("checkPagination".equalsIgnoreCase(testCase)) {
            return new Object[][]{{Pagination.NEXT_PAGE, "2"}};
        }
        else {
            return new Object[][]{{ "ERROR: Data Provider can't find method: " + testCase}};
        }
    }

    @Test(dataProvider = "dataForSortSearchingTests",
            description = "verify 'Sort by:' drop down filter")
    public void checkSortByDropDownMenu(SortByFilter actualFilter, SortByFilter expectedFilter) {
        successPage()
                .sortProductsByCriteria(actualFilter);

        Assert.assertTrue(successPage().isSortByCorrectCriteria(expectedFilter),
                String.format("Expect: %s, but found: %s", actualFilter, expectedFilter));
    }

    @Test(dataProvider = "dataForSortSearchingTests", description = "verify 'Show:' drop down filter")
    public void checkShowDropDownMenu(CountOfProducts actualInput, CountOfProducts expectedInput) {
        successPage()
                .showProductsByCount(actualInput);
        Assert.assertTrue(successPage().isShowCorrectQuantity(expectedInput),
                String.format("Expect: %s, but found: %s", actualInput, expectedInput));
    }

    @Test(description = "verify that 'Grid and List' button works properly")
    public void checkGridAndListView() {
        successPage()
                .viewProductsByGrid();
        softAssert.assertTrue(successPage().isGridViewDisplayed());

        successPage()
                .viewProductsByList();
        softAssert.assertTrue(successPage().isListViewDisplayed());

        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForSortSearchingTests", description = "verify pagination on 'Search' page")
    public void checkPagination(Pagination actualPage, String expectedPage) {
        successPage()
                .clickNeededPage(actualPage);

        Assert.assertTrue(successPage().isPageActive(expectedPage),
                String.format("Expect: %s, but found: %s", actualPage, expectedPage));
    }
}