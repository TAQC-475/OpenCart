package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.EmailBoxName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UNInboxComponent extends UNContentBaseComponent{
    private WebElement forwardButton;
    private WebElement deleteButton;
    private WebElement spamButton;
    private UKMoveDropdownComponent moveDropdown; //unimplemented
    private UKMoreDropdownComponent moreDropdown;

    private UNEmailListContainerComponent emails;

    public UNInboxComponent(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){
        emailBoxName = EmailBoxName.INBOX;
        emails = new UNEmailListContainerComponent(driver);

    }




}
