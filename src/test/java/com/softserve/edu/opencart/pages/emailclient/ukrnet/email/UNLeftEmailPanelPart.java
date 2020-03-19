package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.pages.emailclient.ukrnet.UNParentBasePart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UNLeftEmailPanelPart extends UNParentBasePart {
    private WebElement newLetterButton;
    private WebElement inbox;
    private WebElement drafts;
    private WebElement sent;
    private WebElement spam;
    private WebElement trash;
    private WebElement unread;
    private WebElement marked;
    private WebElement attachments;
    private WebElement addressBookButton;

    public UNLeftEmailPanelPart(WebDriver driver){
        super(driver);
    }

    private void initElements(){
        newLetterButton = driver.findElement(By.xpath("//div[@id='content']//button"));
        inbox = driver.findElement(By.xpath("//a[@data-folder='0']"));
        drafts = driver.findElement(By.xpath("//a[@data-folder=10002]"));
        sent = driver.findElement(By.xpath("//a[@data-folder=10001]"));
        spam = driver.findElement(By.xpath("//a[@data-folder='10003']"));
        trash = driver.findElement(By.xpath("//a[@data-folder='10004']"));
        unread = driver.findElement(By.xpath("//a[@data-folder='unread']"));
        marked = driver.findElement(By.xpath("//a[@data-folder='marked']"));
        attachments = driver.findElement(By.xpath("//a[@href='#attachments']"));
    }

    public WebElement getNewLetterButton() {
        return newLetterButton;
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

    public WebElement getUnread() {
        return unread;
    }

    public WebElement getMarked() {
        return marked;
    }

    public WebElement getAttachments() {
        return attachments;
    }

    public WebElement getAddressBookButton() {
        return addressBookButton;
    }


}
