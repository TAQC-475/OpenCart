package com.softserve.edu.opencart.tests.admin;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.data_provider_repository.DataForAdminTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCyrillicProductByAdmin extends LocalAdminTestRunner {

    @Test(dataProvider = "DataForCyrillicProductTests", dataProviderClass = DataForAdminTests.class,
            description = "This test verifies adding new product on cyrillic")
    public void addCyrillicProduct(IUser validAdmin,
                                   String name,
                                   String tagTitle,
                                   String model,
                                   String category) {
        loadSignInPage()
                .successfulLogin(validAdmin)
                .gotoProductPage()
                .gotoAddProductPage()
                .typeName(name)
                .typeTitle(tagTitle)
                .clickDataButton()
                .typeModel(model)
                .clickLinkButton()
                .typeCategory(category)
                .gotoModifiedCategoriesPage();

        Assert.assertTrue(modifiedCatalogPage().isSuccessTextDisplayed());
    }
}