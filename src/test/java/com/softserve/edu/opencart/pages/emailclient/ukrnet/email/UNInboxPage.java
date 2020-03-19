package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import com.softserve.edu.opencart.data.ResetEmailEntity;
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

    public UNEmailPage gotoResetPasswordEmail(ResetEmailEntity resetEmail){
        emailList.clickLastUnreadMail(resetEmail.getSubject());
        return new UNEmailPage(driver);
    }
}
