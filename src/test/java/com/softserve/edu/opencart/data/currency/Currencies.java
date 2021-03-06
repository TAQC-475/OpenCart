package com.softserve.edu.opencart.data.currency;

public enum Currencies {
	EURO("Euro"),
	POUND_STERLING("Pound Sterling"),
	US_DOLLAR("US Dollar"),
	UA_HRYVNIA("Hryvnia");

	//
	private String name;

	private Currencies(String name) {

		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
