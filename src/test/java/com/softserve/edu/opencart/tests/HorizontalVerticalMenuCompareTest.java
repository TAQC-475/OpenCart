package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.MenuItems;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalVerticalMenuCompareTest extends EpizyUserTestRunner {
    @Test
    public void menuTest() throws InterruptedException {

        loadApplication()
                .getMainMenuComponent()
//                .clickMenuTopByCategoryPartialName("Desktops")
//                .clickMenuTopByPartialName("Desktops","Show All Desktops")
                .chooseCategory1(MenuItems.TV)
                .chooseCategory(MenuItems.DESKTOPS)
//                .chooseCategory(MenuItems.TV)
        ;
        Thread.sleep(1000);

//        boolean b = true;
//        Assert.assertTrue(b);

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
