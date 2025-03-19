import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    public void testUserRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterLink();

        assertEquals("http://localhost:5173/register", driver.getCurrentUrl(), "Navigation to registration page failed.");

        registrationPage.registerUser("john.doom@test.com", "Doom", "Doom1234");

        assertEquals("http://localhost:5173", driver.getCurrentUrl(), "Registration did not redirect correctly.");
        assertTrue(registrationPage.isSuccessMessageDisplayed(), "Success message should appear after registration.");
    }

    @Test
    public void testUserRegistrationInvalid() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("", "User123", "Pass1234");

        assertTrue(registrationPage.isErrorMessageDisplayed(), "Error message should appear for invalid registration.");
    }
}
