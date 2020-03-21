package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.SortByFilter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.search.SearchSuccessPage.*;

public class SearchSortingTest extends SearchTestRunner {

    @DataProvider
    public Object[][] dataForSortByFilter() {
        return new Object[][]{{
                SortByFilter.MODEL_AZ,
                SortByFilter.MODEL_AZ
        }};
    }

    @DataProvider
    public Object[][] dataForShowFilter() {
        return new Object[][]{{
                CountOfProducts.FIFTY,
                CountOfProducts.FIFTY
        }};
    }

    @Test(dataProvider = "dataForSortByFilter", description = "verify 'Sort by:' drop down filter")
    public void checkSortByDropDownMenu(SortByFilter actualFilter, SortByFilter expectedFilter) {
        successPage()
                .sortProductsByCriteria(actualFilter);

        Assert.assertTrue(isSortByCorrectCriteria(expectedFilter));
    }

    @Test(dataProvider = "dataForShowFilter", description = "verify 'Show:' drop down filter")
    public void checkShowDropDownMenu(CountOfProducts actualInput, CountOfProducts expectedInput) {
        successPage()
                .showProductsByCount(actualInput);
        Assert.assertTrue(isShowCorrectQuantity(expectedInput));
    }

    @Test(description = "verify that 'Grid and List' button works properly")
    public void checkGridAndListView() {
        successPage()
                .viewProductsByGrid();
        softAssert.assertTrue(isGridViewDisplayed());

        successPage()
                .viewProductsByList();
        softAssert.assertTrue(isListViewDisplayed());

        softAssert.assertAll();
    }
//
//    @Test(description = "verify pagination")
//    public void checkPagination() {
//        successPage()
//                .clickNeededPage(Pagination.NEXT_PAGE);
//
//
//    }
}