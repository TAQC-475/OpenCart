package com.softserve.edu.opencart.pages.emailclient.ukrnet.email;

import com.softserve.edu.opencart.data.ResetEmailEntity;
import com.softserve.edu.opencart.pages.user.account.ChangePasswordPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class UNEmailPage extends UNContentPanelBasePart{
    private UNEmailComponent email;

    public UNEmailPage(WebDriver driver){
        super(driver);

    }
    private void initElements(){
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
