package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.MenuItems;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProductRepository;
import com.softserve.edu.opencart.data.dataproviderrepository.DataForAdminTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddProductFromAdminTest extends LocalAdminTestRunner {

    @Test(dataProvider = "addRouterFromAdmin", dataProviderClass = DataForAdminTests.class)
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
}