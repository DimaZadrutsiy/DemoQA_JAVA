package pages.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends FormsPage{

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(xpath = "//div[@id='genterWrapper']//div/label")
    private WebElement userGender;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement getFullName;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement getEmail;

    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    private WebElement getGender;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    private WebElement getNumber;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage inputPracticeFormFirstName(String text) {
        scrollByVisibleElement(firstName);
        inputAndEnter(firstName, text);

        return this;
    }

    public PracticeFormPage inputPracticeFormLastName(String text) {
        scrollByVisibleElement(lastName);
        inputAndEnter(lastName, text);

        return this;
    }

    public PracticeFormPage inputPracticeFormEmail(String text) {
        scrollByVisibleElement(userEmail);
        inputAndEnter(userEmail, text);

        return this;
    }

    public PracticeFormPage inputPracticeFormGender() {
        scrollByVisibleElement(userGender);
        click(userGender);

        return this;
    }

    public PracticeFormPage inputPracticeFormNumber(String number) {
        scrollByVisibleElement(userNumber);
        inputAndEnter(userNumber, number);

        return this;
    }

    public String getNamePracticeForm() {

        return getText(getFullName);
    }

    public String getEmailPracticeForm() {

        return getText(getEmail);
    }

    public String getGenderPracticeForm() {

        return getText(getGender);
    }

    public String getNumberPracticeForm() {

        return getText(getNumber);
    }
}
