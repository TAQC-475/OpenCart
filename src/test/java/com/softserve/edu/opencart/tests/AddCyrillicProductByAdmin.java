package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProduct;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProductRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCyrillicProductByAdmin extends LocalAdminTestRunner {
    // some staff here
//    @DataProvider
//    public Object[][] admins() {
//        return new Object[][] {
//                { UserRepository.get().getAdmin(),
//                NewProductRepository.cyrillicProduct().getProductName(),
//                NewProductRepository.cyrillicProduct().getMetaTagTitle(),
//                NewProductRepository.cyrillicProduct().getModel()}
//        };
//    }
//
//    @Test(dataProvider = "admins")
//    public void AddCyrillicProduct (IUser validAdmin,
//                                    NewProduct name,
//                                    NewProduct tagTitle,
//                                    NewProduct model) {
//        loadSigninPage()
//                .successfulLogin(validAdmin)
//                .gotoProductPage()
//                .gotoAddProductPage()
//                .typeName(name)
//                .typeTitle(tagTitle)
//                .clickDataButton()
//                .typeModel(model);
//
//        Boolean successTextIsDisplayed = getDriver().findElement(By.cssSelector(".container-fluid>.alert.alert-success")).isDisplayed();
//
//        Assert.assertTrue(successTextIsDisplayed);

    }