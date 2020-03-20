package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.LoginPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends EpizyUserTestRunner{
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

    @Test(priority = 3, dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(EmailUser emailUser, ResetEmailEntity resetEmail, IUser user){
        LoginPage loginPageAfterReset = loadApplication()
                .gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser)
                .gotoResetPasswordEmail(resetEmail)
                .goToChangePasswordPage(resetEmail)
                .resetPassword(user);

        assertEquals(loginPageAfterReset.getAlertText(), AlertMessagesRepository.getUpdatePasswordSuccess());
    }

    @Test(priority = 1, dataProvider = "validUserDataProvider")
    public void successfulLoginTest(IUser validUser){
        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);

        assertTrue(ApplicationStatus.get().isLogged());
    }


}
