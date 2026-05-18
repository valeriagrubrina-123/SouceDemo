package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By FINISH_BUTTON = By.id("finish");
    private final By PAGE_HEADER_TITLE = By.cssSelector(".title");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_HEADER_TITLE).getText();
    }

    public String getOverviewItemName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    public String getOverviewItemPrice() {
        return driver.findElement(By.className("inventory_item_price")).getText();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
