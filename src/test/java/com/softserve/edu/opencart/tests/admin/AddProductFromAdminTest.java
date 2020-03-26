package com.softserve.edu.opencart.tests.admin;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.data_provider_repository.DataForAdminTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductFromAdminTest extends LocalAdminTestRunner {

    /**
     * loading application, logging to admin page, clicking on add new category, typing info about the category,
     * clicking on save button and verifying that the product is created by getting the right alert message
     *
     * @param validAdmin testUser from UserRepository
     * @param name product form MenuCategoryRepository
     * @param title product form MenuCategoryRepository
     * @param parent testUser from MenuCategoryRepository
     */
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
    }

    /**
     * loading application, logging to admin page, clicking on add new product, typing info about the product,
     * clicking on save button and to the User homepage and verifying that the product is present
     *
     * @param validAdmin Admin from UserRepository
     * @param name       product form NewProductRepository
     * @param tagTitle   product form NewProductRepository
     * @param model      testUser from NewProductRepository
     * @param price      product form NewProductRepository
     * @param category   product form NewProductRepository
     */
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
}