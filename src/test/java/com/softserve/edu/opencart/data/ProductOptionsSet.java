package com.softserve.edu.opencart.data;


public class ProductOptionsSet {
    private String radioButtonOption;
    private String checkBoxOption;
    private String textOption;
    private String selectOption;
    private String textAreaOption;
    private String fileHashCodeOption;
    private String dateOption;
    private String timeOption;
    private String dateTimeOption;

    public ProductOptionsSet(String radioButtonOption, String checkBoxOption, String textOption, String selectOption, String textAreaOption, String fileHashCodeOption, String dateOption, String timeOption, String dateTimeOption) {
        this.radioButtonOption = radioButtonOption;
        this.checkBoxOption = checkBoxOption;
        this.textOption = textOption;
        this.selectOption = selectOption;
        this.textAreaOption = textAreaOption;
        this.fileHashCodeOption = fileHashCodeOption;
        this.dateOption = dateOption;
        this.timeOption = timeOption;
        this.dateTimeOption = dateTimeOption;
    }

    public String getRadioButtonOption() {
        return radioButtonOption;
    }

    public void setRadioButtonOption(String radioButtonOption) {
        this.radioButtonOption = radioButtonOption;
    }

    public String getCheckBoxOption() {
        return checkBoxOption;
    }

    public void setCheckBoxOption(String checkBoxOption) {
        this.checkBoxOption = checkBoxOption;
    }

    public String getTextOption() {
        return textOption;
    }

    public void setTextOption(String textOption) {
        this.textOption = textOption;
    }

    public String getSelectOption() {
        return selectOption;
    }

    public void setSelectOption(String selectOption) {
        this.selectOption = selectOption;
    }

    public String getTextAreaOption() {
        return textAreaOption;
    }

    public void setTextAreaOption(String textAreaOption) {
        this.textAreaOption = textAreaOption;
    }

    public String getFileHashCodeOption() {
        return fileHashCodeOption;
    }

    public void setFileHashCodeOption(String fileHashCodeOption) {
        this.fileHashCodeOption = fileHashCodeOption;
    }

    public String getDateOption() {
        return dateOption;
    }

    public void setDateOption(String dateOption) {
        this.dateOption = dateOption;
    }

    public String getTimeOption() {
        return timeOption;
    }

    public void setTimeOption(String timeOption) {
        this.timeOption = timeOption;
    }

    public String getDateTimeOption() {
        return dateTimeOption;
    }

    public void setDateTimeOption(String dateTimeOption) {
        this.dateTimeOption = dateTimeOption;
    }
}
