package com.softserve.edu.opencart.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import org.testng.annotations.Parameters;

import java.util.Map;

public abstract class LocalAdminTestRunner extends EpizyUserTestRunner {
	private String adminServerUrl;

	@Parameters({"adminUrl"})
	@BeforeMethod
	public void beforeClass(ITestContext context, String adminUrl) {

		for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
			System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
			if (entry.getKey().toLowerCase().equals("adminurl")) {
				adminUrl = entry.getValue();
			}
		}
		adminServerUrl=adminUrl;
		WebDriverManager.chromedriver().setup();
		getDriver().manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		getDriver().get(adminServerUrl);
	}

	public SigninPage loadSigninPage() {
		System.out.println(getDriver());
		return new SigninPage(getDriver());
	}

}
