package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UNEmailComponent extends UNContentBaseComponent {
    private WebElement messageBody;
    private final String XPATH_BODY_LINK_FORMAT = ".//a[contains(text(), %s)]";

    public UNEmailComponent(WebDriver driver){
        super(driver);
    }

    private void initElements(){
        messageBody = driver.findElement(By.className("readmsg__body"));
    }

    public WebElement getMessageBody() {
        return messageBody;
    }
    private By getRelativeBodyLinkLocator(String linkPart){
        return By.xpath(String.format(XPATH_BODY_LINK_FORMAT, linkPart));
    }

    private WebElement findLink(String linkPart){
        return getMessageBody().findElement(getRelativeBodyLinkLocator(linkPart));
    }

    public void clickBodyLink(String linkPart){
        findLink(linkPart).click();
    }

}
