package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.EmailUser;
import com.softserve.edu.opencart.data.EmailUserRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends EpizyUserTestRunner{
    @DataProvider(name = "emailClientDataProvider")
    public Object[][] getEmailClient(){
        Object[][] users = {{EmailUserRepository.getVasyl()}};
        return users;
    }

    @Test(dataProvider = "emailClientDataProvider")
    public void resetPasswordTest(EmailUser emailUser){
        loadApplication().gotoLoginPage()
                .gotoForgottenPasswordRight()
                .requestResetEmail(emailUser)
                .login(emailUser);
    }
}
