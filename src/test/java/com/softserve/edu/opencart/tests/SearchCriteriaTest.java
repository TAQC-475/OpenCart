package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCriteriaTest extends EpizyUserTestRunner {
    public static final String INPUT_SEARCH_VALUE = "%";


//    @Test(description = "verify 'Sort by:' drop down menu")
//    public void checkSortByDropDownMenu() {
//        loadApplication()
//                .successfulSearch(INPUT_SEARCH_VALUE)
//                .sortProductsByCriteria(SortByFilter.NAME_AZ);
//        //TODO assert
//    }
//
//    @Test(description = "verify 'Show:' drop down menu")
//    public void checkShowDropDownMenu(){
//        loadApplication()
//                .successfulSearch(INPUT_SEARCH_VALUE)
//                .showProductsByCount(CountOfProducts.FIFTEEN);
//        //TODO assert
//    }

    @Test(description = "verify that 'Grid and List' button works properly")
    public void checkGridView() {
        loadApplication()
                .successfulSearch(INPUT_SEARCH_VALUE)
                .viewProductsByGrid();

        Assert.assertTrue(SearchSuccessPage.isGridViewDisplayed());
    }

    @Test(description = "verify that 'List' button works properly")
    public void checkListView() throws InterruptedException {
        loadApplication()
                .successfulSearch(INPUT_SEARCH_VALUE)
                .viewProductsByList();

        Assert.assertTrue(SearchSuccessPage.isListViewDisplayed());

//    @Test(description = "verify pagination")
//    public void checkPagination(){
//        loadApplication()
//                .successfulSearch(INPUT_SEARCH_VALUE)
//                .clickNeedPage(Pagination.NEXT_PAGE);

    }

    }