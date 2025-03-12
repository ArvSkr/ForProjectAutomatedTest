import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    public void testUserRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser("John", "Doom", "john.doom@test.com", "Doom1234");


        String expectedUrl = "";
        assertEquals(driver.getCurrentUrl(), expectedUrl, "Registration failed!");
    }
}