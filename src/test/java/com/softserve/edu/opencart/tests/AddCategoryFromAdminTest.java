package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.categories.MenuCategoryRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddCategoryFromAdminTest extends LocalAdminTestRunner{

    @DataProvider(name = "addRoutersFromAdmin")
    public Object[][] ProductsData(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        MenuCategoryRepository.routers().getName(),
                        MenuCategoryRepository.routers().getTitle(),
                        MenuCategoryRepository.routers().getParent()}
        };
    }

    @Test(dataProvider = "addRoutersFromAdmin")
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
