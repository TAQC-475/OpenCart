package com.softserve.edu.opencart.tests.currency;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.currency.CurrencyRepository;
import com.softserve.edu.opencart.data.currency.ICurrency;
import com.softserve.edu.opencart.tests.admin.LocalAdminTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;
import com.softserve.edu.opencart.data.data_provider_repository.DataForCurrencyTest;

public class AddNewCurrencyFromAdminTest extends LocalAdminTestRunner {

	@Test(dataProvider = "adminCurrency", dataProviderClass = DataForCurrencyTest.class)
	public void checkSuccessful(IUser validAdmin, ICurrency currency){
		CurrenciesPage currenciesPage = loadSignInPage()
				.successfulLogin(validAdmin)
				.gotoCurrencyPage()
				.goToAddNewCurrecyPage()
				.addNewCurrency(currency);
		Assert.assertTrue(currenciesPage.getCurrencyHryvniaText().toLowerCase()
				.contains(CurrenciesPage.CURRENCY_UAH.toLowerCase()));
	}
	
}
