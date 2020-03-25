package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.tools.DataBaseUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class LoginInvalidTest extends LocalTestRunner{
    @DataProvider(name = "invalidUserDataProvider")
    public Object[][] invalidUsers() {
        return new Object[][] {
                { UserRepository.get().getInvalid() },
        };
    }

    @BeforeMethod
    public void beforeMethodInvalidUser() {
        DataBaseUtils.setLoginedUsersToNull();
    }


    @Test(priority = 3, dataProvider = "invalidUserDataProvider", groups = {"customer_login_clear"})
    public void unsuccessfulLoginTest(IUser invalidUser){
        UnsuccessfulLoginPage loginPage = loadApplication()
                .gotoLoginPage()
                .unsuccessfulLogin(invalidUser);

        assertTrue(loginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE));
    }

    @Test( priority = 4, dataProvider = "invalidUserDataProvider")
    public void blockLoginTest(IUser invalidUser){
        UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
                .gotoLoginPage()
                .unsuccessfulLogin(invalidUser)
                .unsuccessfulLogin(invalidUser)
                .unsuccessfulLogin(invalidUser)
                .unsuccessfulLogin(invalidUser)
                .unsuccessfulLogin(invalidUser)
                .unsuccessfulLogin(invalidUser);

        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOCK_MESSAGE));
    }

    @AfterMethod
    public void afterMethodInvalidUser(ITestResult result){
        Object[] inputArgs = result.getParameters();
        IUser invalidUser = (IUser) inputArgs[0];
        DataBaseUtils.clearLoginedUsers(invalidUser);
    }

    @AfterClass
    public void closeDataBaseConnection(){
        DataBaseUtils.closeConnection();
    }

}
