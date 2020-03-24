package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;
import com.softserve.edu.opencart.pages.user.common.TopPart;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import com.softserve.edu.opencart.pages.user.common.wishlist.WishListPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.user.HomePage;

import static com.softserve.edu.opencart.data.ProductRepository.getIPhone;
import static com.softserve.edu.opencart.data.ProductRepository.getMacBook;


public class CurrencyTest extends LocalTestRunner {
	final String SYMBOL_DOLAR = "$";
	final String SYMBOL_EURO = "€";

	@DataProvider
	public Object[][] currencyWishList() {
		return new Object[][]{
				{UserRepository.get().getHahaha()},
		};
	}
	@DataProvider
	public Object[][] currencyCart() {
		return new Object[][]{
				{UserRepository.get().getHahaha()},
		};
	}

	@Test(dataProvider = "currencyWishList")
	public void changeCurrencyInWishList(IUser validUser) {
		// Steps
		WishListPage actual = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser)
				.gotoHomePage()
				.addProductToWishList(getMacBook())
				.gotoWishListPage()
				.chooseCurrency(Currencies.EURO);
		Assert.assertTrue(actual.getPriceText().contains(SYMBOL_EURO));
	}

	@Test(dataProvider = "currencyCart")
	public void changeCurrencyInCart(IUser validUser) throws InterruptedException {
		ShoppingCartPage actual = loadApplication()
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getIPhone())
				.goToShoppingCartFromAlert();
	}



}
