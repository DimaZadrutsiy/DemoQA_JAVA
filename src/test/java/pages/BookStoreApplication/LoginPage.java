package pages.BookStoreApplication;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BookStorePage {

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div/button[@id='newUser']")
    private WebElement newUserButton;

    @FindBy(xpath = "//p[@id='name']")
    private WebElement outputMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputUserName(String userName) {
        input(userName, userNameField);

        return new LoginPage(getDriver());
    }

    public LoginPage inputPassword(String password) {
        input(password, passwordField);

        return new LoginPage(getDriver());
    }

    public  <T extends BookStorePage>T clickLoginButton() {
        click(loginButton);

        if (getCurrentURL().equals("https://demoqa.com/login")) {

            return (T) new LoginPage(getDriver());
        } else {

            return (T) new ProfilePage(getDriver());
        }
    }

    public RegisterPage clickNewUserButton() {
        click(newUserButton);

        return new RegisterPage(getDriver());
    }

    public String getErrorMessage() {
        wait10ElementToBeVisible(outputMessage);

        return getText(outputMessage);
    }
}
