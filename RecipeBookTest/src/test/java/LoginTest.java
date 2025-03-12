import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("john.doom@test.com", "Doom1234");


        String expectedUrl = ""; // Change to actual URL
        assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }
}