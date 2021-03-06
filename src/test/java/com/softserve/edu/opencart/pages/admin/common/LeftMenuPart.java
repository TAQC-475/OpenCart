package com.softserve.edu.opencart.pages.admin.common;

import com.softserve.edu.opencart.pages.admin.account.catalog.CategoriesPage;
import com.softserve.edu.opencart.pages.admin.account.catalog.ProductPage;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LeftMenuPart extends HeaderPart {

    private final String NAVIGATE_PANNEL_ACTIVE = "active";
    private final String NAVIGATION_MENU_LIST_CSSSELECTOR = "#menu > li";
    //
    private WebElement navigatePannel;
    private WebElement menuButton;
    private WebElement logoutButton;
    //web elements in main menu
    private WebElement catalog;
    private WebElement extensions;
    private WebElement design;
    private WebElement sales;
    private WebElement customers;
    private WebElement marketing;
    private WebElement system;
    //web elements in system menu
    private WebElement settings;
    private WebElement localisation;
    private WebElement tools;
    //web elements in localisation menu
    private WebElement storeLocation;
    private WebElement languages;
    private WebElement currencies;
    //
    private WebElement categories;
    private WebElement products;
    //WebDriverWait
    WebDriverWait wait = new WebDriverWait(driver, 5);
    //
    private NavigationComponent navigationComponent;

    public LeftMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

        //web elements in mein menu
        navigatePannel = driver.findElement(By.id("column-left"));
        menuButton = driver.findElement(By.id("button-menu"));
        logoutButton = driver.findElement(By.cssSelector("a[href*='route=common/logout']"));
        catalog = driver.findElement(By.id("menu-catalog"));
        extensions = driver.findElement(By.id("menu-extension"));
        design = driver.findElement(By.id("menu-design"));
        sales = driver.findElement(By.id("menu-sale"));
        customers = driver.findElement(By.id("menu-customer"));
        marketing = driver.findElement(By.id("menu-catalog"));
        system = driver.findElement(By.id("menu-system"));
        //web elements in system menu
        localisation = driver.findElement(By.xpath("//*[@id='menu-system']//a[contains(text(), 'Localisation')]"));
        //web elements in localisation menu
        storeLocation = driver.findElement(By.xpath("//*[@id=\"menu-system\"]//a[contains(text(), 'Store')]"));
        languages = driver.findElement(By.xpath("//*[@id=\"menu-system\"]//a[contains(text(), 'Languages')]"));
        currencies = driver.findElement(By.xpath("//*[@id=\"menu-system\"]//a[contains(text(), 'Currencies')]"));
        //
        categories = driver.findElement(By.xpath("//li[@id='menu-catalog']//a[contains(text(),'Categories')]"));
        products = driver.findElement(By.xpath("//li[@id='menu-catalog']//a[contains(text(),'Products')]"));
    }

    // Page Object

    // navigatePannel
    public WebElement getNavigatePannel() {
        return navigatePannel;
    }

    public String getNavigatePannelAttribute(String attributeName) {
        return getNavigatePannel().getAttribute(attributeName);
    }

    public String getNavigatePannelClassAttribute() {
        return getNavigatePannelAttribute(TAG_ATTRIBUTE_CLASS);
    }

    // menuButton
    public WebElement getMenuButton() {
        return menuButton;
    }

    public void clickMenuButton() {
        getMenuButton().click();
    }

    // logoutButton
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public String getLogoutButtonText() {
        return getLogoutButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }
    public void clickLogoutButton() {
        getLogoutButton().click();
    }

    // navigationComponent

    public NavigationComponent getNavigationComponent() {
        return navigationComponent;
    }

    // Functional

    public boolean isNavigatePannelActive() {
        return getNavigatePannelClassAttribute().equals(NAVIGATE_PANNEL_ACTIVE);
    }


    //System
    /**
     *This method gets the web element System
     */
    public WebElement getSystem() {
        wait.until(ExpectedConditions.visibilityOf(system));
        return system;
    }
    /**
     *Click on web element System
     */
    public void clickSystem() {
        getSystem().click();
    }

    //Localisation
    /**
     *Get the web element Localisation
     */
    public WebElement getLocalisation() {
        wait.until(ExpectedConditions.visibilityOf(localisation));
        return localisation;
    }
    /**
     *Click on web element Localisation
     */
    public void clickLocalisation() {
        getLocalisation().click();
    }

    //Currencies
    /**
     *Get the web element Currencies
     */
	public WebElement getCurrencies() {
		wait.until(ExpectedConditions.elementToBeClickable(currencies));
		return currencies;
	}
    /**
     *Click on web element Currencies
     */
	public void clickCurrencies() {
		getCurrencies().click();
	}

    // navigatePannel
    public void activeNavigatePannel() {
        if (!isNavigatePannelActive()) {
            clickMenuButton();
            navigationComponent = new NavigationComponent(navigatePannel, By.cssSelector(NAVIGATION_MENU_LIST_CSSSELECTOR));
        }
    }

    public void deactivateNavigatePannel() {
        if (isNavigatePannelActive()) {
            clickMenuButton();
        }
        navigationComponent = null;
    }

    // Business Logic
    /**
     *This method describes the path to the currency page from the main page
     */
    public CurrenciesPage gotoCurrencyPage() {
        clickSystem();
        clickLocalisation();
        clickCurrencies();
        return new CurrenciesPage(driver);
    }

    public SigninPage logout() {
        clickLogoutButton();
        return new SigninPage(driver);
    }

//	Categories
	public void clickCatalog() {
		catalog.click();
	}

	public void clickCategories() {
		categories.click();
	}

	public CategoriesPage gotoCategoriesPage() {
		clickCatalog();
		clickCategories();
		return new CategoriesPage(driver);
	}

    //Products
    public void clickProducts() {
        products.click();
    }

    public ProductPage gotoProductPage() {
        clickCatalog();
        clickProducts();
        return new ProductPage(driver);
    }
//
}
