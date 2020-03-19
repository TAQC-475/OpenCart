package com.softserve.edu.opencart.pages.emailclient.metaua.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class LeftEmailsPanelPart extends LoggedMenuBarPart {

    private WebElement newLetterButton;
    private WebElement checkEmailsButton;
    private WebElement inbox;
    private WebElement drafts;
    private WebElement sent;
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
        inbox = driver.findElement(By.xpath("(//div[@class='left_boxes']//a)[1]"));
        drafts = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Drafts')]"));
        sent = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Sent')]"));
        spam = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Spam')]"));
        trash = driver.findElement(By.xpath("//a[contains(@href, 'INBOX.Trash')]"));
        addressBookButton = driver.findElement(By.id("id_address_book"));
    }

    public WebElement getNewLetterButton() {
        return newLetterButton;
    }

    public WebElement getCheckEmailsButton() {
        return checkEmailsButton;
    }

    public WebElement getInbox() {
        return inbox;
    }

    public WebElement getDrafts() {
        return drafts;
    }

    public WebElement getSent() {
        return sent;
    }

    public WebElement getSpam() {
        return spam;
    }

    public WebElement getTrash() {
        return trash;
    }

    public WebElement getAddressBookButton() {
        return addressBookButton;
    }



    public EmailsListPage goToInbox(){
        getInbox().click();
        return new EmailsListPage(driver, EmailBoxName.INBOX);
    }

    public EmailsListPage goToDrafts(){
        getDrafts().click();
        return new EmailsListPage(driver, EmailBoxName.DRAFTS);
    }

    public EmailsListPage goToSent(){
        getSent().click();
        return new EmailsListPage(driver, EmailBoxName.SENT);
    }

    public EmailsListPage goToSpam(){
        getSpam().click();
        return new EmailsListPage(driver, EmailBoxName.SPAM);
    }

    public EmailsListPage goToTrash(){
        getTrash().click();
        return  new EmailsListPage(driver, EmailBoxName.TRASH);
    }


}
