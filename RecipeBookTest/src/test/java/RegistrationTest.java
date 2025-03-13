import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    public void testUserRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.DontHaveAccountClick();
        String getcurrentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/register";
        assertEquals(expectedUrl, getcurrentUrl, "it did not work");
        registrationPage.registerUser("john.doom@test.com", "Doom", "Doom1234" );
        String getOtherUrl = driver.getCurrentUrl();
        String expectedotherUrl = "http://localhost:5173";
        assertEquals(expectedotherUrl, getOtherUrl, "Nuh uh");


    }
}