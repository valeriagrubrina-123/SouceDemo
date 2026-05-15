package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    String targetItemName = "Test.allTheThings() T-Shirt (Red)";
    String targetItemPrice = "15.99";

    @Test
    public void testProductDetailsInCart() {
        SoftAssert softAssert = new SoftAssert();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart(targetItemName);
        productsPage.clickCart();

        softAssert.assertEquals(cartPage.getProductName(targetItemName), targetItemName,
                "Название товара в корзине не совпадает!");
        softAssert.assertEquals(cartPage.getProductPrice(targetItemName), targetItemPrice,
                "Цена товара в корзине не совпадает!");
        softAssert.assertAll();
    }

    @Test
    public void testRemoveProductFromCart() {
        SoftAssert softAssert = new SoftAssert();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addToCart(targetItemName);
        productsPage.clickCart();

        softAssert.assertTrue(cartPage.isProductPresentInCart(targetItemName),
                "Товар должен быть в корзине перед удалением!");

        cartPage.removeProductFromCart(targetItemName);

        softAssert.assertFalse(cartPage.isProductPresentInCart(targetItemName),
                "Товар всё ещё отображается в корзине после нажатия кнопки Remove!");

        softAssert.assertAll();
    }
}
