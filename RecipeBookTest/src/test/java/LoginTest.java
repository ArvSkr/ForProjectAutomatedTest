import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginTest extends BaseTest {

    @Test
    public void testUserLoginValid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("john.doom@test.com", "Doom1234");


    }

    @Test
    public void testUserLoginInvalid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("invalid@test.com", "WrongPass123");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login.");
    }
}
