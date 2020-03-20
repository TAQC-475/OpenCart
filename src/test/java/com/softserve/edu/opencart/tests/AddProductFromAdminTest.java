package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddProductFromAdminTest extends LocalAdminTestRunner{

    @DataProvider
    public Object[][] correctUsers() {
        return new Object[][] {
                {UserRepository.get().getAdmin() },
        };
    }

    @Test(dataProvider = "correctUsers")
    public void addNewProduct(IUser validAdmin)  {
        String actual =
                loadSigninPage()
                        .successfulLogin(validAdmin)
                        .gotoProductPage()
                        .gotoAddProductPage()
                        .typeName(ProductRepository.getTVkivi40().getName())
                        .typeTitle("test")
                        .clickDataButton()
                        .typeModel("test")
                        .gotoModifiedCategoriesPage()
                        .getSuccessText();
        System.out.println(actual);

    }
}
