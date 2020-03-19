package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ViewCartComponent {
    private final String EMPTY_MESSAGE_XPATH = "//p[@class='text-center']";
    private final String PRODUCT_TABLE_XPATH = "//table[@class='table table-striped']//tbody/tr";
    private final String TOTAL_SUMMARY_XPATH = "//table[@class='table table-bordered']//tbody/tr";
    private final String TOTAL_ELEMENT_XPATH = "./td[2]";
    //
    protected WebDriver driver;
    //
    private WebElement cartTotalMsg;
    //
    private List<ViewCartProductComponent> cartProductTable;
    private List<WebElement> cartSummary;
    private WebElement subTotal;
    private WebElement ecoTax;
    private WebElement vatTax;
    private WebElement totalPrice;

    public ViewCartComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        //
        cartTotalMsg = driver.findElement(By.id("cart-total"));
        // init elements
        cartProductTable = new ArrayList<>();
        for (WebElement product : driver.findElements(By.xpath(PRODUCT_TABLE_XPATH))) {
            cartProductTable.add(new ViewCartProductComponent(product));
        }

        cartSummary = new ArrayList<>();
        for (WebElement summaryPart : driver.findElements(By.xpath(TOTAL_SUMMARY_XPATH))) {
            cartSummary.add(summaryPart);
        }
        if (!cartSummary.isEmpty()){
            subTotal = cartSummary.get(0).findElement(By.xpath(TOTAL_ELEMENT_XPATH));
            ecoTax = cartSummary.get(1).findElement(By.xpath(TOTAL_ELEMENT_XPATH));
            vatTax = cartSummary.get(2).findElement(By.xpath(TOTAL_ELEMENT_XPATH));
            totalPrice = cartSummary.get(3).findElement(By.xpath(TOTAL_ELEMENT_XPATH));
        }

    }

    public List<ViewCartProductComponent> getCartProductTable() {
        return cartProductTable;
    }

    public List<WebElement> getCartSummary() {
        return cartSummary;
    }

    public WebElement getSubTotal() {
        return subTotal;
    }

    public String getSubTotalText() {
        return getSubTotal().getText();
    }

    public WebElement getEcoTax() {
        return ecoTax;
    }

    public String getEcoTaxText() {
        return getEcoTax().getText();
    }

    public WebElement getVatTax() {
        return vatTax;
    }

    public String getVatTaxText() {
        return getVatTax().getText();
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public String getTotalPriceText() {
        return getTotalPrice().getText();
    }

    public WebElement getEmptyCartMsg() {
        return driver.findElement(By.xpath(EMPTY_MESSAGE_XPATH));
    }

    public String getEmptyCartMsgText() {
        return driver.findElement(By.xpath(EMPTY_MESSAGE_XPATH)).getText();
    }

    public WebElement getCartTotal() {
        return cartTotalMsg;
    }

    public String getCartTotalText() {
        return getCartTotal().getText();
    }

    public String getCartTotalAmount() {
        return getCartTotalText().split("")[0];
    }

    protected ViewCartProductComponent getViewProductComponentByName(Product product)
    {
        ViewCartProductComponent result = null;
        for (ViewCartProductComponent current : getCartProductTable())
        {
            if (current.getNameText().toLowerCase()
                    .equals(product.getName().toLowerCase()))
            {
                result = current;
                break;
            }
        }
        if (result == null)
        {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("ProductName: " + product.getName() + " not Found.");
        }
        return result;
    }

    public void removeViewProductComponent(Product product)
    {
        getViewProductComponentByName(product).removeProductFromCart();
    }

    public String getViewProductComponentName(Product product)
    {
        return getViewProductComponentByName(product).getNameText();
    }

    public String getViewProductComponentQuantity(Product product)
    {
        return getViewProductComponentByName(product).getQuantityText();
    }

    public String getViewProductComponentPrice(Product product)
    {
        return getViewProductComponentByName(product).getPriceText();
    }
}
