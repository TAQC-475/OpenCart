package com.softserve.edu.opencart.pages.admin.currencies;

import com.softserve.edu.opencart.data.currency.ICurrency;
import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCurrencyPage extends LeftMenuPart {

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
    //SaveButton
    public void clickSaveButton(){
        saveButton.click();
    }
    //CancelButton
    public void clickCancelButton(){
        cancelButton.click();
    }
    //TitleField
    public void clickCurrencyTitleField(){
        currencyTitleField.click();
    }
    public void clearCurrencyTitleField(){
        currencyTitleField.clear();
    }
    public void setCurrencyTitleField(String titleField){
        currencyTitleField.sendKeys(titleField);
    }
    //CodeField
    public void clickCurrencyCodeField(){
        currencyCodeField.click();
    }
    public void clearCurrencyCodeField(){
        currencyCodeField.clear();
    }
    public void setCurrencyCodeField(String codeField){
        currencyCodeField.sendKeys(codeField);
    }
    //SymbolLeftField
    public void clickSymbolLeftField(){
        currencySymbolLeftField.click();
    }
    public void clearSymbolLeftField(){
        currencySymbolLeftField.clear();
    }
    public void setCurrencySymbolLeftField(String symbolLeftField){
        currencySymbolLeftField.sendKeys(symbolLeftField);
    }
    //SymbolRightField
    public void clickSymbolRightField(){
        currencySymbolRightField.click();
    }
    public void clearSymbolRightField(){
        currencySymbolRightField.clear();
    }
    public void setCurrencySymbolRightField(String symbolRightField){
        currencySymbolRightField.sendKeys(symbolRightField);
    }
    //DecimalPlacesField
    public void clickDecimalPlacesField(){
        currencyDecimalPlacesField.click();
    }
    public void clearDecimalPlacesField(){
        currencyDecimalPlacesField.clear();
    }
    public void setCurrencyDecimalPlacesField(String decimalPlacesField){
        currencyDecimalPlacesField.sendKeys(decimalPlacesField);
    }
    //ValueField
    public void clickValueField(){
        currencyValueField.click();
    }
    public void clearValueField(){
        currencyValueField.clear();
    }
    public void setCurrencyValueField(double valueField){
        currencyValueField.sendKeys(String.valueOf(valueField));
    }
    //StatusButton
    public void clickStatusButton(){
        currencyStatusButton.click();
    }
    public void clickStatusEnabledButton(){
        currencyStatusEnabledButton.click();
    }
    public void setCurrencyStatusButton(String statusButton){
        currencyStatusButton.sendKeys(statusButton);
    }

    private void fillTitleField(ICurrency currency){
        clickCurrencyTitleField();
        clearCurrencyTitleField();
        setCurrencyTitleField(currency.getCurrencyTitleField());
    }
    private void fillCodeField(ICurrency currency){
        clickCurrencyCodeField();
        clearCurrencyCodeField();
        setCurrencyCodeField(currency.getCurrencyCodeField());
    }
    private void fillSymbolLeftField(ICurrency currency){
        clickSymbolLeftField();
        clearSymbolLeftField();
        setCurrencySymbolLeftField(currency.getCurrencySymbolLeftField());
    }
    private void fillSymbolRightField(ICurrency currency){
        clickSymbolRightField();
        clearSymbolRightField();
        setCurrencySymbolRightField(currency.getCurrencySymbolRightField());
    }
    private void fillDecimalPlacesField(ICurrency currency) {
        clickDecimalPlacesField();
        clearDecimalPlacesField();
        setCurrencyDecimalPlacesField(currency.getCurrencyDecimalPlacesField());
    }
    private void fillValueField(ICurrency currency) {
        clickValueField();
        clearValueField();
        setCurrencyValueField(currency.getCurrencyValueField());
    }
    private void chooseStatusEnabled() {
        clickStatusButton();
        clickStatusEnabledButton();
    }
    private void fillAllFields(ICurrency currency){
        fillTitleField(currency);
        fillCodeField(currency);
        fillSymbolLeftField(currency);
        fillSymbolRightField(currency);
        fillDecimalPlacesField(currency);
        fillValueField(currency);
        chooseStatusEnabled();
    }
    public CurrenciesPage addNewCurrency(ICurrency currency){
        fillAllFields(currency);
        clickSaveButton();
        return new CurrenciesPage(driver);
    }

}
