package com.softserve.edu.opencart.pages.emailclient.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import org.openqa.selenium.WebDriver;

public class EmailsListPage extends LeftEmailsPanelPart{
    private final EmailBoxName boxName;

    public EmailsListPage(WebDriver driver, EmailBoxName boxName) {
        super(driver);
        this.boxName = boxName;
    }

    private void initElements(){
        //coming soon
    }
}
