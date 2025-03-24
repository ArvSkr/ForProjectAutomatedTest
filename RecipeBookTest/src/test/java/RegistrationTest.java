import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    public void testUserRegistration() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();

        assertEquals("http://localhost:5173/register", driver.getCurrentUrl(), "Navigation to registration page failed.");

        registrationPage.registerUser("john.doom05@test.com", "Doom5", "Doom1234");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe("http://localhost:5173/"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:5173/", currentUrl, "Registration did not redirect correctly.");
    }

    @Test
    public void testUserRegistrationWithEmptyInputs() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("", "", "");

        assertTrue(registrationPage.isErrorMessageDisplayed(), "Error message should appear for invalid registration.");
    }

    @Test
    public void testRegistrationWithExistingEmail() {


    }

    @Test
    public void testRegistrationWithInvalidEmail() {

    }

    @Test
    public void testRegistrationWithInvalidPassword() {

    }

    @Test
    public void testRegistrationWithMismatchingPasswords() {

    }

    @Test
    public void testRegistrationWithPasswordTooShort() {

    }

    @Test
    public void testRegistrationWithPasswordTooLong() {

    }
}
