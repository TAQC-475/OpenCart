package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import com.softserve.edu.opencart.data.ResetEmailEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UNInboxPage extends UNRightContentPanelBasePart {

    private WebElement forwardButton;
    private WebElement deleteButton;
    private WebElement spamButton;
    //...

    private UNEmailListComponent emailList;

    public UNInboxPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        emailList = new UNEmailListComponent(driver, EmailBoxName.INBOX);

        messageControls = driver.findElement(By.className("controls"));

        forwardButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'mforward')]"));
        deleteButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'remove')]"));
        spamButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'spam')]"));
    }

    public UNEmailPage gotoResetPasswordEmail(ResetEmailEntity resetEmail){
        emailList.clickLastUnreadMail(resetEmail.getSubject());
        return new UNEmailPage(driver);
    }
}
