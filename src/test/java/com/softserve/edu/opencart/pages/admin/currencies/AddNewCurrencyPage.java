package com.softserve.edu.opencart.pages.admin.currencies;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCurrencyPage extends LeftMenuPart {
    private WebDriver driver;

    private WebElement saveButton;
    private WebElement cancelButton;
    private WebElement currencyTitleField;
    private WebElement currencyCodeField;
    private WebElement currencySymbolLeftField;
    private WebElement currencySymbolRightField;
    private WebElement currencyDecimalPlacesField;
    private WebElement currencyValueField;
    private WebElement currencyStatusButton;
    private WebElement currencyStatusEnabledButton;

    public AddNewCurrencyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        saveButton = driver.findElement(By.xpath("//*[@data-original-title='Save']"));
        cancelButton = driver.findElement(By.xpath("//*[@data-original-title='Cancel']"));
        currencyTitleField = driver.findElement(By.xpath("//*[@id=\"input-title\"]"));
        currencyCodeField = driver.findElement(By.xpath("//*[@id=\"input-code\"]"));
        currencySymbolLeftField = driver.findElement(By.xpath("//*[@id=\"input-symbol-left\"]"));
        currencySymbolRightField = driver.findElement(By.xpath("//*[@id=\"input-symbol-right\"]"));
        currencyDecimalPlacesField = driver.findElement(By.xpath("//*[@id=\"input-decimal-place\"]"));
        currencyValueField = driver.findElement(By.xpath("//*[@id=\"input-value\"]"));
        currencyStatusButton = driver.findElement(By.xpath("//*[@id=\"input-status\"]"));
        currencyStatusEnabledButton = driver.findElement(By.xpath("//*[@id='input-status']/option[@value = '1']"));
    }

    public void clickSaveButton(){
        saveButton.click();
    }
    public void clickCancelButton(){
        cancelButton.click();
    }
    public void clickCurrencyTitleField(){
        currencyTitleField.click();
    }
    public void clearCurrencyTitleField(){
        currencyTitleField.clear();
    }
    public void setCurrencyTitleField(String titleField){
        currencyTitleField.sendKeys(titleField);
    }
    public void clickCurrencyCodeField(){
        currencyCodeField.click();
    }
    public void clearCurrencyCodeField(){
        currencyCodeField.clear();
    }
    public void setCurrencyCodeField(String codeField){
        currencyCodeField.sendKeys(codeField);
    }
    public void clickSymbolLeftField(){
        currencySymbolLeftField.click();
    }
    public void clearSymbolLeftField(){
        currencySymbolLeftField.clear();
    }
    public void setCurrencySymbolLeftField(String symbolLeftField){
        currencySymbolLeftField.sendKeys(symbolLeftField);
    }
    public void clickSymbolRightField(){
        currencySymbolRightField.click();
    }
    public void clearSymbolRightField(){
        currencySymbolRightField.clear();
    }
    public void setSymbolRightField(String symbolRightField){
        currencySymbolRightField.sendKeys(symbolRightField);
    }
    public void clickDecimalPlacesField(){
        currencyDecimalPlacesField.click();
    }
    public void clearDecimalPlacesField(){
        currencyDecimalPlacesField.clear();
    }
    public void setCurrencyDecimalPlacesField(String decimalPlacesField){
        currencyDecimalPlacesField.sendKeys(decimalPlacesField);
    }
    public void clickValueField(){
        currencyValueField.click();
    }
    public void clearValueField(){
        currencyValueField.clear();
    }
    public void setCurrencyValueField(String valueField){
        currencyValueField.sendKeys(valueField);
    }
    public void clickStatusButton(){
        currencyStatusButton.click();
    }
    public void clickStatusEnabledButton(){
        currencyStatusEnabledButton.click();
    }
    private void fillTitleField(){
        clickCurrencyTitleField();
        clearCurrencyTitleField();
        //setCurrencyTitleField();
    }
    private void fillCodeField(){
        clickCurrencyCodeField();
        clearCurrencyCodeField();
        //setCurrencyCodeField();
    }
    private void fillSymbolLeftField(){
        clickSymbolLeftField();
        clearSymbolLeftField();
        //setSymbolLeftField();
    }
    private void fillSymbolRightField(){
        clickSymbolRightField();
        clearSymbolRightField();
        //setSymbolRightField();
    }
    private void fillDecimalPlacesField() {
        clickDecimalPlacesField();
        clearDecimalPlacesField();
        //setDecimalPlacesField();
    }
    private void fillValueField() {
        clickValueField();
        clearValueField();
        //setValueField();
    }
    private void chooseStatusEnabled() {
        clickStatusButton();
        clickStatusEnabledButton();
    }
    private void fillAllFields(){
        fillTitleField();
        fillCodeField();
        fillSymbolLeftField();
        fillSymbolRightField();
        fillDecimalPlacesField();
        fillValueField();
        chooseStatusEnabled();
    }
//    public CurrenciesPage addNewCurrency(){
//        fillAllFields();
//        clickSaveButton();
//        return new CurrenciesPage(driver);
//    }

}
