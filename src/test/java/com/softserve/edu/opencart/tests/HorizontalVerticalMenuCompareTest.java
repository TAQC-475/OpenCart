package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.user.common.DropdownComponent;
import com.softserve.edu.opencart.pages.user.common.TopPart;
import com.softserve.edu.opencart.pages.user.search.ProductsSidebarPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HorizontalVerticalMenuCompareTest extends EpizyUserTestRunner {
    @Test
    public void menuTest() {

        // reading mainMenuItems
        List<String> mainMenuItems = loadApplication().getMainMenuComponent().getMenuItemListText();
        System.out.println(mainMenuItems);

        // reading leftProductSideBarItems
        List<String> leftMenuItems = loadApplication().gotoProductsSidebarEmptyPage().getProductsSidebarEmptyPage().getLeftMenuItemListText();
        System.out.println(leftMenuItems);

        // assert
        Assert.assertEquals(mainMenuItems.toString(), leftMenuItems.toString());
    }

}
