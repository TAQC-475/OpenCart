package com.softserve.edu.opencart.pages.emailclient.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class FooterServicesPart{

    private WebDriver driver;

    private WebElement searchField;
    private WebElement searchButton;
    private WebElement weather;
    private WebElement womenSite;
    private WebElement shop;
    private WebElement news;
    private WebElement maps;
    private WebElement translate;
    private WebElement dating;
    private WebElement videos;
    private WebElement cars;
    private WebElement sport;
    private WebElement allServices;


    public FooterServicesPart(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements(){
        //Coming soon
    }
}
