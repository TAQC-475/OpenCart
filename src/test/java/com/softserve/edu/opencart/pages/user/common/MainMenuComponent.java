package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.creation_product_admin_panel.NewProductRepository;
import com.softserve.edu.opencart.tools.ErrorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainMenuComponent {

    protected final String LIST_SUB_CATEGORIES_XPATH = "//li[@class='dropdown open']/div/div";
    protected final String DROPDOWN_SHOW_ALL_XPATH = "//li[@class='dropdown open']//a[@class='see-all']";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";

    private Categories categoryItem;
    private List<WebElement> menuItemList;
    private List<List<WebElement>> allTopMenuItems;

    private WebDriver driver;

    private DropdownComponent dropdownComponent;

    public MainMenuComponent(WebDriver driver) {
        this.driver = driver;

        initElements();
    }

    private void initElements() {
        // init elements
        menuItemList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
//        dropdownComponent = new DropdownComponent(driver, By.cssSelector(LIST_SUB_CATEGOIES_CSSSELECTOR));  // hardcode

    }

    // Page Object
    public List<WebElement> getMenuItemList() {
        return menuItemList;
    }

    public void setDropdownComponent(DropdownComponent dropdownComponent) {
        this.dropdownComponent = dropdownComponent;
    }

    public List<List<WebElement>> getAllTopMenuItems() {
        return allTopMenuItems;
    }

    public void setAllTopMenuItems(List<List<WebElement>> allTopMenuItems) {
        this.allTopMenuItems = allTopMenuItems;
    }

    private void createDropdownComponent(By searchLocator) {
        dropdownComponent = new DropdownComponent(driver, searchLocator);
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
                String.format(OPTION_NOT_FOUND_MESSAGE, categoryName, getMenuTopText().toString()));
        getMenuTopByCategoryPartialName(categoryName).click();
    }

    public void clickMenuTopByPartialName(String categoryName) {
        clickMenuTopByCategoryPartialName(categoryName);

        createDropdownComponent(By.xpath(LIST_SUB_CATEGORIES_XPATH));
        System.out.println(getDropdownComponent().getListOptionsText());

//        clickDropdownComponentByPartialName("Show All " + categoryName);

        createDropdownComponent(By.xpath(DROPDOWN_SHOW_ALL_XPATH));
        clickDropdownComponentByPartialName("Show All " + categoryName);
    }

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

    public List<String> getListSubCategoryNames() {
        List<String> result = getDropdownComponent().getListOptionsText();
        System.out.println("sub categories : " + result.toString());
        return result;
    }

    public MainMenuComponent chooseCategory(Categories menuItem) {
        clickMenuTopByPartialName(menuItem.toString());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new MainMenuComponent(driver);
    }

    public WebElement searchSubMenuItems(By searchLocator){
        WebElement element = null;
        try {
            element = driver.findElement(searchLocator);
        }catch (Exception e){
            System.out.println("error");
        }
        assert element != null;
        System.out.println(element.getText());
        return element;
    }

    // Functional

    public String checkFirstProduct(){
        String productName = NewProductRepository.router().getProductName();
        WebElement product = driver.findElement(By.xpath(String.format("//h4/a[text()='%s']", productName)));
        return product.getText();
    }

    // Business Logic

}
