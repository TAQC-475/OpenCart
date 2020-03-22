package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.data.SortByFilter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.search.SearchSuccessPage.isGridViewDisplayed;
import static com.softserve.edu.opencart.pages.user.search.SearchSuccessPage.isListViewDisplayed;

public class SearchSortingTest extends SearchTestRunner {

    //TODO error messages

    @DataProvider
    private Object[][] dataForSortByFilter() {
        return new Object[][]{{
                SortByFilter.MODEL_AZ,
                SortByFilter.MODEL_AZ
        }};
    }

    @DataProvider
    private Object[][] dataForShowFilter() {
        return new Object[][]{{
                CountOfProducts.FIFTY,
                CountOfProducts.FIFTY
        }};
    }

    @DataProvider
    private Object[][] dataForPagination() {
        return new Object[][]{{Pagination.NEXT_PAGE, "2"}};
    }

    @Test(dataProvider = "dataForSortByFilter", description = "verify 'Sort by:' drop down filter")
    public void checkSortByDropDownMenu(SortByFilter actualFilter, SortByFilter expectedFilter) {
        successPage()
                .sortProductsByCriteria(actualFilter);

        Assert.assertTrue(successPage().isSortByCorrectCriteria(expectedFilter));
    }

    @Test(dataProvider = "dataForShowFilter", description = "verify 'Show:' drop down filter")
    public void checkShowDropDownMenu(CountOfProducts actualInput, CountOfProducts expectedInput) {
        successPage()
                .showProductsByCount(actualInput);
        Assert.assertTrue(successPage().isShowCorrectQuantity(expectedInput));
    }

    @Test(description = "verify that 'Grid and List' button works properly")
    public void checkGridAndListView() {
        successPage()
                .viewProductsByGrid();
        softAssert.assertTrue(isGridViewDisplayed());
        //TODO ask about static
        successPage()
                .viewProductsByList();
        softAssert.assertTrue(isListViewDisplayed());

        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForPagination", description = "verify pagination")
    public void checkPagination(Pagination actualPage, String expectedPage) {
        successPage()
                .clickNeededPage(actualPage);

        Assert.assertTrue(successPage().isPageActive(expectedPage));
    }
}