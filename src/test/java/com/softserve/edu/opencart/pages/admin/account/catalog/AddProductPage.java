package com.softserve.edu.opencart.pages.admin.account.catalog;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddProductPage extends LeftMenuPart {

    private WebElement inputName;
    private WebElement inputTitle;
    private WebElement dataButton;
    private WebElement inputModel;
    private WebElement saveButton;
    private WebElement linkButton;
    private WebElement inputCategory;
    private WebElement inputPrice;

    public AddProductPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        inputName = driver.findElement(By.id("input-name1"));
        inputTitle = driver.findElement(By.id("input-meta-title1"));
        dataButton = driver.findElement(By.xpath("//a[@href='#tab-data']"));
        inputModel = driver.findElement(By.id("input-model"));
        saveButton = driver.findElement(By.cssSelector(".btn-primary > .fa-save"));
        linkButton = driver.findElement(By.xpath("//a[@href='#tab-links']"));
        inputCategory = driver.findElement(By.xpath("//input[@name='category']"));
        inputPrice = driver.findElement(By.id("input-price"));
    }

//    public AddProductPage typeName(NewProduct product) {
    public AddProductPage typeName(String arg) {
        inputName.click();
        inputName.clear();
        inputName.sendKeys(arg);
        return this;
    }

//    public AddProductPage typeTitle(NewProduct product) {
    public AddProductPage typeTitle(String arg) {
        inputTitle.click();
        inputTitle.clear();
        inputTitle.sendKeys(arg);
        return this;
    }

    public AddProductPage clickDataButton() {
        dataButton.click();
        return this;
    }

//    public AddProductPage typeModel(NewProduct product) {
    public AddProductPage typeModel(String arg) {
        inputModel.click();
        inputModel.clear();
        inputModel.sendKeys(arg);
        return this;
    }

    public AddProductPage clickLinkButton(){
        linkButton.click();
        return this;
    }

    public AddProductPage typeCategory(String arg){
        inputCategory.click();
        inputCategory.clear();
        inputCategory.sendKeys(arg);
        inputCategory.isSelected();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public AddProductPage typePrice(String arg){
        inputPrice.click();
        inputPrice.clear();
        inputPrice.sendKeys(arg);
        return this;
    }

    public AddProductPage clickCategoryDropdown(){
        List<WebElement> dropdown = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));///"//input[@id='input-manufacturer']/../ul"));
        for (WebElement option : dropdown)
        {
            System.out.println("1 "+option.getText());
            if (option.getText().equals("Routers"))
            {
                System.out.println("2 "+option.getText());
                option.click(); // click the desired option
                break;
            }
        }
        return this;
    }

    public ModifiedCatalogPage gotoModifiedCategoriesPage() {
        saveButton.click();
        return new ModifiedCatalogPage(driver);
    }

}
