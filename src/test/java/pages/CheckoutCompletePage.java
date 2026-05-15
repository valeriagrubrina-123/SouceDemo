package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By PAGE_HEADER_TITLE = By.cssSelector(".title");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_HEADER_TITLE).getText();
    }

}
