package com.softserve.edu.opencart.pages.user.search;

import com.softserve.edu.opencart.data.MenuItems;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;

public abstract class SearchCriteriaPart extends BreadCrumbPart {

	private WebElement criteriaSearchField;
	private Select criteriaCategory;
	private WebElement criteriaSubCategory;
	private WebElement criteriaDescription;
	private WebElement criteriaSearchButton;

	public SearchCriteriaPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		criteriaSearchField = driver.findElement(By.id("input-search"));
		criteriaCategory = new Select(driver.findElement(By.name("category_id")));
		criteriaSubCategory = driver.findElement(By.name("sub_category"));
		criteriaDescription = driver.findElement(By.cssSelector(".checkbox-inline #description"));
		criteriaSearchButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
	}

	// Page Object

	// criteriaSearchField
	public WebElement getCriteriaSearchField() {
		return criteriaSearchField;
	}

	public String getCriteriaSearchFieldText() {
		return getCriteriaSearchField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setCriteriaSearchField(String text) {
		getCriteriaSearchField().sendKeys(text);
	}

	public void clearCriteriaSearchField() {
		getCriteriaSearchField().clear();
	}

	public void clickgetCriteriaSearchField() {
		getCriteriaSearchField().click();
	}

	// criteriaCategory
	public Select getCriteriaCategory() {
		return criteriaCategory;
	}
	public SearchSuccessPage chooseCategory(String category)
	{
		getCriteriaCategory().selectByValue(category);
		getCriteriaSearchButton().click();
		return new SearchSuccessPage(driver);
	}
	public WebElement getCriteriaCategoryWebElement() {
		return getCriteriaCategory().getWrappedElement();
	}

	public String getCriteriaCategoryText() {
		return getCriteriaCategory().getFirstSelectedOption().getText();
	}

	public void setCriteriaCategory(String text) {
		getCriteriaCategory().selectByVisibleText(text);
	}

	public void clickCriteriaCategory() {
		getCriteriaCategoryWebElement().click();
	}

	// criteriaSubCategory
	public WebElement getCriteriaSubCategory() {
		return criteriaSubCategory;
	}

	public boolean isCriteriaSubCategoryEnable() {
		return getCriteriaSubCategory().isEnabled();
	}

	public void clickCriteriaSubCategory() {
		if (!getCriteriaSubCategory().isEnabled()) {
			// TODO Develop Custom Exception
			throw new RuntimeException("Error, CriteriaSubCategory had disabled");
		}
		getCriteriaSubCategory().click();
	}

	// criteriaDescription
	public WebElement getCriteriaDescription() {
		return criteriaDescription;
	}

	public SearchSuccessPage clickCriteriaDescription() {
		getCriteriaDescription().click();
		getCriteriaSearchButton().click();
		return new SearchSuccessPage(driver);
	}

	// criteriaSearchButton
	public WebElement getCriteriaSearchButton() {
		return criteriaSearchButton;
	}

	public SearchCriteriaPart clickCriteriaSearchButton() {
		getCriteriaSearchButton().click();
		return this;
	}
	public SearchSuccessPage searchNewProduct(Product product) {
		getCriteriaSearchField().clear();
		setCriteriaSearchField(product.getName());
		getCriteriaSearchButton().click();
		return new SearchSuccessPage(driver);
	}

	// Functional

	// criteriaSubCategory
	public void clickCriteriaSubCategory(String subcategory) {
		setCriteriaCategory(subcategory);
		clickCriteriaSubCategory();
	}

	// Business Logic

}
