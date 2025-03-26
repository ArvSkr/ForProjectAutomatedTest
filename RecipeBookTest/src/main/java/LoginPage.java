import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".form-input-error");
    private By clickLoginPage = By.linkText("LOGIN");
    private By otherErrorMessage = By.cssSelector(".error");
    private By RequiredPasswordMessage = By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4) > p:nth-child(3)");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUser(String email, String password) {
       driver.findElement(clickLoginPage).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }


    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public boolean isOtherErrorMessageDisplayed() {
        return driver.findElement(otherErrorMessage).isDisplayed();
    }
    public String getOtherErrorMessage(){
        return driver.findElement(otherErrorMessage).getText();
    }

}
