package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.ProductInfoPage;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaTest extends SearchTestRunner{

    public SearchCriteriaTest() {
        this.setSearchProduct(ProductRepository.getProductWithProcessor());
    }

@Test(description = "Search in product descriptions")
public void checkingSearchingInDescription()
{
    SearchSuccessPage successPage = this.successPage();
    getDriver().findElement(By.cssSelector(".checkbox-inline #description")).click();
//    successPage.clickCriteriaDescription();
//    successPage.clickCriteriaSearchButton();

//    ProductsDisplayComponent displayProduct = successPage.getProductsDisplay();
//    List<ProductComponent> productComponents = displayProduct.getProductComponents();

//    ArrayList<ProductComponent> productComponents = new ArrayList<>();
//    for (WebElement current : getDriver().findElements(By.cssSelector(".product-layout"))) {
//        productComponents.add(new ProductComponent(current));
//    }
//
//    String productName = productComponents.get(0).getNameText();
//
//    ProductInfoPage productPage = successPage.gotoProductInfo(new Product(productName));
//    Assert.assertTrue(productPage.getDescriptionText().contains(this.getSearchProduct().getName()));
}
}
