package com.softserve.edu.opencart.pages.emailclient.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class LeftEmailsPanelPart extends LoggedMenuBarPart {

    private WebElement newLetterButton;
    private WebElement checkEmailsButton;
    private WebElement inbox;
    private WebElement drafts;
    private WebElement send;
    private WebElement spam;
    private WebElement trash;
    private WebElement addressBookButton;


    public LeftEmailsPanelPart(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        newLetterButton = driver.findElement(By.id("id_send_email"));
        checkEmailsButton = driver.findElement(By.id("id_check_email"));
        inbox = driver.findElement(By.xpath("//div[@class='left_boxes']//a)[1]"));
        drafts = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Drafts')]"));
        send = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Sent')]"));
        spam = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Spam')]"));
        trash = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Trash')]"));
        addressBookButton = driver.findElement(By.id("id_address_book"));
    }

}
