package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends ElementsPage{

    @FindBy(xpath = "//input[@id = 'userName']")
    private WebElement userNamePlaceholder;

    @FindBy(xpath = "//input[@id = 'userEmail']")
    private WebElement userEmailPlaceholder;

    @FindBy(xpath = "//textarea[@id = 'currentAddress']")
    private WebElement currentAddressPlaceholder;

    @FindBy(xpath = "//textarea[@id = 'permanentAddress']")
    private WebElement permanentAddressPlaceholder;

    @FindBy(xpath = "//button[@id = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@id = 'name']")
    private WebElement submittedName;

    @FindBy(xpath = "//p[@id = 'email']")
    private WebElement submittedEmail;

    @FindBy(xpath = "//p[@id = 'currentAddress']")
    private WebElement submittedCurrentAddress;

    @FindBy(xpath = "//p[@id = 'permanentAddress']")
    private WebElement submittedPermanentAddress;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage inputFullName(String fullName) {
        click(userNamePlaceholder);
        input(fullName, userNamePlaceholder);
        waitTextToBeChanged(userNamePlaceholder, fullName);

        return new TextBoxPage(getDriver());
    }

    public TextBoxPage inputEmail(String email) {
        click(userEmailPlaceholder);
        input(email, userEmailPlaceholder);
        waitTextToBeChanged(userEmailPlaceholder, email);

        return new TextBoxPage(getDriver());
    }
    public TextBoxPage inputCurrentAddress(String currentAddress) {
        click(currentAddressPlaceholder);
        input(currentAddress, currentAddressPlaceholder);
        waitTextToBeChanged(currentAddressPlaceholder, currentAddress);

        return new TextBoxPage(getDriver());
    }
    public TextBoxPage inputPermanentAdress(String permanentAddress) {
        click(permanentAddressPlaceholder);
        input(permanentAddress, permanentAddressPlaceholder);
        waitTextToBeChanged(permanentAddressPlaceholder, permanentAddress);

        return new TextBoxPage(getDriver());
    }

    public TextBoxPage clickSubmit() {
        click(submitButton);
        return this;
    }

    public boolean isNameContains(String text) {

        return isTextContains(submittedName,text);
    }

    public boolean isFullNameDisplayed() {

        return isElementDisplayed(submittedName);
    }

    public boolean isEmailContains(String text) {

        return isTextContains(submittedEmail,text);
    }

    public boolean isEmailDisplayed() {

        return isElementDisplayed(submittedEmail);
    }

    public boolean isCurrentAddressContains(String text) {

        return isTextContains(submittedCurrentAddress,text);
    }

    public boolean isCurrentAddressDisplayed() {

        return isElementDisplayed(submittedCurrentAddress);
    }

    public boolean isPermanentAddressContains(String text) {

        return isTextContains(submittedPermanentAddress,text);
    }

    public boolean isPermanentAddressDisplayed() {

        return isElementDisplayed(submittedPermanentAddress);
    }

}
