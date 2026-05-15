package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.id("item_3_title_link"));
        driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)"));
        driver.findElement(By.className("inventory_item_name"));
        driver.findElement(By.tagName("footer"));
        driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)"));
        driver.findElement(By.partialLinkText("allthethings"));
        // XPath
        driver.findElement(By.xpath("//img[@alt='Test.allTheThings() T-Shirt (Red)']"));
        driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        driver.findElement(By.xpath("//button[contains(@id, 'allthethings')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'T-Shirt (Red)')]"));
        driver.findElement(By.xpath("//div[text()='15.99']/ancestor::div[@class='inventory_item']"));
        driver.findElement(By.xpath("//a[@id='item_3_title_link']//descendant::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item_label']//following::button"));
        driver.findElement(By.xpath("//div[text()='15.99']/.."));
        driver.findElement(By.xpath("//div[@class='inventory_item_price']//preceding::div[@class='inventory_item_name'][1]"));
        driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Test.allTheThings() T-Shirt (Red)']"));
        // CSS Selectors
        driver.findElement(By.cssSelector(".inventory_item_container"));
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small"));
        driver.findElement(By.cssSelector(".inventory_item_label .inventory_item_name"));
        driver.findElement(By.cssSelector("#add-to-cart-test.allthethings()-t-shirt-(red)"));
        driver.findElement(By.cssSelector("nav"));
        driver.findElement(By.cssSelector("div.inventory_item_price"));
        driver.findElement(By.cssSelector("[data-test='inventory-item']"));
        driver.findElement(By.cssSelector("[class~='inventory_item_name']"));
        driver.findElement(By.cssSelector("[id='item']"));
        driver.findElement(By.cssSelector("[id^='add-to-cart']"));
        driver.findElement(By.cssSelector("[id$='t-shirt-(red)']"));
        driver.findElement(By.cssSelector("[id*='allthethings']"));
    }
}
