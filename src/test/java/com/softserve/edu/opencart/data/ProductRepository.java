package com.softserve.edu.opencart.data;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public final class ProductRepository {

	private ProductRepository() {
	}

	public static Product getDefault() {
		return getMacBook();
	}

	public static Product getMacBook() {
		return new Product("MacBook",
				"Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..", "500.00")
						.addPrice(Currencies.EURO, "472.33")
						.addPrice(Currencies.POUND_STERLING, "368.73")
						.addPrice(Currencies.US_DOLLAR, "602.00");
	}

	public static Product getMacBookForShoppingCart() {
		return new Product("MacBook",
				"Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..", "500.00", "2")
				.addPrice(Currencies.EURO, "472.33")
				.addPrice(Currencies.POUND_STERLING, "368.73")
				.addPrice(Currencies.US_DOLLAR, "602.00");
	}

	public static Product getIPhone() {
		return new Product("iPhone",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..", "101.00")
						.addPrice(Currencies.EURO, "96.66")
						.addPrice(Currencies.POUND_STERLING, "75.46")
						.addPrice(Currencies.US_DOLLAR, "123.20");
	}

	public static Product getIPhoneForShoppingCart() {
		return new Product("iPhone",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..", "101.00", "3")
				.addPrice(Currencies.EURO, "96.66")
				.addPrice(Currencies.POUND_STERLING, "75.46")
				.addPrice(Currencies.US_DOLLAR, "123.20");
	}

	public static Product getAppleCinema30() {
		return new Product("Apple Cinema 30\"",
				"The 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution. Designed sp..", "90.00")
				.addPrice(Currencies.EURO, "86.31")
				.addPrice(Currencies.POUND_STERLING, "67.38")
				.addPrice(Currencies.US_DOLLAR, "110.00");
	}

	public static Product getIPodClassic(){
		return new Product("iPod Classic",
				"More room to move. With 80GB or 160GB of storage and up to 40 hours of battery l..","100.00")
				.addPrice(Currencies.EURO,"95.72")
				.addPrice(Currencies.POUND_STERLING,"74.73")
				.addPrice(Currencies.US_DOLLAR,"122.00");
	}

	public static Product getMac(){
		return new Product("Mac");
	}

	public static Product getAllProducts(){
		return new Product("%");
	}

	public static Product getInvalid() {
		return new Product("Bok", "Intel", "100");
	}

}
