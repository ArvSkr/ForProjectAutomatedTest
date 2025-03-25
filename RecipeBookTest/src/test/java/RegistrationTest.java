import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
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

        registrationPage.registerUser("john.doom05@test.com", "Doom5", "Doom1234", "Doom1234");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe("http://localhost:5173/"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:5173/", currentUrl, "Registration did not redirect correctly.");
    }

    @Test
    public void testUserRegistrationWithEmptyInputs() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("", "", "", "");

        assertTrue(registrationPage.isErrorMessageDisplayed(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getErrorMessage();
        assertTrue(ErrorMessage.contains("Email is required"));
    }

    @Test
    public void testRegistrationWithExistingEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("tester@tester.com", "Tester", "Password1", "Password1");
        assertTrue(registrationPage.isErrorMessageAppeared(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getDifferentErrorMessage();
        assertTrue(ErrorMessage.contains("Email already in use. Please try another or log in."));

    }

    @Test
    public void testRegistrationWithInvalidEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("testertester.com", "Tester", "Password1", "Password1");
        assertTrue(registrationPage.isInputErrorMessageDisplayed(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getInputErrorMessage();
        assertTrue(ErrorMessage.contains("Invalid email address"), "Incorrect Error Message");
    }

    @Test
    public void testRegistrationWithInvalidPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("tester@tester.com", "Tester", "Password", "Password");
        assertTrue(registrationPage.isErrorMessageAppeared(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getDifferentErrorMessage();
        assertTrue(ErrorMessage.contains("Password must contain only letters and at least one number"), "Incorrect Error Message");

    }

    @Test
    public void testRegistrationWithMismatchingPasswords() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("tester@tester.com", "Tester", "Password", "Password");
        assertTrue(registrationPage.isInputMismatchErrorMessageDisplayed(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getInputMismatchErrorMessage();
        assertTrue(ErrorMessage.contains("Passwords do not match"), "Incorrect Error Message");
    }

    @Test
    public void testRegistrationWithPasswordTooShort() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("tester@tester.com", "Tester", "Pass", "Pass");
        assertTrue(registrationPage.isInputCharacterslessErrorMessageDisplayed(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getInputLessCharactersErrorMessage();
        assertTrue(ErrorMessage.contains("Password must be at least 6 characters"), "Incorrect Error Message");
    }

    @Test
    public void testRegistrationWithPasswordTooLong() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginpage();
        registrationPage.clickRegisterLink();
        registrationPage.registerUser("tester@tester.com", "Tester", "Passsadddddddddddddddddd1dddasdsdsdasdsadadssadsadadssadasdsadsadads", "Passsadddddddddddddddddd1dddasdsdsdasdsadadssadsadadssadasdsadsadads");
        assertTrue(registrationPage.isErrorMessageAppeared(), "Error message should appear for invalid registration.");
        String ErrorMessage = registrationPage.getDifferentErrorMessage();
        assertTrue(ErrorMessage.contains("The password must be no more than 20 characters long."), "Incorrect Error Message");

    }
}
