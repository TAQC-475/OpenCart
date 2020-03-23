package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulUpdatePasswordLoginPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends LocalTestRunner {
    @DataProvider(name = "emailClientDataProvider")
    public Object[][] getEmailClient(){
        return new Object[][] {{
                EmailUserRepository.getVasyl()
                , ResetEmailRepository.getOpencartResetEmail()
                , UserRepository.get().getVasyl()}};

    }

    @DataProvider(name = "validUserDataProvider")
    public Object[] getValidUser(){
        return new Object[]{UserRepository.get().getDefault()};
    }

    @DataProvider(name = "invalidUserDataProvider")
    public Object[][] invalidUsers() {
        return new Object[][] {
                { UserRepository.get().getInvalid() },
        };
    }

    @Test(priority = 3, dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(EmailUser emailUser, ResetEmailEntity resetEmail, IUser user){
        SuccessfulUpdatePasswordLoginPage loginPage = loadApplication()
                .gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser)
                .gotoResetPasswordEmail(resetEmail)
                .goToChangePasswordPage(resetEmail)
                .resetPassword(user);

        assertEquals(loginPage.getAlertText(), loginPage.EXPECTED_UPDATE_MESSAGE);
    }

    @Test(priority = 1, dataProvider = "validUserDataProvider")
    public void successfulLoginTest(IUser validUser){
        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);

        assertTrue(ApplicationStatus.get().isLogged());
    }

    @Test(priority = 2, dataProvider = "invalidUserDataProvider")
    public void unsuccessfulLoginTest(IUser invalidUser){
        UnsuccessfulLoginPage loginPage = loadApplication()
                .gotoLoginPage()
                .unsuccessfulLoginPage(invalidUser);

        assertFalse(ApplicationStatus.get().isLogged());
        assertTrue(loginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE));
    }




}
