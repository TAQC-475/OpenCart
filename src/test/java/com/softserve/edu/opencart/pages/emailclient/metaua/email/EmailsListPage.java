package com.softserve.edu.opencart.pages.emailclient.metaua.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import org.openqa.selenium.WebDriver;

public class EmailsListPage extends LeftEmailsPanelPart{
    private final EmailBoxName boxName;
    private EmailListContainerComponent emails;

    public EmailsListPage(WebDriver driver, EmailBoxName boxName) {
        super(driver);
        this.boxName = boxName;
        initElements();
    }

    private void initElements(){
        emails = new EmailListContainerComponent(driver);
    }

    public EmailPage goToResetPasswordEmail() {
        emails.goToEmail();
        return new EmailPage(driver);

    }
}
