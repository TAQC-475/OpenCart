package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProductsContainerComponent {
    private final String SHOPPING_CART_PRODUCT_COMPONENT_XPATH = "//div[@class = 'table-responsive']//table[@class = 'table table-bordered']/tbody/tr";

    protected WebDriver driver;

    private List<ShoppingCartProductComponent> shoppingCartProductComponents;

    public ShoppingCartProductsContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void initElements() {
        shoppingCartProductComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(SHOPPING_CART_PRODUCT_COMPONENT_XPATH))) {
            shoppingCartProductComponents.add(new ShoppingCartProductComponent(current));
        }
    }

    public List<ShoppingCartProductComponent> getShoppingCartProductComponents() {
        return shoppingCartProductComponents;
    }

    public int getShoppingCartProductComponentCount(){
        return getShoppingCartProductComponents().size();
    }

    public List<String> getShoppingCartProductComponentNames() {
        List<String> shoppingCartProductComponentNames = new ArrayList<>();
        for (ShoppingCartProductComponent current : getShoppingCartProductComponents())
        {
            shoppingCartProductComponentNames.add(current.getProductNameText());
        }
        return shoppingCartProductComponentNames;
    }

    protected ShoppingCartProductComponent getShoppingCartProductComponentByName(String productName){
        ShoppingCartProductComponent result = null;
        for(ShoppingCartProductComponent current: getShoppingCartProductComponents()){
            if(current.getProductNameText().toLowerCase().equals(productName.toLowerCase())){
                result = current;
                break;
            }
        }
        if(result == null){
            throw new RuntimeException(String.format("Product with name: %s not found", productName));
        }
        return result;
    }

    public String getShoppingCartProductUnitPriceByName(String productName){
        return getShoppingCartProductComponentByName(productName).getUnitPriceText();
    }

    public ShoppingCartProductComponent getShoppingCartProductComponentByName(Product product){
        return getShoppingCartProductComponentByName(product.getName());
    }
}
