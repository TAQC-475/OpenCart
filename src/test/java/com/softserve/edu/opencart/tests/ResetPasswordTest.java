package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.SuccessfulUpdatePasswordLoginPage;
import com.softserve.edu.opencart.tools.PropertiesUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResetPasswordTest extends LocalTestRunner {
    @DataProvider(name = "emailClientDataProvider")
    public Object[][] getEmailClient(){
        return new Object[][] {{
                UserRepository.get().getFakeVasyl()
                , EmailUserRepository.getVasyl()
                , EmailRepository.getOpencartResetEmail()}};

    }

    @Test(priority = 2, dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(IUser user, EmailUser emailUser, ResetEmailEntity resetEmail ){
        SuccessfulUpdatePasswordLoginPage loginPage = loadApplication()
                .gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser)
                .gotoResetPasswordEmail(resetEmail)
                .goToChangePasswordPage(resetEmail)
                .resetPassword(user);

        assertEquals(loginPage.getAlertText(), SuccessfulUpdatePasswordLoginPage.EXPECTED_UPDATE_MESSAGE);

        loginPage.successfulLogin(user);

        assertTrue(ApplicationStatus.get().isLogged());
    }

    @AfterMethod
    public void updateProperty(ITestResult result){
        Object[] inputArgs = result.getParameters();
        IUser fakeVasyl = (IUser) inputArgs[0];

        PropertiesUtils.getInstance().setPropertiesValue("./config.properties",
                "VASYLS_PASSWORD", fakeVasyl.getPassword());
    }
}
