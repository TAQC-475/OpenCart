package com.softserve.edu.opencart.pages.emailclient.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class EmailListContainerComponent {
    private List<EmailListItemComponent> emailListItemComponents;
    private WebDriver driver;

    private final String XPATH_EMAIL_LIST_ITEM_LOCATOR = "//table[@id='messlist']//tr[td]";

    //private final String exception

    public EmailListContainerComponent(WebDriver driver){
        this.driver = driver;
        initElements();

    }

    private void initElements(){
        emailListItemComponents = new LinkedList<>();
        for(WebElement currentEmailListItem : driver.findElements(By.xpath(XPATH_EMAIL_LIST_ITEM_LOCATOR))){
            emailListItemComponents.add(new EmailListItemComponent(currentEmailListItem));
        }
    }

    public List<EmailListItemComponent> getEmailListItemComponents() {
        return emailListItemComponents;
    }

    public EmailListItemComponent findEmailListItemBySenderName(String senderName){
        for(EmailListItemComponent component : getEmailListItemComponents()){
            if(component.getSenderName().equals(senderName)){
                return component;
            }
        }
        return null;
    }


}
