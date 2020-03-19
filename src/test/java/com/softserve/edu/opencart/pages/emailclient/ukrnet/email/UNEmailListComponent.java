package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import com.softserve.edu.opencart.data.ResetEmailEntity;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UNEmailListComponent extends UNContentPanelBasePart {
    private WaitUtils waitUtils;
    private EmailBoxName boxName;
    private final String XPATH_LAST_UNREAD_FORMAT =
            "//table//tr[1][contains(@class, 'unread')]//td[contains(@class, 'subject')]//a[contains(text(), \'%s\')]";


    public UNEmailListComponent(WebDriver driver, EmailBoxName boxName){
        super(driver);
        this.boxName = boxName;
        initElements();
    }

    private void initElements(){
        waitUtils = new WaitUtils(driver, 30);
    }

    public By getUnreadLocator(String subject){
        return By.xpath(String.format(XPATH_LAST_UNREAD_FORMAT, subject));

    }
    public WebElement findLastUnreadEmail(String subject){
        waitUtils.waitForElementClickability(getUnreadLocator(subject));
        return driver.findElement(getUnreadLocator(subject));
    }

    public void clickLastUnreadMail(String subject){
        findLastUnreadEmail(subject).click();
    }


}
