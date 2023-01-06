package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    /*
    при логине с невалидными данными мы остаемся на LoginPage
    при логине с валидными данными мы переходим или на ProfilePage или на BookStorePage
    и мне не нравится этот метод, если что :)
     */
    public  <T extends BookStorePage>T clickLoginButton() {
        click(loginButton);

        if (getCurrentURL().equals("https://demoqa.com/login")) {

            return (T) new LoginPage(getDriver());
        } else if (getCurrentURL().equals("https://demoqa.com/profile")){

            return (T) new ProfilePage(getDriver());
        }  else

            return (T) new BookStorePage(getDriver());
    }

    public RegisterPage clickNewUserButton() {
        wait20ElementToBeVisible(newUserButton);
        click(newUserButton);

        return new RegisterPage(getDriver());
    }

    public String getErrorMessage() {
        wait10ElementToBeVisible(outputMessage);

        return getText(outputMessage);
    }
}
