package com.softserve.edu.opencart.pages.admin.common;

import com.softserve.edu.opencart.pages.admin.account.catalog.CategoriesPage;
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
    public WebElement getSystem() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(system));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return system;
    }

    public void clickSystem() {
        getSystem().click();
    }

    //	public SystemInLeftMenuPart leftMenuPart() {
//		clickSystem();
//		return new SystemInLeftMenuPart(driver);
//	}
    //Localisation
    public WebElement getLocalisation() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(localisation));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return localisation;
    }

    public void clickLocalisation() {
        getLocalisation().click();
    }

    //Currencies
	public WebElement getCurrencies() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(currencies));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return currencies;
	}

	public void clickCurrencies() {
		getCurrencies().click();
	}

    // navigatePannel
    public void activeNavigatePannel() {
        if (!isNavigatePannelActive()) {
            clickMenuButton();
            navigationComponent = new NavigationComponent(navigatePannel, By.cssSelector(NAVIGATION_MENU_LIST_CSSSELECTOR));
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
            //System.out.println("***LEFTMENU: " + navigationComponent.getListOptionsText());
        }
    }

    public void deactivateNavigatePannel() {
        if (isNavigatePannelActive()) {
            clickMenuButton();
        }
        navigationComponent = null;
    }

    // Business Logic

    public CurrenciesPage gotoCurrenciesPage() {
        activeNavigatePannel();
        getNavigationComponent()
                .clickNavigationOptionByPartialName("System", "Localisation", "Currencies"); // TODO Use Enum
        return new CurrenciesPage(driver);
    }

    public CurrenciesPage gotoCurrencyPage() throws InterruptedException {
        activeNavigatePannel();
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
}
