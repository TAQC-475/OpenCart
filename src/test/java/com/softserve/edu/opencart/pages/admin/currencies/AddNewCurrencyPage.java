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

    public  AddNewCurrencyPage(WebDriver driver) {
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
    //SymbolLeftField and SymbolRightField
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

    /**
     * This method clicks on the title field, clears the field, to make sure the field is empty
     * and writes information about a new currency
     */
    private void fillTitleField(ICurrency currency){
        clickCurrencyTitleField();
        clearCurrencyTitleField();
        setCurrencyTitleField(currency.getCurrencyTitleField());
    }
    /**
     * This method clicks on the code field, clears the field
     * and writes information about a new currency
     */
    private void fillCodeField(ICurrency currency){
        clickCurrencyCodeField();
        clearCurrencyCodeField();
        setCurrencyCodeField(currency.getCurrencyCodeField());
    }
    /**
     * This methods click on the symbol field, clear the field
     * and write information about a new currency
     */
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
    /**
     * This method clicks on the decimal places field, clears the field
     * and writes information about a new currency
     */
    private void fillDecimalPlacesField(ICurrency currency) {
        clickDecimalPlacesField();
        clearDecimalPlacesField();
        setCurrencyDecimalPlacesField(currency.getCurrencyDecimalPlacesField());
    }
    /**
     * This method clicks on the value field, clears the field
     * and writes information about a new currency
     */
    private void fillValueField(ICurrency currency) {
        clickValueField();
        clearValueField();
        setCurrencyValueField(currency.getCurrencyValueField());
    }
    /**
     * This method chooses the Enable status
     */
    private void chooseStatusEnabled() {
        clickStatusButton();
        clickStatusEnabledButton();
    }
    /**
     * This method fills all fields about new currency
     */
    private void fillAllFields(ICurrency currency){
        fillTitleField(currency);
        fillCodeField(currency);
        fillSymbolLeftField(currency);
        fillSymbolRightField(currency);
        fillDecimalPlacesField(currency);
        fillValueField(currency);
        chooseStatusEnabled();
    }
    /**
     * This method fills all fields about new currency, click on save button
     * and return a currency page
     */
    public CurrenciesPage addNewCurrency(ICurrency currency){
        fillAllFields(currency);
        clickSaveButton();
        return new CurrenciesPage(driver);
    }

}
