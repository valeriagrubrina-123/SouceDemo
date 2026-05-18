package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewTest extends BaseTest {

    private final String TARGET_PRODUCT_NAME = "Test.allTheThings() T-Shirt (Red)";
    private final String TARGET_PRODUCT_PRICE = "15.99";

    @Test
    public void verifyOrderDetailsOnOverview() {
        SoftAssert softAssert = new SoftAssert();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart(TARGET_PRODUCT_NAME);
        productsPage.clickCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.fillShippingDetails("Lera", "Gruber", "123456");

        String actualName = checkoutOverviewPage.getOverviewItemName();
        String actualPrice = checkoutOverviewPage.getOverviewItemPrice();

        softAssert.assertEquals(actualName, TARGET_PRODUCT_NAME, "Item name on Overview page is incorrect!");
        softAssert.assertEquals(actualPrice, TARGET_PRODUCT_PRICE, "Item price on Overview page is incorrect!");

        softAssert.assertAll();
    }

    @Test
    public void verifySuccessfulOrderCompletion() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart(TARGET_PRODUCT_NAME);
        productsPage.clickCart();
        cartPage.proceedToCheckout();
        checkoutInfoPage.fillShippingDetails("Lera", "Gruber", "123456");

        checkoutOverviewPage.clickFinish();

        String completePageTitle = checkoutCompletePage.getPageTitle();
        assertEquals(completePageTitle, "Checkout: Complete!", "Did not reach the checkout complete page!");
    }
}
