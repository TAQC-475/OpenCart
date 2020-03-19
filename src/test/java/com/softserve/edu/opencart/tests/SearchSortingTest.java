package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSortingTest extends SearchTestRunner {


    @Test(description = "verify 'Sort by:' drop down menu")
    public void checkSortByDropDownMenu() {
        successPage()
                .sortProductsByCriteria(SELECT_SORT_BY_FILTER);

        Assert.assertTrue(SearchSuccessPage.isSortByCorrectCriteria(SELECT_SORT_BY_FILTER));
    }

    @Test(description = "verify 'Show:' drop down menu")
    public void checkShowDropDownMenu() {
        successPage()
                .showProductsByCount(SELECT_SHOW_FILTER);
        Assert.assertTrue(SearchSuccessPage.isShowCorrectQuantity(SELECT_SHOW_FILTER));
    }

    @Test(description = "verify that 'Grid and List' button works properly")
    public void checkGridView() {
        successPage()
                .viewProductsByGrid();
        softAssert.assertTrue(SearchSuccessPage.isGridViewDisplayed());

        successPage()
                .viewProductsByList();
        softAssert.assertTrue(SearchSuccessPage.isListViewDisplayed());

        softAssert.assertAll();
    }

    @Test(description = "verify pagination")
    public void checkPagination() {
        successPage()
                .clickNeededPage(Pagination.NEXT_PAGE);


    }
}