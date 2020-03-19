package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSortingTest extends SearchTestRunner {


//    @Test(description = "verify 'Sort by:' drop down menu")
//    public void checkSortByDropDownMenu() {
//        loadApplication()
//                .successfulSearch(INPUT_SEARCH_ALL_PRODUCTS)
//                .sortProductsByCriteria(SortByFilter.NAME_AZ);
//        //TODO assert
//    }
//
//    @Test(description = "verify 'Show:' drop down menu")
//    public void checkShowDropDownMenu(){
//        loadApplication()
//                .successfulSearch(INPUT_SEARCH_ALL_PRODUCTS)
//                .showProductsByCount(CountOfProducts.FIFTEEN);
//        //TODO assert
//    }

    @Test(description = "verify that 'Grid and List' button works properly")
    public void checkGridView() {
        successPage()
                .viewProductsByGrid();

        softAssert.assertTrue(SearchSuccessPage.isGridViewDisplayed());
        Assert.assertTrue(SearchSuccessPage.isGridViewDisplayed());
    }

    @Test(description = "verify that 'List' button works properly")
    public void checkListView() {
        successPage()
                .viewProductsByList();

        Assert.assertTrue(SearchSuccessPage.isListViewDisplayed());
    }

    @Test(description = "verify pagination")
    public void checkPagination() {
            successPage()
                    .clickNeedPage(Pagination.NEXT_PAGE);
        }
}