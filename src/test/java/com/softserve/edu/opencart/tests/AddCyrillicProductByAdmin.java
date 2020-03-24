package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creation_product_admin_panel.NewProductRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCyrillicProductByAdmin extends LocalAdminTestRunner {

    @DataProvider
    public Object[][] dataAdmin() {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.cyrillicProduct().getProductName(),
                        NewProductRepository.cyrillicProduct().getMetaTagTitle(),
                        NewProductRepository.cyrillicProduct().getModel()}
        };
    }

    @Test(dataProvider = "dataAdmin")
    public void AddCyrillicProduct(IUser validAdmin,
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
////
//        Boolean successTextIsDisplayed = getDriver().findElement(By.cssSelector(".container-fluid>.alert.alert-success")).isDisplayed();
//
//        Assert.assertTrue(successTextIsDisplayed);

    }
}