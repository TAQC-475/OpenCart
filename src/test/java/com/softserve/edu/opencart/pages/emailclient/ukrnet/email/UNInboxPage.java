package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import org.openqa.selenium.WebDriver;

public class UNInboxPage extends UNContentPanelBasePart {
    private UNEmailListComponent emailList;

    public UNInboxPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        emailList = new UNEmailListComponent(driver, EmailBoxName.INBOX);
    }


}
