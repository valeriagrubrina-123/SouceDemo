package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String PRODUCT_TITLE_IN_CART = "//div[@class='inventory_item_name' and text()='%s']";
    private final String REMOVE_BUTTON_FOR_PRODUCT = "//div[text()='%s']/ancestor::div[@class='cart_item']//button[contains(text(), 'Remove')]";
    private final By CHECKOUT_BUTTON = By.cssSelector("#checkout");
    private final By PAGE_HEADER_TITLE = By.cssSelector(".title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_TITLE_IN_CART, productName))).getText();
    }

    public String getProductPrice(String productName) {
        String PRODUCT_PRICE_IN_CART = "//div[text()='%s']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']";
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_IN_CART, productName))).getText().replace("$", "");
    }

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON_FOR_PRODUCT, productName))).click();
    }

    public boolean isProductPresentInCart(String productName) {
        return driver.findElements(By.xpath(String.format(PRODUCT_TITLE_IN_CART, productName))).size() > 0;
    }

    public void proceedToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_HEADER_TITLE).getText();
    }
}
