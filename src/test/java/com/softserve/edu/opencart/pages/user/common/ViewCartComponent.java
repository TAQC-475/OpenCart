package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ViewCartComponent {
    private final String REPLACEMENT_REGEX = "[^0123456789.,]";
    private final String EMPTY_MESSAGE_XPATH = "//p[@class='text-center']";
    private final String PRODUCT_TABLE_XPATH = "//table[@class='table table-striped']//tbody/tr";
    private final String SUB_TOTAL_XPATH = "//td/strong[text()='Sub-Total']/../following-sibling::td";
    private final String ECO_TAX_XPATH = "//td/strong[text()='Eco Tax (-2.00)']/../following-sibling::td";
    private final String VAT_XPATH = "//td/strong[text()='VAT (20%)']/../following-sibling::td";
    private final String TOTAL_XPATH = "//td/strong[text()='Total']/../following-sibling::td";
    //
    protected WebDriver driver;
    //
    private WaitUtils cartWait;
    private WebElement cartTotalMsg;
    //
    private WebElement cartEmptyMessage;
    private List<ViewCartProductComponent> cartProductTable;
    private WebElement subTotal;
    private WebElement ecoTax;
    private WebElement vatTax;
    private WebElement totalPrice;

    public ViewCartComponent(WebDriver driver) {
        this.driver = driver;
        this.cartWait = new WaitUtils(driver, 5);
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
    }

    public List<ViewCartProductComponent> getCartProductTable() {
        return cartProductTable;
    }

    public WebElement getSubTotal() {
        subTotal = driver.findElement(By.xpath(SUB_TOTAL_XPATH));
        return subTotal;
    }

    public String getSubTotalText() {
        return getSubTotal().getText().replaceAll(REPLACEMENT_REGEX,"");
    }

    public WebElement getEcoTax() {
        ecoTax = driver.findElement(By.xpath(ECO_TAX_XPATH));
        return ecoTax;
    }

    public String getEcoTaxText() {
        return getEcoTax().getText().replaceAll(REPLACEMENT_REGEX,"");
    }

    public WebElement getVatTax() {
        vatTax = driver.findElement(By.xpath(VAT_XPATH));
        return vatTax;
    }

    public String getVatTaxText() {
        return getVatTax().getText().replaceAll(REPLACEMENT_REGEX,"");
    }

    public WebElement getTotalPrice() {
        totalPrice = driver.findElement(By.xpath(TOTAL_XPATH));
        return totalPrice;
    }

    public String getTotalPriceText() {
        return getTotalPrice().getText().replaceAll(REPLACEMENT_REGEX,"");
    }

    public WebElement getEmptyCartMsg() {
        cartEmptyMessage = driver.findElement(By.xpath(EMPTY_MESSAGE_XPATH));
        return cartEmptyMessage;
    }

    public String getEmptyCartMsgText() {
        return getEmptyCartMsg().getText();
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

    public String getCartTotalSum() {
        String totalSum = getCartTotalText().substring(getCartTotalText().lastIndexOf(" ") + 1);
        return totalSum.replaceAll(REPLACEMENT_REGEX,"");
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
        cartWait.waitForViewCartButtonLoading();
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
