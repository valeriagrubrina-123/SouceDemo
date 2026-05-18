package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final By PAGE_TITLE = By.cssSelector(".title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        By addToCartButton = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]");
        driver.findElement(addToCartButton).click();
    }

    public void clickCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();

    }

}
