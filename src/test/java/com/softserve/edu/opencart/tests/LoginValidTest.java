package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulUpdatePasswordLoginPage;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginValidTest extends LocalTestRunner {
    @DataProvider(name = "emailClientDataProvider")
    public Object[][] getEmailClient(){
        return new Object[][] {{
                 UserRepository.get().getVasyl()
                ,EmailUserRepository.getVasyl()
                , EmailRepository.getOpencartResetEmail()}};

    }

    @DataProvider(name = "validUserDataProvider")
    public Object[] getValidUser(){
        return new Object[]{UserRepository.get().getDefault()};
    }

    @Test(priority = 3, dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(IUser user, EmailUser emailUser, ResetEmailEntity resetEmail ){
        SuccessfulUpdatePasswordLoginPage loginPage = loadApplication()
                .gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser)
                .gotoResetPasswordEmail(resetEmail)
                .goToChangePasswordPage(resetEmail)
                .resetPassword(user);

        assertEquals(loginPage.getAlertText(), loginPage.EXPECTED_UPDATE_MESSAGE);

        loginPage.successfulLogin(user);

        assertTrue(ApplicationStatus.get().isLogged());
    }

    @Test(priority = 1, dataProvider = "validUserDataProvider")
    public void successfulLoginTest(IUser validUser){
        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);

        assertTrue(ApplicationStatus.get().isLogged());
    }






}
