package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.user.HomePage;

public class CurrencyTest extends EpizyUserTestRunner {
	@DataProvider
	public Object[][] currency() {
		return new Object[][]{
				{UserRepository.get().getHahaha()},
		};
	}

	@Test(dataProvider = "currency")
	public void checkChangeCurrency(IUser validUser) throws Exception {
		// Steps
		String actual = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser)
				.gotoHomePage()
				.chooseCurrency(Currencies.EURO)
				.getProductComponentsContainer()
				.getProductComponentPriceByName("MacBook");
				Thread.sleep(3000);

//		Assert.assertTrue(actual.contains());
	}
}


//				.chooseCurrency(Currencies.POUND_STERLING);
//		Thread.sleep(1000); // For Presentation Only
//		//
//		// Check
//		System.out.println("Actual: " + homepage.getCurrencyText());
//		System.out.println("Expected: " + Currencies.POUND_STERLING.toString());
//		//Assert.assertTrue("Currency Error",
//		//		homepage.getCurrencyText().contains(Currencies.POUND_STERLING.toString()));
//		Thread.sleep(2000); // For Presentation Only
//	}
//}