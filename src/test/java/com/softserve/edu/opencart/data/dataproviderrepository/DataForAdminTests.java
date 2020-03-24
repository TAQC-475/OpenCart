package com.softserve.edu.opencart.data.dataproviderrepository;

import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.creationProductAdminPanel.NewProductRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForAdminTests {
    @DataProvider(name = "addRouterFromAdmin")
    public Object[][] ProductsData(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewProductRepository.router().getProductName(),
                        NewProductRepository.router().getMetaTagTitle(),
                        NewProductRepository.router().getModel(),
                        NewProductRepository.router().getPrice(),
                        NewProductRepository.router().getCategory()}
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
