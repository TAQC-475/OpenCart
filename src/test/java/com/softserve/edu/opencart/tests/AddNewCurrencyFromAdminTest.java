package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.ICurrency;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;

import java.lang.reflect.Method;

public class AddNewCurrencyFromAdminTest extends LocalAdminTestRunner {

	@DataProvider//(parallel = true)
	public Object[][] adminAddCurrency(Method method) {
		return new Object[][] {
			{ UserRepository.get().getAdmin(), CurrencyRepository.get().getUACurrency()},
		};
	}

	@Test(dataProvider = "adminAddCurrency")
	public void checkSuccessful(IUser validAdmin, ICurrency currency) throws Exception {
		CurrenciesPage currenciesPage = loadSignInPage()
				.successfulLogin(validAdmin)
				.gotoCurrencyPage()
				.goToAddNewCurrecyPage()
				.addNewCurrency(currency);
		Assert.assertTrue(currenciesPage.getCurrencyHryvniaText().toLowerCase()
				.contains(CurrenciesPage.CURRENCY_UAH.toLowerCase()));
	}
	
}
