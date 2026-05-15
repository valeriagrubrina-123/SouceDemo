package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLoginGoesToProductsPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getPageTitle(), "Products",
                "User was not redirected to Products page after valid login");
    }

    @Test
    public void testEmptyUsernameTriggersError() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required",
                "Validation message for empty username is wrong or missing");
    }

    @Test
    public void testEmptyPasswordTriggersError() {
        loginPage.open();
        loginPage.login("standard_user", "");

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required",
                "Validation message for empty password is wrong or missing");
    }

    @Test
    public void testInvalidCredentialsTriggerError() {
        loginPage.open();
        loginPage.login("locked_out_user", "wrong_password");

        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
                "Validation message for invalid credentials is wrong or missing");
    }
}
