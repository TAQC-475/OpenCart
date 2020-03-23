package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.ProductInfoPage;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaTest extends LocalTestRunner {


    @Test(description = "Check if search fields have the same input")
    public void checkSearchFieldsInputValues() {
        Product expectedProduct = new Product("Samsung");

        SearchSuccessPage successPage = this.loadApplication().successfulSearch(expectedProduct);
        String actualProductName = successPage.getCriteriaSearchFieldText();

        Assert.assertEquals(actualProductName, expectedProduct.getName());
    }

    @Test(description = "Check if search button works correctly")
    public void checkSearchButton() {
        String expectedProductName = "Mac";
        SearchSuccessPage successPage = this.loadApplication().successfulSearch(ProductRepository.getAllProducts());
        successPage.clearCriteriaSearchField();
        successPage.setCriteriaSearchField(expectedProductName);
        successPage.clickCriteriaSearchButton();
        SearchSuccessPage updatedPage = new SearchSuccessPage(getDriver());
        String actualProductName = updatedPage.getCriteriaSearchFieldText();

        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Test(description = "Search in product descriptions")
    public void checkingSearchingInDescription()
    {
        Product product = new Product("touch");
        SearchSuccessPage successPage = this.loadApplication().successfulSearch(product);
        successPage.clickCriteriaDescription()
                    .clickCriteriaSearchButton();
        successPage.getFirstProduct().clickName();
        ProductInfoPage productPage = new ProductInfoPage(getDriver());
        Assert.assertTrue(productPage.getDescriptionText().contains(product.getName()));
    }
}
