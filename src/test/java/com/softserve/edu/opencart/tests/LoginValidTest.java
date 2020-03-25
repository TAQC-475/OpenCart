package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulUpdatePasswordLoginPage;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginValidTest extends LocalTestRunner {


    @DataProvider(name = "validUserDataProvider")
    public Object[] getValidUser(){
        return new Object[]{UserRepository.get().getDefault()};
    }


    @Test(priority = 1, dataProvider = "validUserDataProvider")
    public void successfulLoginTest(IUser validUser){
        MyAccountPage myAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser);

        assertTrue(ApplicationStatus.get().isLogged());
    }
}
