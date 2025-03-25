import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By registerLink = By.linkText("Register");
    private By usernameField = By.name("username");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("password-confirm");
    private By registerButton = By.cssSelector("button[type=\"submit\"]");

    private By RegistrationErrorMessage = By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > p:nth-child(3)");
    private By clickLoginPage = By.linkText("LOGIN");
    private By DiffrentErrorMessage = By.cssSelector(".error");
    private By InputEmailError = By.cssSelector(".form-input-error");
    private By MismatchPasswordErrorMessage = By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(6) > p:nth-child(3)");
    private By PasswordTooShortMessage = By.cssSelector(".form-input-error");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginpage() {
        driver.findElement(clickLoginPage).click();
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void registerUser(String email, String username, String password, String confirmPassword) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        driver.findElement(registerButton).click();
    }


    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElement(RegistrationErrorMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(RegistrationErrorMessage).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isErrorMessageAppeared() {
        try {
            return driver.findElement(DiffrentErrorMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getDifferentErrorMessage() {
        try {
            return driver.findElement(DiffrentErrorMessage).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }


    public boolean isInputErrorMessageDisplayed() {
        try {
            return driver.findElement(InputEmailError).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getInputErrorMessage() {
        try {
            return driver.findElement(InputEmailError).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isInputMismatchErrorMessageDisplayed() {
        try {
            return driver.findElement(MismatchPasswordErrorMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getInputMismatchErrorMessage() {
        try {
            return driver.findElement(MismatchPasswordErrorMessage).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isInputCharacterslessErrorMessageDisplayed() {
        try {
            return driver.findElement(PasswordTooShortMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getInputLessCharactersErrorMessage() {
        try {
            return driver.findElement(PasswordTooShortMessage).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
