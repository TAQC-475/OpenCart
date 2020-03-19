package com.softserve.edu.opencart.data;

import java.util.List;

import com.softserve.edu.opencart.tools.CSVReader;
import com.softserve.edu.opencart.tools.ExcelReader;

public final class UserRepository {
	private static volatile UserRepository instance = null;
	
	private UserRepository() {
	}

	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}
	
	public IUser getDefault() {
		return getHahaha();
	}
	
	public IUser getHahaha() {
//		return new User("hahaha@gmail.com", "hahaha",
//				System.getenv().get("MY_PASSWORD"));
		return User.get()
				.setFirstName("hahaha")
				.setLastName("hahaha")
				.setEmail("hahaha@gmail.com")
				.setTelephone("telephone_5")
				.setAddress1("address1_5")
				.setCity("city_5")
				.setPostCode("postCode_5")
				.setCountry("country_5")
				.setRegionState("regionState_5")
				.setPassword(System.getenv().get("MY_PASSWORD"))
				.setSubscribe(true)
				.setFax("fax_5")
				.setCompany("company_5")
				.setAddress2("address2_5")
				.build();
	}

	public IUser getAdmin() {
//		return new User("hahaha@gmail.com", "123",
//				System.getenv().get("MY_PASSWORD"));
		return User.get()
				.setFirstName("admin")
				.setLastName("hahaha")
				.setEmail("hahaha@gmail.com")
				.setTelephone("telephone_5")
				.setAddress1("address1_5")
				.setCity("city_5")
				.setPostCode("postCode_5")
				.setCountry("country_5")
				.setRegionState("regionState_5")
				.setPassword(System.getenv().get("ADMIN_PASSWORD"))
				.setSubscribe(true)
				.setFax("fax_5")
				.setCompany("company_5")
				.setAddress2("address2_5")
				.build();
	}

	public IUser getInvalid() {
		return User.get()
				.setFirstName("hahaha1")
				.setLastName("hahaha1")
				.setEmail("hahaha1@gmail.com")
				.setTelephone("telephone_5")
				.setAddress1("address1_5")
				.setCity("city_5")
				.setPostCode("postCode_5")
				.setCountry("country_5")
				.setRegionState("regionState_5")
				.setPassword(System.getenv().get("MY_PASSWORD"))
				.setSubscribe(true)
				.setFax("fax_5")
				.setCompany("company_5")
				.setAddress2("address2_5")
				.build();
	}

	public IUser getVasyl(){
		return User.get()
				.setFirstName("Vasyl")
				.setLastName("Shchuka")
				.setEmail("test.user.vasyl@meta.ua")
				.setTelephone("1234567")
				.setAddress1("address")
				.setCity("Fish and Chips")
				.setPostCode("1212")
				.setCountry("United Kingdom")
				.setRegionState("Bristol")
				.setPassword(System.getenv().get("VASYLS_PASSWORD"))
				.setSubscribe(true)
				.setFax("fax")
				.setCompany("company")
				.setAddress2("address_2")
				.build();
	}

	public IUser getMrAndersonUser(){
		return User.get()
				.setFirstName("MrAnderson")
				.setLastName("Neo")
				.setEmail("testByAnderson@gamil.com")
				.setTelephone("+30636969696")
				.setAddress1("address")
				.setCity("Isengard")
				.setPostCode("129413")
				.setCountry("Ukraine")
				.setRegionState("L`vivs`ka Oblast`")
//				.setPassword(System.getenv().get("MY_PASSWORD"))
				.setPassword("qwerty")
				.setSubscribe(true)
				.setFax("fax")
				.setCompany("company")
				.setAddress2("address2")
				.build();
	}

	public List<IUser> fromCsv(String filename) {
		return User.getByLists(new CSVReader(filename).getAllCells());
	}

	public List<IUser> fromCsv() {
		return fromCsv("users.csv");
	}

	public List<IUser> fromExcel(String filename) {
		return User.getByLists(new ExcelReader(filename).getAllCells());
	}

	public List<IUser> fromExcel() {
		return fromExcel("users.xlsx");
	}

}
