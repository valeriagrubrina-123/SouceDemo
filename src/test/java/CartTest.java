import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {
    /*
    Прекондишн: Открыть браузер
    Шаги:
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести логин standard_user и пароль secret_sauce
    3. Не переходя в карточку товара добавить товар Test.allTheThings() T-Shirt (Red) в корзину с помощью кнопки "Add to cart"
    4. Перейти в корзину, кликнув на значок корзины в верхнем правом углу страницы
    5. Проверить стоимость товара и его имя в корзине
    Посткондишн: Закрыть браузер
    Ожидаемый результат: имя и стоимость товара идентичны как в каталоге, так и в корзине
    */

    String expectedProductName = "Test.allTheThings() T-Shirt (Red)";
    String expectedPriceOfProduct = "15.99";

    @Test
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();
        // 1. Открываем сайт
        driver.get("https://www.saucedemo.com/");
        // 2. Авторизация
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        // 3. Добавление в корзину футболки
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        // 4. Переход в корзину
        driver.findElement(By.className("shopping_cart_link")).click();
        // 5. Проверка имени и цены в корзине
        String actualProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Test.allTheThings() T-Shirt (Red)']")).getText();
        String actualPriceOfProduct = driver.findElement(By.xpath("//div[@class='cart_item' and .//div[text()='Test.allTheThings() T-Shirt (Red)']]//div[@class='inventory_item_price']"))
                .getText()
                .replace("$", "");
        softAssert.assertEquals(actualProductName, expectedProductName, "Название товара не совпадает.");
        softAssert.assertEquals(actualPriceOfProduct, expectedPriceOfProduct, "Стоимость товара не совпадает.");
        softAssert.assertAll();
    }
}
