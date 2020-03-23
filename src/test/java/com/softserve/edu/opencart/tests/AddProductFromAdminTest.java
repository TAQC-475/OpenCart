package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.MenuItems;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProductRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddProductFromAdminTest extends LocalAdminTestRunner {

    @DataProvider(name = "addRouterFromAdmin")
    public Object[][] ProductsData(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.router().getProductName(),
                        NewProductRepository.router().getMetaTagTitle(),
                        NewProductRepository.router().getModel(),
                        NewProductRepository.router().getPrice(),
                        NewProductRepository.router().getCategory()}
        };
    }

    @DataProvider(name = "dataAdmin")
    public Object[][] NewProductsData(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.cyrillicProduct().getProductName(),
                        NewProductRepository.cyrillicProduct().getMetaTagTitle(),
                        NewProductRepository.cyrillicProduct().getModel()}
        };
    }


    @Test(dataProvider = "addRouterFromAdmin")
    public void addRouter(IUser validAdmin,
                          String name,
                          String tagTitle,
                          String model,
                          String price,
                          String category) {

        loadSignInPage()
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
        ;

    }

    @Test(dataProvider = "dataAdmin",
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
}