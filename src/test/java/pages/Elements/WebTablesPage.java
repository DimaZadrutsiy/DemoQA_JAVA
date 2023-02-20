package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ProjectConstants;

import java.util.List;


public class WebTablesPage extends ElementsPage{

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div[1]/div[1]/div[1]")
    private WebElement firstNameFirstColumFirstRow;

    @FindBy(css = "button[id = 'addNewRecordButton']")
    private WebElement addNewRecordButton;

    @FindBy(css = "input[id = 'firstName']")
    private WebElement firstNameInputField;

    @FindBy(css = "input[id = 'lastName']")
    private WebElement lastNameInputField;

    @FindBy(css = "input[id = 'userEmail']")
    private WebElement userEmailInputField;

    @FindBy(css = "input[id = 'age']")
    private WebElement ageInputField;

    @FindBy(css = "input[id = 'salary']")
    private WebElement salaryInputField;

    @FindBy(css = "input[id = 'department']")
    private WebElement departmentInputField;

    @FindBy(css = "button[id = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[1]/div[4]")
    private List<WebElement> emailColumn;

    @FindBy(id = ("searchBox"))
    private WebElement searchField;

    @FindBy(xpath = "//span[@title = 'Edit']")
    private WebElement editButtonOfFirstRow;

    @FindBy(css = ".rt-td")
    private List<WebElement> tableCells;

    @FindBy(xpath = "//span[@title = 'Delete']")
    private WebElement deleteButtonOfFirstRow;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage inputFirstNameIntoSearchField(String firstName) {
        scrollByVisibleElement(searchField);
        inputAfterClear(searchField, firstName);

        return this;
    }

    public String getTextFirstColumnRow() {
        scrollByVisibleElement(firstNameFirstColumFirstRow);

        return getText(firstNameFirstColumFirstRow);
    }

    public WebTablesPage clickOnAdd() {
        scrollByVisibleElement(addNewRecordButton);
        click(addNewRecordButton);

        return this;
    }

    public WebTablesPage inputFirstNameIntoRegistrationForm() {
        scrollByVisibleElement(firstNameInputField);
        inputAfterClear(firstNameInputField,getSaltString(ProjectConstants.SALT_UPPER_AND_LOWER_LETTERS,10));

        return this;
    }

    public WebTablesPage inputLastNameIntoRegistrationForm() {
        scrollByVisibleElement(lastNameInputField);
        inputAfterClear(lastNameInputField,getSaltString(ProjectConstants.SALT_UPPER_AND_LOWER_LETTERS,10));

        return this;
    }

    public WebTablesPage updateUserEmail(String email) {
        scrollByVisibleElement(userEmailInputField);
        inputAfterClear(userEmailInputField, email);

        return this;
    }

    public WebTablesPage inputAgeIntoRegistrationForm() {
        scrollByVisibleElement(ageInputField);
        inputAfterClear(ageInputField, getSaltString(ProjectConstants.SALT_NUMBERS,2));

        return this;
    }

    public WebTablesPage inputSalaryIntoRegistrationForm() {
        scrollByVisibleElement(salaryInputField);
        inputAfterClear(salaryInputField, getSaltString(ProjectConstants.SALT_NUMBERS,5));

        return this;
    }

    public WebTablesPage inputDepartmentIntoRegistrationForm() {
        scrollByVisibleElement(departmentInputField);
        inputAfterClear(departmentInputField, getSaltString(ProjectConstants.SALT_UPPER_AND_LOWER_LETTERS,10));

        return this;
    }

    public WebTablesPage clickSubmitButton() {
        scrollByVisibleElement(submitButton);
        click(submitButton);

        return this;
    }

    public boolean isEmailPresentInColumn(String email) {

       return isElementsInListContainsText(emailColumn,email);
    }

    public WebTablesPage addNewUserWithEmail(String email) {
        clickOnAdd();
        inputFirstNameIntoRegistrationForm();
        inputLastNameIntoRegistrationForm();
        updateUserEmail(email);
        inputAgeIntoRegistrationForm();
        inputSalaryIntoRegistrationForm();
        inputDepartmentIntoRegistrationForm();
        clickSubmitButton();

        return this;
    }

    public WebTablesPage searchUserByEmail(String email) {
        scrollByVisibleElement(searchField);
        inputAfterClear(searchField, email);

        return this;
    }

    public WebTablesPage clickEditButton() {
        scrollByVisibleElement(editButtonOfFirstRow);
        click(editButtonOfFirstRow);

        return this;
    }

    public WebTablesPage clickDeleteButton() {
        scrollByVisibleElement(deleteButtonOfFirstRow);
        click(deleteButtonOfFirstRow);

        return this;
    }

    public boolean isTableContainsText(String str) {

       return isElementsInListContainsText(tableCells, str);
    }
 }
