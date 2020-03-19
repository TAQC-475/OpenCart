package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends EpizyUserTestRunner{
    @DataProvider(name = "emailClientDataProvider")
    public Object[][] getEmailClient(){
        EmailUser emailUser = EmailUserRepository.getVasyl();
        IUser user = UserRepository.get().getVasyl();
        ResetEmailEntity resetEmail = ResetEmailRepository.getOpencartResetEmail();
        Object[][] users = {{emailUser, resetEmail, user}};
        return users;
    }

    @Test(dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(EmailUser emailUser, ResetEmailEntity resetEmail, IUser user){
        LoginPage loginPageAfterReset = loadApplication().gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser)
                .gotoResetPasswordEmail(resetEmail)
                .goToChangePasswordPage(resetEmail)
                .resetPassword(user);
        assertEquals(loginPageAfterReset.getAlertText(), "");
    }
}
