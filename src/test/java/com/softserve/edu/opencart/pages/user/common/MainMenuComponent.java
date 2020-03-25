package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.creation_product_admin_panel.NewProductRepository;
import com.softserve.edu.opencart.pages.admin.account.catalog.ModifiedCatalogPage;
import com.softserve.edu.opencart.pages.user.search.ProductsSidebarEmptyPage;
import com.softserve.edu.opencart.pages.user.search.ProductsSidebarFullPage;
import com.softserve.edu.opencart.tools.ErrorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MainMenuComponent {

    protected final String LIST_SUB_CATEGORIES_XPATH = "//li[@class='dropdown open']/div/div";
    protected final String DROPDOWN_SHOW_ALL_XPATH = "//li[@class='dropdown open']//a[@class='see-all']";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    protected final String SUB_CATEGORIES = "//a[text()='%s']/parent::*[@class='dropdown']/*[@class='dropdown-menu']//li/a";

    private List<WebElement> menuItemList;
    private List<WebElement> subMenuItems;

    private String allCategories;
    private boolean dropdownAlive;

    private WebDriver driver;

    private DropdownComponent dropdownComponent;

    public MainMenuComponent(WebDriver driver) {
        this.driver = driver;

        initElements();
    }

    private void initElements() {
        // init elements
        menuItemList = driver.findElements(By.cssSelector("#menu .navbar-ex1-collapse .nav.navbar-nav > li"));
//        dropdownComponent = new DropdownComponent(driver, By.cssSelector(LIST_SUB_CATEGOIES_CSSSELECTOR));  // hardcode

    }

    // Page Object
    public List<WebElement> getMenuItemList() {
        return menuItemList;
    }

    private void createDropdownComponent(By searchLocator) {
        dropdownComponent = new DropdownComponent(driver, searchLocator);
    }

    public boolean isDropdownAlive() {
        return dropdownAlive;
    }

    public void setDropdownAlive(boolean dropdownAlive) {
        this.dropdownAlive = dropdownAlive;
    }

    public DropdownComponent getDropdownComponent() {
        return dropdownComponent;
    }

    public void setSubMenuItems(List<WebElement> subMenuItems) {
        this.subMenuItems = subMenuItems;
    }

    public List<WebElement> getSubMenuItems() {
        return subMenuItems;
    }

    public void setAllCategories(String input) {
        allCategories = input;
    }

    public String getAllCategories() {
        return allCategories;
    }

    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
        WebElement result = null;
        for (WebElement current : getMenuItemList()) {
            if (current.getText().toLowerCase().contains(categoryName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }

    public List<String> getSubMenuTopText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getSubMenuItems()) {
            result.add(menuItem.getText());
        }
        return result;
    }

    public Map<String,List<String>> getMenuCategoriesMap(){
        Map<String,List<String>> menuCategoriesMap = new HashMap();
        for (WebElement menuItem : getMenuItemList()) {
           String categoryText = menuItem.getText();
            new Actions(driver).moveToElement(menuItem).build().perform();
            if (menuItem.getAttribute("class").contains("dropdown")){
                List<WebElement> subCategoryElementList = driver.findElements(By.xpath(String.format(SUB_CATEGORIES,categoryText)));
                List<String> subCategoriesStringList = new ArrayList();
                for(WebElement subMenuItem : subCategoryElementList){
                    subCategoriesStringList.add(subMenuItem.getText());
                }
                menuCategoriesMap.put(categoryText,subCategoriesStringList);
            }else {
                menuCategoriesMap.put(categoryText,null);
            }
        }
        return menuCategoriesMap;
    }

    public List<String> getMenuTopText() {
        List<String> result = new ArrayList<>();
        for (WebElement menuItem : getMenuItemList()) {
            result.add(menuItem.getText());
        }
        return result;
    }

    public void clickMenuTopByCategoryPartialName(String categoryName) {
        boolean isClickable = false;
        for (String current : getMenuTopText()) {
            if (current.toLowerCase().contains(categoryName.toLowerCase())) {
                isClickable = true;
                break;
            }
        }
        ErrorUtils.createCustomException(!isClickable,
                String.format(OPTION_NOT_FOUND_MESSAGE, categoryName, getMenuTopText().toString()));
        getMenuTopByCategoryPartialName(categoryName).click();
    }

    //------------------------------------------------------------------------------------------------------------------
    public void clickMenuTopByPartialName(String categoryName) {
        setDropdownAlive(false);
        clickMenuTopByCategoryPartialName(categoryName);

        createDropdownComponent(By.xpath(LIST_SUB_CATEGORIES_XPATH));
        setAllCategories(categoryName);

        if (getDropdownComponent().isExistDropdownOption()) {
            setDropdownAlive(true);
            setSubMenuItems(getDropdownComponent().getListOptions());
            setAllCategories(getAllCategories() + getSubMenuTopText());
        }

        createDropdownComponent(By.xpath(DROPDOWN_SHOW_ALL_XPATH));
        clickDropdownComponentByPartialName("Show All " + categoryName);
        gotoEmptyLeftMenu(isDropdownAlive());
    }

    //------------------------------------------------------------------------------------------------------------------
    private void clickDropdownComponentByPartialName(String optionName) {

        try {
            if (getDropdownComponent().isExistDropdownOptionByPartialName(optionName)) {
                getDropdownComponent().clickDropdownOptionByPartialName(optionName);
                dropdownComponent = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format(OPTION_NOT_FOUND_MESSAGE, optionName, getDropdownComponent().getListOptionsText().toString()));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public MainMenuComponent chooseCategory(Categories menuItem) {
        clickMenuTopByPartialName(menuItem.toString());
        System.out.println(getAllCategories());

        try {
            Thread.sleep(1000);  // for demo prezentation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        return this;
        return new MainMenuComponent(driver);
    }

    // Functional

    public String checkFirstProduct() {
        String productName = NewProductRepository.router().getProductName();
        WebElement product = driver.findElement(By.xpath(String.format("//h4/a[text()='%s']", productName)));
        return product.getText();
    }

    public void gotoEmptyLeftMenu(boolean dropdownAlive) {
        if (dropdownAlive = true) {
            gotoFullLeftMenu();
        } else {
            gotoEmptyLeftMenu();
        }
    }

    // Business Logic

    public ProductsSidebarEmptyPage gotoEmptyLeftMenu() {
        return new ProductsSidebarEmptyPage(driver);
}

    public ProductsSidebarFullPage gotoFullLeftMenu() {
        return new ProductsSidebarFullPage(driver);
    }
}
