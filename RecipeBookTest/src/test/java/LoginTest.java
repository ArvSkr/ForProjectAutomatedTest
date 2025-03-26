import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void testUserLoginValid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("john.doom@test.com", "Doom1234");
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.urlToBe("http://localhost:5173/"));
        String CurrentURL = driver.getCurrentUrl();
        assertEquals("http://localhost:5173/", CurrentURL, "Login did not redirect to home page" );

    }

    @Test
    public void testUserLoginInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
       loginPage.loginUser("invalidtest.com", "WrongPass123");

       assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login.");
       String ErrorMessage = loginPage.getErrorMessage();
       assertTrue(ErrorMessage.contains("Invalid email address"), "incorrect error message");
    }
    @Test
    public void testUserLoginInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("invalid@test.com", "WrongPass123");

        assertTrue(loginPage.isOtherErrorMessageDisplayed(), "Error message should be displayed for invalid login.");
       
    }
    @Test
    public void testUserLoginEmptyInputs(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("", "");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login.");

        String ErrorMessage = loginPage.getErrorMessage();

        assertTrue(ErrorMessage.contains("Email is required"), "incorrect error message");

    }
}
