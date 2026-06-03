package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    String targetItemName = "Test.allTheThings() T-Shirt (Red)";
    String targetItemPrice = "15.99";

    @Test
    @Owner("Grubrina V.E")
    @Epic("Sauce Demo 1")
    @Feature("Корзина")
    @Story("Проверка деталей товара")
    @Description("Проверка соответствия названия и цены товара после добавления в корзину")
    public void testProductDetailsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce1");

        productsPage.addToCart(targetItemName);
        productsPage.clickCart();

        verifyProductDetails(targetItemName, targetItemPrice);
    }

    @Step("Проверить, что название товара — '{expectedName}' и цена — '{expectedPrice}'")
    private void verifyProductDetails(String expectedName, String expectedPrice) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(cartPage.getProductName(expectedName), expectedName,
                "Название товара в корзине не совпадает!");
        softAssert.assertEquals(cartPage.getProductPrice(expectedName), expectedPrice,
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
