package com.softserve.edu.opencart.tests.currency;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.data.currency.Currencies;
import com.softserve.edu.opencart.pages.user.common.shopping_cart.ShoppingCartPage;
import com.softserve.edu.opencart.pages.user.common.wishlist.WishListPage;

import com.softserve.edu.opencart.tests.LocalTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.softserve.edu.opencart.data.data_provider_repository.DataForCurrencyTest;
import com.softserve.edu.opencart.data.currency.CurrenciesSymbol;

import static com.softserve.edu.opencart.data.ProductRepository.getIPhone;
import static com.softserve.edu.opencart.data.ProductRepository.getMacBook;


public class CurrencyTest extends LocalTestRunner {

	//тест перевіряє чи зміниться валюта у вішлісті
	@Test(dataProvider = "currency", dataProviderClass = DataForCurrencyTest.class, priority = 2)
	public void changeCurrencyInWishList(IUser validUser) {
		// Steps
		WishListPage actual = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser)
				.gotoHomePage()
				.addProductToWishList(getMacBook())
				.gotoWishListPage()
				.chooseCurrency(Currencies.EURO);
		Assert.assertTrue(actual.getPriceText().contains(CurrenciesSymbol.EURO));
	}
	//тест перевіряє чи зміниться валюта у кошику
	@Test(dataProvider = "currency", dataProviderClass = DataForCurrencyTest.class, priority = 1)
	public void changeCurrencyInCart(IUser validUser) {
		ShoppingCartPage actual = loadApplication()
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getIPhone())
				.goToShoppingCartFromAlert()
				.chooseCurrency(Currencies.POUND_STERLING);
		Assert.assertTrue(actual.getSubTotalPriceText().contains(CurrenciesSymbol.POUND_STERLING));
	}
	//вибір валюти перед встановдення податку
	@Test(dataProvider = "currency", dataProviderClass = DataForCurrencyTest.class, priority = 3)
	public void checkIfCurrencyChengedInCartForTax(IUser validUser) {
		ShoppingCartPage actual = loadApplication()
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getIPhone())
				.goToShoppingCartFromAlert()
				.chooseCurrency(Currencies.US_DOLLAR)
				.goToShippingAndTaxesComponent()
				.selectCountryByName(validUser.getCountry())
				.selectRegionStateByName(validUser.getRegionState())
				.inputPostCode(validUser.getPostCode())
				.switchToSelectShippingMethodModalPage()
				.selectFlatShippingRate()
				.clickApplyShippingButton();
		Assert.assertTrue(actual.getTaxRateText().contains(CurrenciesSymbol.US_DOLLAR));
	}
	//вибір валюти після всьановдення податку(податок пропадає)
	@Test(dataProvider = "currency", dataProviderClass = DataForCurrencyTest.class, priority = 4)
	public void checkIfCurrencyChengedInCartForTaxAfterChange(IUser validUser){
		ShoppingCartPage actual = loadApplication()
				.gotoHomePage()
				.getProductComponentsContainer()
				.addProductToCartDirectly(getMacBook())
				.goToShoppingCartFromAlert()
				.goToShippingAndTaxesComponent()
				.selectCountryByName(validUser.getCountry())
				.selectRegionStateByName(validUser.getRegionState())
				.inputPostCode(validUser.getPostCode())
				.switchToSelectShippingMethodModalPage()
				.selectFlatShippingRate()
				.clickApplyShippingButton()
				.chooseCurrency(Currencies.EURO);
		Assert.assertTrue(actual.getTaxRateText().contains(CurrenciesSymbol.EURO));
	}
}
