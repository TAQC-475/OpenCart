package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.ProductOptionsSet;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ProductInfoOptionsComponent {
    private final String OPTION_XPATH = ".//input[@value='%s']";
    protected WebDriver driver;

    //options
    private WebElement radioButtons;
    private WebElement checkBoxes;
    private WebElement textField;
    private WebElement selectField;
    private WebElement textAreaField;
    private WebElement dateField;
    private WebElement timeField;
    private WebElement dateTimeField;

    //options choice
    private WebElement radioButtonOption;
    private WebElement checkBoxOption;

    //


    public ProductInfoOptionsComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        radioButtons = driver.findElement(By.id("input-option218"));
        checkBoxes = driver.findElement(By.id("input-option223"));
        textField = driver.findElement(By.id("input-option208"));
        selectField = driver.findElement(By.id("input-option217"));
        textAreaField = driver.findElement(By.id("input-option209"));
        dateField = driver.findElement(By.id("input-option219"));
        timeField = driver.findElement(By.id("input-option221"));
        dateTimeField = driver.findElement(By.id("input-option220"));
    }

    public WebElement getRadioButtons() {
        return radioButtons;
    }

    public WebElement getRadioButtonOption() {
        return radioButtonOption;
    }

    public WebElement getCheckBoxes() {
        return checkBoxes;
    }

    public WebElement getCheckBoxOption() {
        return checkBoxOption;
    }

    public WebElement getTextField() {
        return textField;
    }

    public WebElement getSelectField() {
        return selectField;
    }

    public WebElement getTextAreaField() {
        return textAreaField;
    }

    public WebElement getDateField() {
        return dateField;
    }

    public WebElement getTimeField() {
        return timeField;
    }

    public WebElement getDateTimeField() {
        return dateTimeField;
    }

    public void clickRadioButton(){
        getRadioButtonOption().click();
    }

    public void clickCheckBox(){
        getCheckBoxOption().click();
    }

    public void clearTextField(){
        getTextField().clear();
    }

    public void clickTextField(){
        getTextField().click();
    }

    public void setTextField(String text){
        getTextField().sendKeys(text);
    }

    public Select getSelectDropDown(){
        return new Select(getSelectField());
    }

    public void clearTextAreaField(){
        getTextAreaField().clear();
    }

    public void clickTextAreaField(){
        getTextAreaField().click();
    }

    public void setTextAreaField(String text){
        getTextAreaField().sendKeys(text);
    }

    public void clearDateField(){
        getDateField().clear();
    }

    public void clickDateField(){
        getDateField().click();
    }

    public void setDateField(String date){
        getDateField().sendKeys(date);
    }

    public void clearTimeField(){
        getTimeField().clear();
    }

    public void clickTimeField(){
        getTimeField().click();
    }

    public void setTimeField(String time){
        getTimeField().sendKeys(time);
    }

    public void clearDateTimeField(){
        getDateTimeField().clear();
    }

    public void clickDateTimeField(){
        getDateTimeField().click();
    }

    public void setDateTimeField(String dateTime){
        getDateTimeField().sendKeys(dateTime);
    }

    //Functional
    public void selectRadioButtonByValue(String radioOption){
        radioButtonOption = getRadioButtons().
                findElement(By.xpath(String.format(OPTION_XPATH, radioOption)));
        clickRadioButton();
    }

    public void selectCheckBoxByValue(String checkOption){
        checkBoxOption = getCheckBoxes().
                findElement(By.xpath(String.format(OPTION_XPATH, checkOption)));
        clickCheckBox();
    }

    public void inputTextOption(String text){
        clickTextField();
        clearTextField();
        setTextField(text);
    }

    public void setSelectOptionByValue(String option){
        getSelectDropDown().selectByValue(option);
    }

    public void inputTextAreaOption(String text){
        clickTextAreaField();
        clearTextAreaField();
        setTextAreaField(text);
    }

    public void uploadFileByValue(String value) {
        ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('input-option222').setAttribute('value', arguments[1]);", value);
    }

    public void inputDateOption(String date){
        clickDateField();
        clearDateField();
        setDateField(date);
    }

    public void inputTimeOption(String time){
        clickTimeField();
        clearTimeField();
        setTimeField(time);
    }

    public void inputDateTimeOption(String dateTime){
        clickDateTimeField();
        clearDateTimeField();
        setDateTimeField(dateTime);
    }

    //Business logic

    public void setProductOptionsFull(ProductOptionsSet optionsSet){
        selectRadioButtonByValue(optionsSet.getRadioButtonOption());
        selectCheckBoxByValue(optionsSet.getCheckBoxOption());
        inputTextOption(optionsSet.getTextOption());
        setSelectOptionByValue(optionsSet.getSelectOption());
        inputTextAreaOption(optionsSet.getTextAreaOption());
        uploadFileByValue(optionsSet.getFileHashCodeOption());
        inputDateOption(optionsSet.getDateOption());
        inputTimeOption(optionsSet.getTimeOption());
        inputDateTimeOption(optionsSet.getDateTimeOption());
    }


}
