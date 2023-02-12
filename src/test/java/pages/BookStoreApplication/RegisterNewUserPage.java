package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterNewUserPage extends LoginPage{

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement iframeCaptchaCheckBox;

    @FindBy(xpath = "//label[@id='recaptcha-anchor-label']")
    private WebElement recaptchaBlock;

    @FindBy(xpath = "//button[@id='register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@id ='output']//p[@id='name']")
    private WebElement errorMessageBlock;

    public RegisterNewUserPage(WebDriver driver) {
        super(driver);
    }

    public RegisterNewUserPage inputFirstName(String firstName) {
        click(firstNameField);
        input(firstName, firstNameField);
        waitTextToBeChanged(firstNameField, firstName);

        return new RegisterNewUserPage(getDriver());
    }

    public RegisterNewUserPage inputLastName(String lastName) {
        click(firstNameField);
        input(lastName, lastNameField);
        waitTextToBeChanged(lastNameField, lastName);

        return new RegisterNewUserPage(getDriver());
    }

    public RegisterNewUserPage inputUserName(String userName) {
        click(userNameField);
        input(userName, userNameField);
        waitTextToBeChanged(userNameField, userName);

        return new RegisterNewUserPage(getDriver());
    }

    public RegisterNewUserPage inputPassword(String password) {
        click(passwordField);
        input(password, passwordField);

        return new RegisterNewUserPage(getDriver());
    }

    public RegisterNewUserPage clickCaptcha() {
        scrollByVisibleElement(registerButton);
        wait20ElementToBeClickable(registerButton);
        switchToIframe(iframeCaptchaCheckBox);
        click(recaptchaBlock);
        switchToParentFrame();

        return new RegisterNewUserPage(getDriver());
    }

    public RegisterNewUserPage clickRegisterButton() {
        scrollByVisibleElement(registerButton);
        click(registerButton);

        return new RegisterNewUserPage(getDriver());
    }

    public String getTextFromCaptchaBlock() {

        return getText(errorMessageBlock);
    }
}
