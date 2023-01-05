package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends LoginPage{

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

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage inputFirstName(String firstName) {
        click(firstNameField);
        input(firstName, firstNameField);
        waitTextToBeChanged(firstNameField, firstName);

        return new RegisterPage(getDriver());
    }

    public RegisterPage inputLastName(String lastName) {
        click(firstNameField);
        input(lastName, lastNameField);
        waitTextToBeChanged(lastNameField, lastName);

        return new RegisterPage(getDriver());
    }

    public RegisterPage inputUserName(String userName) {
        click(userNameField);
        input(userName, userNameField);
        waitTextToBeChanged(userNameField, userName);

        return new RegisterPage(getDriver());
    }

    public RegisterPage inputPassword(String password) {
        click(passwordField);
        input(password, passwordField);

        return new RegisterPage(getDriver());
    }

    public RegisterPage clickCaptcha() {
        scrollByVisibleElement(registerButton);
        swithToIframe(iframeCaptchaCheckBox);
        click(recaptchaBlock);
        swithToParentFrame();

        return new RegisterPage(getDriver());
    }

    public RegisterPage clickRegisterButton() {
        scrollByVisibleElement(registerButton);
        click(registerButton);

        return new RegisterPage(getDriver());
    }

    public String getTextFromCaptchaBlock() {

        return getText(errorMessageBlock);
    }
}
