package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class SearchTestRunner extends EpizyUserTestRunner {
    SoftAssert softAssert = new SoftAssert();
    private Product searchProduct;

    public SearchTestRunner()
    {
        searchProduct = ProductRepository.getAllProducts();
    }

    public Product getSearchProduct() {
        return searchProduct;
    }

    public void setSearchProduct(Product searchProduct) {
        this.searchProduct = searchProduct;
    }

    @BeforeMethod()
    public void searchInput() {
        loadApplication()
                .successfulSearch(searchProduct);
    }

    public SearchSuccessPage successPage() {
        return new SearchSuccessPage(getDriver());
    }
}