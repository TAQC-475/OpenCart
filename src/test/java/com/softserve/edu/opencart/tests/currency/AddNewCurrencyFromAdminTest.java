package com.softserve.edu.opencart.tests.currency;
import com.softserve.edu.opencart.data.currency.ICurrency;
import com.softserve.edu.opencart.tests.admin.LocalAdminTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;

public class AddNewCurrencyFromAdminTest extends LocalAdminTestRunner {

	@Test(dataProvider = "adminAddCurrency")
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
