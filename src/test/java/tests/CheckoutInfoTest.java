package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutInfoTest extends BaseTest {

    String targetItem = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void verifyNavigationToCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(targetItem);
        productsPage.clickCart();
        cartPage.proceedToCheckout();

        assertEquals(checkoutInfoPage.getPageTitle(), "Checkout: Your Information",
                "Ошибка перехода! заголовок страницы Checkout отсутствует или неверен");
    }

    @Test
    public void verifySuccessfulCheckoutWithValidData() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(targetItem);
        productsPage.clickCart();
        cartPage.proceedToCheckout();

        checkoutInfoPage.fillShippingDetails("Ivan", "Ivanov", "123456");

        assertEquals(checkoutOverviewPage.getPageTitle(), "Checkout: Overview", "Не удалось перейти на страницу Overview");
    }

    @Test
    public void verifyErrorWhenFirstNameIsEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(targetItem);
        productsPage.clickCart();
        cartPage.proceedToCheckout();

        checkoutInfoPage.fillShippingDetails("", "Ivanov", "123456");

        assertEquals(checkoutInfoPage.getErrorMessageText(), "Error: First Name is required",
                "Сообщение об ошибке пустого имени некорректно");
    }

    @Test
    public void verifyErrorWhenLastNameIsEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(targetItem);
        productsPage.clickCart();
        cartPage.proceedToCheckout();

        checkoutInfoPage.fillShippingDetails("Lera", "", "123456");

        assertEquals(checkoutInfoPage.getErrorMessageText(), "Error: Last Name is required",
                "Сообщение об ошибке пустой фамилии некорректно");
    }

    @Test
    public void verifyErrorWhenPostalCodeIsEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(targetItem);
        productsPage.clickCart();
        cartPage.proceedToCheckout();

        checkoutInfoPage.fillShippingDetails("Ivan", "Ivanov", "");

        assertEquals(checkoutInfoPage.getErrorMessageText(), "Error: Postal Code is required",
                "Сообщение об ошибке пустого почтового индекса некорректно");
    }

    @Test
    public void verifyCancelButtonReturnsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(targetItem);
        productsPage.clickCart();
        cartPage.proceedToCheckout();

        checkoutInfoPage.clickCancelButton();

        assertEquals(cartPage.getPageTitle(), "Your Cart",
                "Кнопка Cancel не вернула пользователя обратно в корзину");
    }
}

