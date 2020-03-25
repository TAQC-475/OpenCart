package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;

public abstract class SearchTestRunner extends LocalTestRunner {
    private Product searchProduct;

    public SearchTestRunner() {
        searchProduct = ProductRepository.getAllProducts();
    }

    public Product getSearchProduct() {
        return searchProduct;
    }

    public void setSearchProduct(Product searchProduct) {
        this.searchProduct = searchProduct;
    }

    public SearchSuccessPage successPage() {
        return new SearchSuccessPage(getDriver());
    }

    public SearchUnsuccessPage unsuccessPage() {
        return new SearchUnsuccessPage(getDriver());
    }
}