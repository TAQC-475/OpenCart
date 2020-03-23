package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.search.ProductInfoPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCriteriaTest extends SearchTestRunner {


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

    @Test(description = "Check Search in subcategories button")
    public void checkSubcategoriesButton()
    {
        SearchSuccessPage successPage=this.successPage();
        WebElement firstOption = successPage.getCriteriaCategory().getOptions().get(0);
        Assert.assertTrue(firstOption.isSelected());
        Assert.assertFalse(successPage.getCriteriaSubCategory().isEnabled());
        successPage.getCriteriaCategory().selectByIndex(1);

        Assert.assertTrue(successPage.getCriteriaSubCategory().isEnabled());
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
