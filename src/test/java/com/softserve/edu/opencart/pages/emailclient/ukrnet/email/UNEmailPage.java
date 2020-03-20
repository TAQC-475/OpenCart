package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.ResetEmailEntity;
import com.softserve.edu.opencart.pages.user.account.ChangePasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UNEmailPage extends UNRightContentPanelBasePart{
    private WebElement replyButton;
    private WebElement forwardButton;
    private WebElement deleteButton;
    private WebElement spamButton;

    private UNEmailComponent email;

    public UNEmailPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        messageControls = driver.findElement(By.className("controls"));

        replyButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'reply')]"));
        forwardButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'forward')]"));
        deleteButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'remove')]"));
        spamButton = messageControls.findElement(By.xpath(".//a[contains(@class, 'spam')]"));

        email = new UNEmailComponent(driver);
    }

    public ArrayList<String> getTabsHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public int getLastTabIndex() {
        return getTabsHandles().size() - 1;
    }

    public void switchToNewTab() {
        driver.switchTo().window(getTabsHandles().get(getLastTabIndex()));
    }

    public ChangePasswordPage goToChangePasswordPage(ResetEmailEntity resetEmail){
        email.clickBodyLink(resetEmail.getBodyLinkPart());
        switchToNewTab();
        return new ChangePasswordPage(driver);
    }
}
