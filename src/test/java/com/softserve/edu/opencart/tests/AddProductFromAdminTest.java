package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.MenuItems;
import com.softserve.edu.opencart.data.dataproviderrepository.DataForAdminTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductFromAdminTest extends LocalAdminTestRunner {

    @Test(dataProvider = "dataAdmin", dataProviderClass = DataForAdminTests.class,
            description = "This test verifies adding new product on cyrillic")
    public void addCyrillicProduct(IUser validAdmin,
                                   String name,
                                   String tagTitle,
                                   String model) {

        loadSignInPage()
                .successfulLogin(validAdmin)
                .gotoProductPage()
                .gotoAddProductPage()
                .typeName(name)
                .typeTitle(tagTitle)
                .clickDataButton()
                .typeModel(model);
    }

    @Test(dataProvider = "addRouterProduct", dataProviderClass = DataForAdminTests.class)
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
                .getMainMenuComponent()
                .chooseCategory(MenuItems.ROUTERS)
                .checkFirstProduct();

        Assert.assertEquals(expectedProduct,name);
    }

    @Test(dataProvider = "addRoutersCategory",  dataProviderClass = DataForAdminTests.class)
    public void addNewCategory(IUser validAdmin, String name, String title, String parent) throws InterruptedException {

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

        Thread.sleep(3000);
    }
}