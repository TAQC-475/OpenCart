package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCategoryFromAdminTest extends LocalAdminTestRunner{

    @DataProvider // (parallel = true)
    public Object[][] correctUsers() {
        return new Object[][] {
                { UserRepository.get().getAdmin()},
        };
    }

    @Test(dataProvider = "correctUsers")
    public void addNewCategory(IUser validAdmin) throws InterruptedException {

        loadSignInPage()
                .successfulLogin(validAdmin)
                .gotoCategoriesPage()
                .gotoAddCategoryPage()
                .typeName("Routers")
                .typeTitle("test")
                .clickDataButton()
                .typeParent("test")
                .clickAddToTopMenu()
                .gotoModifiedCatalogPage()
                .getSuccessText();

        Thread.sleep(3000);
    }

}
