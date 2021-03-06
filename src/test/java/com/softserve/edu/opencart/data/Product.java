package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.data.currency.Currencies;

import java.util.HashMap;
import java.util.Map;

public class Product {

	private String name;
	private String description;
	private String priceDollarExTax;
	private String quantity;
	// TODO
	// private Map<Currencies, Decimal> prices;
	private Map<Currencies, String> prices;

	public Product(String name, String description, String priceDollarExTax) {
		this.name = name;
		this.description = description;
		this.priceDollarExTax = priceDollarExTax;
		prices = new HashMap<Currencies, String>();
		this.quantity = "1";
	}

	public Product(String name, String description, String priceDollarExTax, String quantity) {
		this.name = name;
		this.description = description;
		this.priceDollarExTax = priceDollarExTax;
		prices = new HashMap<Currencies, String>();
		this.quantity = quantity;
	}

	public Product(String name) {
		this.name = name;
	}

	// setters

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriceDollarExTax(String priceDollarExTax) {
		this.priceDollarExTax = priceDollarExTax;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Product addPrice(Currencies currency, String price) {
		prices.put(currency, price);
		return this;
	}

	// getters

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPriceDollarExTax() {
		return priceDollarExTax;
	}

	public String getPrice(Currencies currency) {
		return prices.get(currency);
	}

	public String getQuantity() {
		return quantity;
	}
}