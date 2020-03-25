package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.data_provider_repository.DataForAdminTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductFromAdminTest extends LocalAdminTestRunner {

    @Test(dataProvider = "addRouterProduct", dataProviderClass = DataForAdminTests.class, priority = 2)
    public void addRouter(IUser validAdmin,
                          String name,
                          String tagTitle,
                          String model,
                          String price,
                          String category) {

        String expectedProduct = loadSignInPage()
                .successfulLogin(validAdmin)
                .gotoProductPage()
                .gotoAddProductPage()
                .typeName(name)
                .typeTitle(tagTitle)
                .clickDataButton()
                .typeModel(model)
                .typePrice(price)
                .clickLinkButton()
                .typeCategory(category)
                .clickCategoryDropdown()
                .gotoModifiedCategoriesPage()
                .gotoHomePage()
                .gotoMainMenuComponent()
                .chooseCategory(Categories.ROUTERS)
                .checkFirstProduct();

        Assert.assertEquals(expectedProduct,name);
    }

    @Test(dataProvider = "addRoutersCategory",  dataProviderClass = DataForAdminTests.class, priority = 1)
    public void addNewCategory(IUser validAdmin, String name, String title, String parent){

        loadSignInPage()
                .successfulLogin(validAdmin)
                .gotoCategoriesPage()
                .gotoAddCategoryPage()
                .typeName(name)
                .typeTitle(title)
                .clickDataButton()
                .typeParent(parent)
                .clickAddToTopMenu()
                .gotoModifiedCatalogPage()
                .getSuccessText();

//        Thread.sleep(3000);
    }
}