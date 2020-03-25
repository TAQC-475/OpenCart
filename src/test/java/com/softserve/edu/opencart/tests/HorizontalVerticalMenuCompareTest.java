package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Categories;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HorizontalVerticalMenuCompareTest extends LocalTestRunner {
    @Test
    public void menuTest() throws InterruptedException {

        String topMenuCategories = loadApplication()
                .gotoMainMenuComponent()
                .chooseCategory(Categories.ROUTERS)
                .chooseCategory(Categories.DESKTOPS)
                .chooseCategory(Categories.LAPTOPS_AND_NOTEBOOKS)
                .chooseCategory(Categories.COMPONENTS)
                .chooseCategory(Categories.TABLETS)
                .chooseCategory(Categories.SOFTWARE)
                .chooseCategory(Categories.PHONES_AND_PDAS)
                .chooseCategory(Categories.CAMERAS)
                .chooseCategory(Categories.MP3_PLAYERS)
                .getAllCategories()
        ;
        Thread.sleep(1000);

//        System.out.println("*** : "+topMenuCategories);
//        Assert.assertTrue(topMenuCategories.contentEquals(topMenuCategories));


//        loadApplication().clickMenuTopByCategoryPartialName("Laptops");
//        Thread.sleep(1000);
//        loadApplication().clickMenuTopByPartialName("Desktops", "Mac (1)");
//        Thread.sleep(1000);

        // reading mainMenuItems
//        System.out.println("Top menu");
//        List<String> mainMenuItems = loadApplication()
//                .getMainMenuComponent()
//                .getMenuTopText();
//        System.out.println(mainMenuItems);
//
//        // reading leftProductSideBarItems
//        System.out.println("Left menu");
//        List<String> leftMenuItems = loadApplication()
//                .gotoProductsSidebarEmptyPage()
//                .getProductsSidebarEmptyPage()
//                .getLeftMenuItemListText();
//        System.out.println(leftMenuItems);

//        List<String> leftMenuItems = loadApplication()
//                .gotoLeftMenuBar()
//                .getLeftMenuItemListText();
//        System.out.println(leftMenuItems);


        // assert
//        Assert.assertEquals(mainMenuItems.toString(), leftMenuItems.toString());
    }

}
