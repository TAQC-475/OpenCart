package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;
import com.softserve.edu.opencart.pages.user.common.TopPart;
import com.softserve.edu.opencart.pages.user.common.wishlist.WishListPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.user.HomePage;

import static com.softserve.edu.opencart.data.ProductRepository.getMacBook;


public class CurrencyTest extends LocalTestRunner {
	final String SYMBOL_DOLAR = "$";
	final String SYMBOL_EURO = "€";

	@DataProvider
	public Object[][] currency() {
		return new Object[][]{
				{UserRepository.get().getHahaha()},
		};
	}

	@Test(dataProvider = "currency")
	public void checkChangeCurrency(IUser validUser) throws Exception {
		// Steps
		WishListPage actual = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser)
				.gotoHomePage()
				.addProductToWishList(getMacBook())
				.gotoWishListPage()
				.chooseCurrency(Currencies.EURO);
		Thread.sleep(2000);
		Assert.assertTrue(actual.getPriceText().contains(SYMBOL_EURO));

				Thread.sleep(3000);

//		Assert.assertTrue(actual.contains());
	}
}
