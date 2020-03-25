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
	final String POUND_STERLING = "£";

	@DataProvider
	public Object[][] currency() {
		return new Object[][]{
				{UserRepository.get().getShoppingCartUser()},
		};
	}

	//тест перевіряє чи зміниться валюта у вішлісті
	@Test(dataProvider = "currency")
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
	//тест перевіряє чи зміниться валюта у кошику
	@Test(dataProvider = "currency")
	public void changeCurrencyInCart(IUser validUser) {
		ShoppingCartPage actual = loadApplication()
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getIPhone())
				.goToShoppingCartFromAlert()
				.chooseCurrency(Currencies.POUND_STERLING);
		Assert.assertTrue(actual.getSubTotalPriceText().contains(POUND_STERLING));
	}
	//вибір валюти перед встановдення податку
	@Test(dataProvider = "currency")
	public void checkIfCurrencyChengedInCartForTax(IUser validUser) throws InterruptedException {
		ShoppingCartPage actual = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser)
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getIPhone())
				.goToShoppingCartFromAlert()
				.chooseCurrency(Currencies.EURO)
				.goToShippingAndTaxesComponent()
				.selectCountryByName(validUser.getCountry())
				.selectRegionStateByName(validUser.getRegionState())
				.inputPostCode(validUser.getPostCode())
				.switchToSelectShippingMethodPage()
				.selectFlatShippingRate()
				.clickApplyShippingButton();
		Thread.sleep(2000);
		Assert.assertTrue(actual.getTaxRateText().contains(SYMBOL_EURO));
	}
	//вибір валюти після всьановдення податку(податок пропадає)
	@Test(dataProvider = "currency")
	public void checkIfCurrencyChengedInCartForTaxAfterChange(IUser validUser) throws InterruptedException {
		ShoppingCartPage actual = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser)
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getIPhone())
				.goToShoppingCartFromAlert()
				.goToShippingAndTaxesComponent()
				.selectCountryByName(validUser.getCountry())
				.selectRegionStateByName(validUser.getRegionState())
				.inputPostCode(validUser.getPostCode())
				.switchToSelectShippingMethodPage()
				.selectFlatShippingRate()
				.clickApplyShippingButton()
				.chooseCurrency(Currencies.EURO);
		Thread.sleep(2000);
		Assert.assertTrue(actual.getTaxRateText().contains(SYMBOL_EURO));
	}





}
