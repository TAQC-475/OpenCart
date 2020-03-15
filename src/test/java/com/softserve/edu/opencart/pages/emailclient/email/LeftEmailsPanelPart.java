package com.softserve.edu.opencart.pages.emailclient.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class LeftEmailsPanelPart extends LoggedMenuBarPart {
    private WebElement checkEmailsButton;
    private WebElement newLetterButton;
    private WebElement inbox;
    private WebElement drafts;
    private WebElement send;
    private WebElement spam;
    private WebElement basket;
    private WebElement addressBookButton;


    public LeftEmailsPanelPart(WebDriver driver){
        super(driver);
    }


}
