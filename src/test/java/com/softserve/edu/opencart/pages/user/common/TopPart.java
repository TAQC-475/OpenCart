package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.ShoppingCartPage;
import com.softserve.edu.opencart.pages.user.account.*;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListEmptyPage;
import com.softserve.edu.opencart.pages.user.common.WishList.WishListPage;
import com.softserve.edu.opencart.pages.user.search.ProductsDisplayComponent;
import com.softserve.edu.opencart.pages.user.search.ProductsSidebarEmptyPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessAlertPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;
import com.softserve.edu.opencart.tools.RegularExpression;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class TopPart {
    protected final String OPTION_NULL_MESSAGE = "DropdownComponent is null";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    protected final String PAGE_DO_NOT_EXIST = "Page do not exist!!!";
    //
    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    //
    protected final String LIST_CURRENCIES_CSSSELECTOR = "div.btn-group.open ul.dropdown-menu li";
    protected final String DROPDOWN_MYACCOUNT_CSSSELECTOR = ".dropdown-menu-right li";
    //
    protected WebDriver driver;


    //
    private WebElement currency;
    private WebElement myAccount;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;
    private WebElement logo;
    private WebElement searchTopField;
    private WebElement searchTopButton;
    private WebElement cartButton;
    //
    private ProductsSidebarEmptyPage productsSidebarEmptyPage;
    private MainMenuComponent mainMenuComponent;
    private DropdownComponent dropdownComponent;
    private ViewCartComponent viewCartComponent;
    private DropdownGuest dropdownGuest;
    private DropdownLogged dropdownLogged;
    // to check if cart view already opened
    private boolean isViewCartOpened;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        isViewCartOpened = false;
        initElements();
    }

    private void initElements() {
        // init elements
        currency = driver.findElement(By.cssSelector(".btn-link.dropdown-toggle"));
        myAccount = driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
        wishList = driver.findElement(By.id("wishlist-total"));
        shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
        checkout = driver.findElement(By.cssSelector("a[title='Checkout']"));
        logo = driver.findElement(By.cssSelector("#logo a"));
        searchTopField = driver.findElement(By.cssSelector("#search > input"));
        searchTopButton = driver.findElement(By.cssSelector("button.btn.btn-default"));
        cartButton = driver.findElement(By.cssSelector("#cart > button"));
    }

    // Page Object

    // currency
    public WebElement getCurrency() {
        //return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return currency;
    }

    public String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }

    // myAccount
    public WebElement getMyAccount() {
        return myAccount;
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

    // wishList
    public WebElement getWishList() {
        return wishList;
    }

    public String getWishListText() {
        return getWishList().getText();
    }

    public void clickWishList() {
        getWishList().click();
    }

    public int getWishListComponentNumber() {
//        Use getWishListText()
        return new RegularExpression().getNumberFromString(getWishListText());
    }

    // shoppingCart
    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public String getShoppingCartText() {
        return getShoppingCart().getText();
    }

    public void clickShoppingCart() {
        getShoppingCart().click();
    }

    public ShoppingCartPage goToShoppingCartPage() {
        clickShoppingCart();
        return new ShoppingCartPage(driver);
    }

    // checkout
    public WebElement getCheckout() {
        return checkout;
    }

    public String getCheckoutText() {
        return getCheckout().getText();
    }

    public void clickCheckout() {
        getCheckout().click();
    }

    // logo
    public WebElement getLogo() {
        return logo;
    }

    public void clickLogo() {
        getLogo().click();
    }

    // searchTopField
    public WebElement getSearchTopField() {
        return searchTopField;
    }

    public String getSearchTopFieldText() {
        return getSearchTopField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSearchTopField() {
        getSearchTopField().clear();
    }

    public void clickSearchTopField() {
        getSearchTopField().click();
    }

    public void setSearchTopField(Product product) {
        getSearchTopField().click();
        getSearchTopField().sendKeys(product.getName());
    }

    // searchTopButton
    public WebElement getSearchTopButton() {
        return searchTopButton;
    }

    public ProductsDisplayComponent clickSearchTopButton() {
        getSearchTopButton().click();
        return new ProductsDisplayComponent(driver);
    }

    // cartButton
    public WebElement getCartButton() {
        return cartButton;
    }

    public String getCartButtonText() {
        return getCartButton().getText();
    }

    public void clickCartButton() {
        getCartButton().click();
    }

    public boolean isViewCartOpened() {
        return isViewCartOpened;
    }

    public void setViewCartOpened(boolean viewCartOpened) {
        isViewCartOpened = viewCartOpened;
    }

    // dropdownComponent
    protected DropdownComponent getDropdownComponent() {
        //LeaveUtils.castExceptionByCondition(dropdownOptions == null, OPTION_NULL_MESSAGE);
        if (dropdownComponent == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return dropdownComponent;
    }

    private DropdownComponent createDropdownComponent(By searchLocator) {
        dropdownComponent = new DropdownComponent(driver, searchLocator);
        return getDropdownComponent();
    }

    public MainMenuComponent getMainMenuComponent() {
        return mainMenuComponent = new MainMenuComponent(driver);
    }

    public ProductsSidebarEmptyPage gotoProductsSidebarEmptyPage() {
        getProductsSidebarEmptyPage()
                .gotoLeftMenuBar();
        return new ProductsSidebarEmptyPage(driver);
    }

    public ProductsSidebarEmptyPage getProductsSidebarEmptyPage() {
        return productsSidebarEmptyPage = new ProductsSidebarEmptyPage(driver);
    }

    private void clickDropdownComponentByPartialName(String optionName) {
        //LeaveUtils.castExceptionByCondition(!getDropdownOptions().isExistDropdownOptionByPartialName(optionName),
        //        String.format(OPTION_NOT_FOUND_MESSAGE, optionName, dropdownOptions.getListOptionsText().toString()));
        if (!getDropdownComponent().isExistDropdownOptionByPartialName(optionName)) {
            // TODO Develop Custom Exception
            throw new RuntimeException(String.format(OPTION_NOT_FOUND_MESSAGE, optionName, getDropdownComponent().getListOptionsText().toString()));
        }
        getDropdownComponent().clickDropdownOptionByPartialName(optionName);
        dropdownComponent = null;
        //closeDropdownComponent();
    }

    private void closeDropdownComponent() {
        clickSearchTopField();
        dropdownComponent = null;
    }

    // dropdownGuest
    protected DropdownGuest getDropdownGuest() {
        if (dropdownGuest == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return dropdownGuest;
    }

    private DropdownGuest createDropdownGuest() {
        dropdownGuest = new DropdownGuest(driver);
        return getDropdownGuest();
    }

    private void clickDropdownGuestRegister() {
        getDropdownGuest().clickRegister();
        dropdownGuest = null;
    }

    private void clickDropdownGuestLogin() {
        getDropdownGuest().clickLogin();
        dropdownGuest = null;
    }

    private void closeDropdownGuest() {
        clickSearchTopField();
        dropdownGuest = null;
    }

    // dropdownLogged
    protected DropdownLogged getDropdownLogged() {
        if (dropdownLogged == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return dropdownLogged;
    }

    private DropdownLogged createDropdownLogged() {
        dropdownLogged = new DropdownLogged(driver);
        return getDropdownLogged();
    }

    private void clickDropdownLoggedMyAccount() {
        getDropdownLogged().clickMyAccount();
        dropdownLogged = null;
    }

    private void clickDropdownLoggedOrderHistory() {
        getDropdownLogged().clickOrderHistory();
        dropdownLogged = null;
    }

    private void clickDropdownLoggedTransactions() {
        getDropdownLogged().clickTransactions();
        dropdownLogged = null;
    }

    private void clickDropdownLoggedDownloads() {
        getDropdownLogged().clickDownloads();
        dropdownLogged = null;
    }

    private void clickDropdownLoggedLogout() {
        getDropdownLogged().clickLogout();
        dropdownLogged = null;
    }

    private void closeDropdownLogged() {
        clickSearchTopField();
        dropdownLogged = null;
    }

    //view cart button
    private ViewCartComponent getViewCartComponent() {
        if (viewCartComponent == null) {
            viewCartComponent = new ViewCartComponent(driver);
        }
        return viewCartComponent;
    }

    // Functional

    // currency
    private void openCurrencyDropdownComponent() {
        //clickSearchTopField();
        closeDropdownComponent();
        clickCurrency();
        createDropdownComponent(By.cssSelector(LIST_CURRENCIES_CSSSELECTOR));
    }

    //protected void clickCurrencyByPartialName(String currencyName) { // Code Smell
    protected void clickCurrencyByPartialName(Currencies optionName) {
        openCurrencyDropdownComponent();
        //clickDropdownComponentByPartialName(currencyName);
        clickDropdownComponentByPartialName(optionName.toString());
    }

    public List<String> getListCurrencyNames() {
        openCurrencyDropdownComponent();
        List<String> result = getDropdownComponent().getListOptionsText();
        closeDropdownComponent();
        return result;
    }

    // myAccount
    protected void openMyAccountDropdown() {
        clickSearchTopField();
        clickMyAccount();
    }

    // TODO myAccount

    // searchTopField
    private void fillSearchTopField(Product searchText) {
        clickSearchTopField();
        clearSearchTopField();
        setSearchTopField(searchText);
    }

    protected void defaultLogin(User user) {
        if (!ApplicationStatus.get().isLogged()) {
            new LoginPage(driver)
                    .fillLogin(user);
        } else {
            // TODO throw Custom Exception
        }
    }

    // Business Logic

    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }

    //TODO class for parameter
    public SearchSuccessPage successfulSearch(Product product) {
        fillSearchTopField(product);
        clickSearchTopButton();
        return new SearchSuccessPage(driver);
    }

    public SearchUnsuccessPage unsuccessfulSearch(Product product) {
        //public SearchUnsuccessPage unsuccessfulSearch(Product product){
        fillSearchTopField(product);
        //fillSearchTopField(product.getName());
        clickSearchTopButton();
        return new SearchUnsuccessPage(driver);
    }

    // dropdownGuest
    public LoginPage gotoLoginPage() {
        openMyAccountDropdown();
        createDropdownGuest();
        clickDropdownGuestLogin();
        return new LoginPage(driver);
    }

    public RegisterPage gotoRegisterPage() {
        openMyAccountDropdown();
        createDropdownGuest();
        clickDropdownGuestRegister();
        return new RegisterPage(driver);
    }

    // dropdownLogged
    public MyAccountPage gotoMyAccount() {
        openMyAccountDropdown();
        createDropdownLogged();
        clickDropdownLoggedMyAccount();
        return new MyAccountPage(driver);
    }

//    public OrderHistoryPage gotoOrderHistory() {
//    	openMyAccountDropdown();
//    	createDropdownLogged();
//    	clickDropdownLoggedOrderHistory();
//        return new OrderHistoryPage(driver);
//    }

//    public TransactionsPage gotoTransactions() {
//    	openMyAccountDropdown();
//    	createDropdownLogged();
//    	clickDropdownLoggedTransactions();
//        return new TransactionsPage(driver);
//    }

//    public DownloadsPage gotoDownloads() {
//    	openMyAccountDropdown();
//    	createDropdownLogged();
//    	clickDropdownLoggedDownloads();
//        return new DownloadsPage(driver);
//    }

    public AccountLogoutPage logout() {
        openMyAccountDropdown();
        createDropdownLogged();
        clickDropdownLoggedLogout();
        return new AccountLogoutPage(driver);
    }

    // wishList
    public WishListPage gotoWishListPage(){
        new WaitUtils(driver,10).waitForAlertVisibility();
        clickWishList();
        return new WishListPage(driver);
    }

    public WishListPage goToWishListPage(User user) {
        clickWishList();
        defaultLogin(user);
        return new WishListPage(driver);
    }
    public WishListEmptyPage gotToWishListEmptyPage(){
        clickWishList();
        return new WishListEmptyPage(driver);
    }


    // view cart button logic
    public void openViewCartComponent() {
        clickCartButton();
        setViewCartOpened(true);
    }

    public void closeViewCartComponent() {
        clickCartButton();
        if(isViewCartOpened()){
            clickCartButton();
            viewCartComponent = null;
            setViewCartOpened(false);
        }
        viewCartComponent = null;
        setViewCartOpened(false);
    }

    public String getViewCartComponentTotalText() {
        return getViewCartComponent().getCartTotalText();
    }

    public String getViewCartComponentTotalAmount() {
        return getViewCartComponent().getCartTotalAmount();
    }

    public String getViewCartEmptyMsgText() {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getEmptyCartMsgText();
    }

    public String getProductNameFromViewCart(Product product) {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getViewProductComponentName(product);
    }

    public String getProductPriceFromViewCart(Product product) {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getViewProductComponentPrice(product);
    }

    public String getProductQuantityFromViewCart(Product product) {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getViewProductComponentQuantity(product);
    }

    public String getSubTotalPriceFromViewCart() {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getSubTotalText();
    }

    public String getEcoTaxPriceFromViewCart() {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getEcoTaxText();
    }

    public String getVATPriceFromViewCart() {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getVatTaxText();
    }

    public String getTotalFromViewCart() {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        return getViewCartComponent().getTotalPriceText();
    }

    public void removeProductFromViewCart(Product product) {
        if(!isViewCartOpened()) {
            openViewCartComponent();
        }
        getViewCartComponent().removeViewProductComponent(product);
        setViewCartOpened(false);
    }
    public SearchSuccessAlertPage searchAndAddProductsToWishList(List<Product> products){

        int i = 1;
        SearchSuccessAlertPage search = getAddProductsToWishList(products.get(0));

        while (i != products.size()){
           search = search.getAddProductsToWishList(products.get(i));
        i++;}

        return new SearchSuccessAlertPage(driver);
    }
    public SearchSuccessAlertPage getAddProductsToWishList(Product product){
        successfulSearch(product)
            .AddToWishButtonByName(product);
        return new  SearchSuccessAlertPage(driver);
    }

}