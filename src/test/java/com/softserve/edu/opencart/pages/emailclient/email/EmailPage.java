package com.softserve.edu.opencart.pages.emailclient.email;

import com.softserve.edu.opencart.pages.user.account.ChangePasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class EmailPage extends LeftEmailsPanelPart {
    private WebElement upperReplyButton;
    private WebElement upperForwardButton;
    private WebElement upperDeleteButton;
    private WebElement upperSpamButton;
    private WebElement upperMoveSelect;
    //.....
    private WebElement messageBody;

    public EmailPage(WebDriver driver) {
        super(driver);

    }

    private void initElements(){
        upperReplyButton = driver.findElement(By.id("id_answer1"));
        upperForwardButton = driver.findElement(By.id("id_forward1"));
        upperDeleteButton = driver.findElement(By.id("id_delete1"));
        upperSpamButton = driver.findElement(By.id("id_spam1"));
        upperMoveSelect = driver.findElement(By.id("move_select1"));
        messageBody = driver.findElement(By.id("//div[@id='message_body']"));
    }

    public WebElement getUpperReplyButton() {
        return upperReplyButton;
    }

    public WebElement getUpperForwardButton() {
        return upperForwardButton;
    }

    public WebElement getUpperDeleteButton() {
        return upperDeleteButton;
    }

    public WebElement getUpperSpamButton() {
        return upperSpamButton;
    }

    public WebElement getUpperMoveSelect() {
        return upperMoveSelect;
    }

    public WebElement getMessageBody() {
        return messageBody;
    }

    //click ...

    public WebElement getLinkFromMessageBody(){
        return messageBody.findElement(By.xpath("//a"));
    }
    public void clickLinkInMessageBody(){
        getLinkFromMessageBody().click();
    }

    //tab methods
    protected ArrayList<String> getTabsHandles() { //atomic
        return new ArrayList<>(driver.getWindowHandles());
    }

    protected int getLastTabIndex() { //atomic
        return getTabsHandles().size() - 1;
    }

    protected void switchToNewTab() { //atomic
        driver.switchTo().window(getTabsHandles().get(getLastTabIndex()));
    }

    public ChangePasswordPage goToResetPasswordPage(){
        clickLinkInMessageBody();
        switchToNewTab();
        return new ChangePasswordPage(driver);
    }
}
