package com.softserve.edu.opencart.pages.emailclient.metaua.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class EmailListContainerComponent {
    private List<EmailListItemComponent> emailListItemComponents;
    private WebDriver driver;

    private final String XPATH_EMAIL_LIST_LOCATOR = "//table[@id='messlist']//tr[td and @style]";
    private final String EMAIL_NOT_FOUND_EXCEPTION_FORMAT = "No new reset password messages found from %s";

    private final String APPLICATION_EMAIL_NAME = "Your Store";
    private final String RESET_ACCOUNT_PASSWORD_TOPIC = "Your Store - Password reset request";

    public EmailListContainerComponent(WebDriver driver){
        this.driver = driver;
        initElements();

    }

    private void initElements(){
        emailListItemComponents = new LinkedList<>();
        for(WebElement currentEmailListItem : driver.findElements(By.xpath(XPATH_EMAIL_LIST_LOCATOR))){
            emailListItemComponents.add(new EmailListItemComponent(currentEmailListItem));
        }
    }

    public List<EmailListItemComponent> getEmailListItemComponents() {
        return emailListItemComponents;
    }


    private boolean isMessageMatches(EmailListItemComponent emailComponent){
        return emailComponent.getSenderNameText().equalsIgnoreCase(APPLICATION_EMAIL_NAME) &&
                emailComponent.getTopicText().equalsIgnoreCase(RESET_ACCOUNT_PASSWORD_TOPIC);
    }


    public EmailListItemComponent findResetPasswordEmail() throws RuntimeException{
        for(EmailListItemComponent component : getEmailListItemComponents()){
            if(isMessageMatches(component)){
                return component;
            }
        }
        throw new RuntimeException(String.format(EMAIL_NOT_FOUND_EXCEPTION_FORMAT, RESET_ACCOUNT_PASSWORD_TOPIC));
    }

    public EmailPage goToEmail() throws RuntimeException{
        findResetPasswordEmail().clickSenderName();
        return new EmailPage(driver);
    }


}
