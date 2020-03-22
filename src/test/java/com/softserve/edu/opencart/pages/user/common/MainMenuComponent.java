package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.MenuItems;
import com.softserve.edu.opencart.tools.ErrorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainMenuComponent {

    protected final String LIST_SUB_CATEGOIES_CSSSELECTOR = "div.dropdown-inner ul.list-unstyled li";
    protected final String DROPDOWN_TOP_MENU_CSSSELECTOR = "#menu .dropdown-menu";

    private MenuItems categoryItem;
    private List<WebElement> menuItemList;

    private WebDriver driver;

    private DropdownComponent dropdownComponent;

    public MainMenuComponent(WebDriver driver) {
        this.driver = driver;

        initElements();
    }

    private void initElements() {
        // init elements
        menuItemList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
//        menuItemList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//li/a"));
//        dropdownComponent = new DropdownComponent(driver, By.cssSelector(LIST_SUB_CATEGOIES_CSSSELECTOR));  // hardcode

    }

    // Page Object
    public List<WebElement> getMenuItemList() {
        return menuItemList;
    }

    private DropdownComponent createDropdownComponent(By searchLocator) {
        dropdownComponent = new DropdownComponent(driver, searchLocator);
        return getDropdownComponent();
    }

    private Integer getMenuItemNumber(MenuItems categoryItem) {
        return getMenuItemList().indexOf(categoryItem);
    }

    public DropdownComponent getDropdownComponent() {
        return dropdownComponent;
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
                String.format("OPTION_NOT_FOUND_MESSAGE",
                        categoryName, getMenuTopText().toString()));
        getMenuTopByCategoryPartialName(categoryName).click();
    }

//    public void clickMenuTopByPartialName(String categoryName, String optionName) {
//        System.out.println("categoryName : "+categoryName);
//        clickMenuTopByCategoryPartialName(categoryName);
//        System.out.println("optionName : "+optionName);
//        createDropdownComponent(By.cssSelector(DROPDOWN_TOP_MENU_CSSSELECTOR));
//        clickDropdownComponentByPartialName(optionName);
//    }



    // Functional

    // Business Logic

}
