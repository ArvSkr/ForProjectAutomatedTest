import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

 private By RegisterLink = By.linkText("Register");
   private By usernameField = By.name("username");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("password-confirm");
    private By registerButton = By.name("Submit");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
public void DontHaveAccountClick(){
        driver.findElement(RegisterLink).click();
}
    public void registerUser( String email, String username, String password) {

        driver.findElement(emailField).sendKeys(email);
         driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }
}