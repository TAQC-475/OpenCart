package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.user.common.MainMenuComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopAndLeftMenuTest extends LocalTestRunner {

    /**
     * loading application, go to top menu on home page, getting all top menu category names, going to left menu,
     * getting all left menu categories, verifying that the menu categories match
     */
    @Test
    public void menuTest() {

        MainMenuComponent menuComponent = loadApplication().gotoMainMenuComponent();

        Assert.assertEquals(menuComponent.getMenuCategoriesMap(),
                            menuComponent.gotoEmptyLeftMenu().getLeftMenuCategoriesMap());
    }

}