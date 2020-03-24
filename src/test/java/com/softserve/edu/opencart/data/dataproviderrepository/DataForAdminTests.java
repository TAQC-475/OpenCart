package com.softserve.edu.opencart.data.dataproviderrepository;

import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.categories.MenuCategoryRepository;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProductRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForAdminTests {
    @DataProvider
    public Object[][] addRouterProduct(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.router().getProductName(),
                        NewProductRepository.router().getMetaTagTitle(),
                        NewProductRepository.router().getModel(),
                        NewProductRepository.router().getPrice(),
                        NewProductRepository.router().getCategory()}
        };
    }

    @DataProvider
    public Object[][] addRoutersCategory(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        MenuCategoryRepository.routers().getName(),
                        MenuCategoryRepository.routers().getTitle(),
                        MenuCategoryRepository.routers().getParent()}
        };
    }

    @DataProvider(name = "dataAdmin")
    public Object[][] NewProductsData(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.cyrillicProduct().getProductName(),
                        NewProductRepository.cyrillicProduct().getMetaTagTitle(),
                        NewProductRepository.cyrillicProduct().getModel()}
        };
    }
}
