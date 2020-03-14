package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BreadCrumbPart {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getPriceOfShoppingCartElement(WebElement shoppingCartElement){
        return shoppingCartElement.findElement(By.xpath("/td[@class = 'text-right'][1]")).getText();
    }
}
