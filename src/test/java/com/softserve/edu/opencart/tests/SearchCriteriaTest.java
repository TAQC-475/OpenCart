package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.data_provider_repository.DataForAdminTests;
import com.softserve.edu.opencart.pages.user.search.ProductInfoPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCriteriaTest extends SearchTestRunner {


    @Test(description = "Check if search fields have the same input")
    public void checkSearchFieldsInputValues() {
        String searchField  =
        successPage()
                .successfulSearch(ProductRepository.getSamsungProduct())
                .getCriteriaSearchFieldText();

        Assert.assertEquals(searchField, ProductRepository.getSamsungProduct().getName());
    }

    @Test(description = "Check if search button works correctly")
    public void checkSearchButton(){
        successPage()
                .successfulSearch(ProductRepository.getAllProducts())
                .searchNewProduct(ProductRepository.getMac());

        Assert.assertEquals(ProductRepository.getMac().getName(), successPage().getCriteriaSearchFieldText());
    }

    @Test(description = "Check Search in subcategories button")
    public void checkSubcategoriesButton()
    {
        SearchSuccessPage successPage=this.successPage();
        WebElement firstOption = successPage.getCriteriaCategory().getOptions().get(0);

        softAssert.assertTrue(firstOption.isSelected());
        softAssert.assertFalse(successPage.getCriteriaSubCategory().isEnabled());
        successPage.getCriteriaCategory().selectByIndex(1);

        softAssert.assertTrue(successPage.getCriteriaSubCategory().isEnabled());
        softAssert.assertAll();
    }

    @Test(description = "Search in category")
    public void checkingSearchingInCategories()
    {
        successPage()
                .searchNewProduct(ProductRepository.getMac())
                .chooseCategory(Categories.TABLETS.toString());

        Assert.assertTrue(unsuccessPage().getNoProductMessage().isDisplayed());
    }

    @Test(description = "Search in product descriptions")
    public void checkingSearchingInDescription() {
        ProductInfoPage productPage =
                successPage()
                        .searchNewProduct(ProductRepository.getProductWithDescription())
                        .clickCriteriaDescription()
                        .clickFirstProduct();

        Assert.assertTrue(productPage.getDescriptionText().contains(ProductRepository.getProductWithDescription().getName()));
    }

    @Test(dataProvider = "DataForCyrillicProductTests", dataProviderClass = DataForAdminTests.class)
    public void searchCyrillicProductWithCategory(Product cyrillicProduct) {
        String actual = successPage()
                .searchNewProduct(cyrillicProduct)
                .chooseCategory(Categories.COMPONENTS.toString())
                .getFirstProduct()
                .getNameText();

        Assert.assertEquals(actual, cyrillicProduct.getName());
    }
}
