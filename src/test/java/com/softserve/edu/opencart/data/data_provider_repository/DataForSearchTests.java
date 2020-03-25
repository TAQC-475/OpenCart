package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.CountOfProducts;
import com.softserve.edu.opencart.data.Pagination;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.SortByFilter;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForSearchTests {

    @DataProvider(name = "dataForSortSearchingTests")
    private Object[][] dataForSortSearchingTests(Method method) {
        String testCase = method.getName();
        if ("checkSortByDropDownMenu".equalsIgnoreCase(testCase)) {
            return new Object[][]{{
                    SortByFilter.MODEL_AZ,
                    SortByFilter.MODEL_AZ}};
        } else if ("checkShowDropDownMenu".equalsIgnoreCase(testCase)) {
            return new Object[][]{{
                    CountOfProducts.FIFTY,
                    CountOfProducts.FIFTY}};
        } else if ("checkPagination".equalsIgnoreCase(testCase)) {
            return new Object[][]{{
                    Pagination.NEXT_PAGE, "2"}};
        } else {
            return new Object[][]{{"ERROR: Data Provider can't find method: " + testCase}};
        }
    }
}