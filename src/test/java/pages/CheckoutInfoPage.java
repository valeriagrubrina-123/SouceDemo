package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private final By INPUT_FIRST_NAME = By.cssSelector("#first-name");
    private final By INPUT_LAST_NAME = By.cssSelector("#last-name");
    private final By INPUT_POSTAL_CODE = By.cssSelector("#postal-code");
    private final By BTN_CONTINUE = By.name("continue");
    private final By BTN_CANCEL = By.name("cancel");

    private final By MSG_ERROR = By.cssSelector("h3[data-test='error']");
    private final By PAGE_HEADER_TITLE = By.cssSelector(".title");

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_HEADER_TITLE).getText();
    }

    public void fillShippingDetails(String firstName, String lastName, String zipCode) {
        driver.findElement(INPUT_FIRST_NAME).sendKeys(firstName);
        driver.findElement(INPUT_LAST_NAME).sendKeys(lastName);
        driver.findElement(INPUT_POSTAL_CODE).sendKeys(zipCode);
        driver.findElement(BTN_CONTINUE).click();
    }

    public void clickCancelButton() {
        driver.findElement(BTN_CANCEL).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(MSG_ERROR).getText();
    }
}
