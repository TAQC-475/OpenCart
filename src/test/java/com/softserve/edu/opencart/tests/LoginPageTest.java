package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.EmailUser;
import com.softserve.edu.opencart.data.EmailUserRepository;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends EpizyUserTestRunner{
    @DataProvider(name = "emailClientDataProvider")
    public Object[][] getEmailClient(){
        EmailUser emailUser = EmailUserRepository.getVasyl();
        IUser user = UserRepository.get().getVasyl();
        Object[][] users = {{emailUser, user}};
        return users;
    }

    @Test(dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(EmailUser emailUser, IUser user){
        LoginPage loginPageAfterReset = loadApplication().gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser)
                .goToResetPasswordEmail()
                .goToResetPasswordPage()
                .resetPassword(user);

    }
}
