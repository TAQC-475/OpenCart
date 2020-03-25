package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creation_product_admin_panel.NewProductRepository;
import com.softserve.edu.opencart.data.data_provider_repository.DataForAdminTests;
import com.softserve.edu.opencart.pages.admin.account.catalog.ModifiedCatalogPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCyrillicProductByAdmin extends LocalAdminTestRunner {

    @Test(dataProvider = "DataForCyrillicProductTests", dataProviderClass = DataForAdminTests.class,
            description = "This test verifies adding new product on cyrillic")
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
                .typeModel(model)
                .gotoModifiedCategoriesPage();

        Assert.assertTrue(modifiedCatalogPage().isSuccessTextDisplayed());
    }
}