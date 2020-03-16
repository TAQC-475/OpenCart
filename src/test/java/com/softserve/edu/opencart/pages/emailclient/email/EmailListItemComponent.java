package com.softserve.edu.opencart.pages.emailclient.email;
import org.openqa.selenium.WebElement;

public class EmailListItemComponent  {
    private WebElement emailListItem;
    private WebElement senderName;
    private WebElement topic;
    private WebElement date;
    private WebElement size;

    private final String XPATH_SENDER_NAME_LOCATOR = ".//a[1]";
    private final String XPATH_TOPIC_LOCATOR = ".//a[2]";


    public EmailListItemComponent(WebElement emailListItem){
        this.emailListItem = emailListItem;
        initElements();
    }

    private void initElements(){

    }
}
