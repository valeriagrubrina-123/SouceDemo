package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
