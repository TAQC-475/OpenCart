package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCyrrilicProductByAdmin extends LocalAdminTestRunner {
    private String adminServerUrl = "http://192.168.132.128/opencart/upload/admin";
    // some staff here
    @DataProvider//(parallel = true)
    public Object[][] admins() {
        return new Object[][] {
                { UserRepository.get().getAdmin() }
        };
    }

    @Test(dataProvider = "admins")
    public void AddCyrillicProduct (IUser validAdmin) throws InterruptedException {
        loadSigninPage()
                .successfulLogin(validAdmin)
                .gotoProductPage()
                .gotoAddProductPage()
                .typeName("Самсунг")
                .typeTitle("Самсунг")
                .clickDataButton()
                .typeModel("Самсунг")
                ;

        Boolean successTextIsDisplayed = getDriver().findElement(By.cssSelector(".container-fluid>.alert.alert-success")).isDisplayed();

        Assert.assertTrue(successTextIsDisplayed);

    }
}
