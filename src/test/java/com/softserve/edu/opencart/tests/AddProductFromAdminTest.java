package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProductRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddProductFromAdminTest extends LocalAdminTestRunner {

    @DataProvider(name = "dataAdmin")
    public Object[][] NewProductsData(Method method) {
        String testCase = method.getName();
        if ("addNewProduct".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getAdmin(),
                            NewProductRepository.router().getProductName(),
                            NewProductRepository.router().getMetaTagTitle(),
                            NewProductRepository.router().getModel()}
            };
        } else {
            return new Object[][]{{
                    UserRepository.get().getAdmin(),
                    NewProductRepository.cyrillicProduct().getProductName(),
                    NewProductRepository.cyrillicProduct().getMetaTagTitle(),
                    NewProductRepository.cyrillicProduct().getModel()}
            };
        }
    }


    @Test(dataProvider = "dataAdmin")
    public void addNewProduct(IUser validAdmin,
                              String name,
                              String tagTitle,
                              String model) {
        String actual =
                loadSignInPage()
                        .successfulLogin(validAdmin)
                        .gotoProductPage()
                        .gotoAddProductPage()
                        .typeName(name)
                        .typeTitle(tagTitle)
                        .clickDataButton()
                        .typeModel(model)
                        .gotoModifiedCategoriesPage()
                        .getSuccessText();
        System.out.println(actual);
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