import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By registerLink = By.linkText("Register");
    private By usernameField = By.name("username");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("password-confirm");
    private By registerButton = By.name("Submit");
    private By successMessage = By.id("successMessage");
    private By errorMessage = By.id("errorMessage");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void registerUser(String email, String username, String password) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
