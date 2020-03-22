package com.softserve.edu.opencart.tests;

import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import org.testng.annotations.Parameters;

public abstract class LocalAdminTestRunner extends EpizyUserTestRunner {

	@Parameters({"adminServerUrl"})
	@BeforeMethod
	public void beforeMethod(String adminServerUrl) {
		//driver.get(adminServerUrl);
		getDriver().get(adminServerUrl);
	}

	public SigninPage loadSigninPage() {
		//return new SigninPage(driver);
		return new SigninPage(getDriver());
	}

}
