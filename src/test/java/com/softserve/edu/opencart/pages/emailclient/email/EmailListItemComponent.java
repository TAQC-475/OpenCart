package com.softserve.edu.opencart.pages.emailclient.email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailListItemComponent  {
    private WebElement emailListItem;

    private WebElement senderName;
    private WebElement topic;
    private WebElement emailStatus;

    private final String XPATH_SENDER_NAME_LOCATOR = ".//td[4]//a";
    private final String XPATH_TOPIC_LOCATOR = ".//td[5]//a";


    public EmailListItemComponent(WebElement emailListItem){
        this.emailListItem = emailListItem;
        initElements();
    }

    private void initElements(){
        senderName = emailListItem.findElement(By.xpath(XPATH_SENDER_NAME_LOCATOR));
        topic = emailListItem.findElement(By.xpath(XPATH_TOPIC_LOCATOR));
    }

    public WebElement getEmailListItem() {
        return emailListItem;
    }

    public WebElement getSenderName() {
        return senderName;
    }

    public WebElement getTopic() {
        return topic;
    }

    public WebElement getEmailStatus() {
        return emailStatus;
    }

    public void clickSenderName(){
        getSenderName().click();
    }

    public void clickTopic(){
        getTopic().click();
    }

    public String getSenderNameText(){
        return getSenderName().getText();
    }

    public String getTopicText(){
        return getTopic().getText();
    }


}
