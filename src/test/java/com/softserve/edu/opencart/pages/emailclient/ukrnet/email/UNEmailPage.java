package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import org.openqa.selenium.WebDriver;

public class UNEmailPage extends UNContentPanelBasePart {
    private UNContentBaseComponent content;

    public UNEmailPage(WebDriver driver){
        super(driver);

    }

    private void initElements(){
        content = new UNInboxComponent(driver);
    }
}
