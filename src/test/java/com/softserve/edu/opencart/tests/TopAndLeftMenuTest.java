package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class TopAndLeftMenuTest extends LocalTestRunner {
    @Test
    public void menuTest() throws InterruptedException {

//        Map<String, List<String>> topMenuCategories = loadApplication()
//                .gotoMainMenuComponent()
//                .getMenuCategoriesMap();

        Map<String, List<String>> leftMenuItems = loadApplication()
                .gotoMainMenuComponent()
                .gotoEmptyLeftMenu()
                .getLeftMenuCategoriesMap();

        System.out.println(leftMenuItems);

//        System.out.println(topMenuCategories);
//        Assert.assertEquals(topMenuCategories, topMenuCategories);
        Assert.assertEquals(leftMenuItems, leftMenuItems);


//        MainMenuComponent menuComponent = loadApplication().gotoMainMenuComponent()
//                .chooseCategory(Categories.DESKTOPS);
//
//        String topCategory = menuComponent.getAllCategories();
//
//        List<String> leftMenu = menuComponent
//                .gotoFullLeftMenu()
//                .getLeftMenuItemListText();
//
//        System.out.println(leftMenu.toString());
//
//        System.out.println("*** : "+topMenuCategories);
//        Assert.assertEquals(topMenuCategories,topMenuCategories);


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

    }

}