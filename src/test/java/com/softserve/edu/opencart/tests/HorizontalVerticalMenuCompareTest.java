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
    public void menuTest() throws InterruptedException {

//        try {
//            loadApplication().gotoProductsSidebarEmptyPage().myMethod1();//checkFullEmptyPage();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //System.out.println(""+mainMenuItems1);

//        for(WebElement w:loadApplication().getMainMenuComponent().getMenuItemList()){
//
//        }

        loadApplication()
                .getMainMenuComponent()
                .clickMenuTopByCategoryPartialName("Desktops")
        ;
        Thread.sleep(1000);
//        loadApplication().clickMenuTopByCategoryPartialName("Laptops");
//        Thread.sleep(1000);
//        loadApplication().clickMenuTopByPartialName("Desktops", "Mac (1)");
//        Thread.sleep(1000);

        // reading mainMenuItems
//        System.out.println("Top menu");
//        List<String> mainMenuItems = loadApplication().getMainMenuComponent().getMenuItemListText();
//        System.out.println(mainMenuItems);
//
//        // reading leftProductSideBarItems
//        System.out.println("Left menu");
//        List<String> leftMenuItems = loadApplication().gotoProductsSidebarEmptyPage().getProductsSidebarEmptyPage().getLeftMenuItemListText();
//        System.out.println(leftMenuItems);

        // assert
//        Assert.assertEquals(mainMenuItems.toString(), leftMenuItems.toString());
    }

}
