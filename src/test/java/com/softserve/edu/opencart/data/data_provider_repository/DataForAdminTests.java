package com.softserve.edu.opencart.data.data_provider_repository;

import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.categories.MenuCategoryRepository;
import com.softserve.edu.opencart.data.creation_product_admin_panel.NewProductRepository;
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

    @DataProvider
    public Object[][] cyrillicProductData() {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.cyrillicProduct().getProductName(),
                        NewProductRepository.cyrillicProduct().getMetaTagTitle(),
                        NewProductRepository.cyrillicProduct().getModel()}
        };
    }
}
