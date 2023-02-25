package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LoginPage inputUserName() {
        scrollByVisibleElement(userNameField);
        inputAfterClear(userNameField, properties.getProperty("username"));

        return this;
    }

    public LoginPage inputCustomUserName(String username) {
        scrollByVisibleElement(userNameField);
        inputAfterClear(userNameField, username);

        return this;
    }

    public LoginPage inputPassword() {
        scrollByVisibleElement(passwordField);
        inputAfterClear(passwordField, properties.getProperty("password"));

        return this;
    }

    public LoginPage inputCustomPassword(String password) {
        input(password, passwordField);

        return new LoginPage(getDriver());
    }

    public <T extends BookStorePage> T clickLoginButton() {

        try {
            click(loginButton);

            String currentUrl = getCurrentURL();

            if (currentUrl.equals("https://demoqa.com/login")) {

                return (T) new LoginPage(getDriver());
            } else if (currentUrl.equals("https://demoqa.com/profile")) {

                return (T) new ProfilePage(getDriver());
            } else {

                return (T) new BookStorePage(getDriver());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());

            return null;
        }
    }

    public RegisterNewUserPage clickNewUserButton() {
        wait20ElementToBeVisible(newUserButton);
        click(newUserButton);

        return new RegisterNewUserPage(getDriver());
    }

    public String getErrorMessage() {
        wait10ElementToBeVisible(outputMessage);

        return getText(outputMessage);
    }

    // sign in returns different pages - BookStorePage or ProfilePage
    public ProfilePage signInAsRegularUser() {
        isElementDisplayed(userNameField);
        inputUserName();
        isElementDisplayed(passwordField);
        inputPassword();
        clickLoginButton();

        return new ProfilePage(getDriver());
    }
}
