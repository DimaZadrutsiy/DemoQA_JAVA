package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButtonPage extends ElementsPage {

    @FindAll(@FindBy(xpath = "//input[@type='radio']"))
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesButton;

    @FindBy(id = ("yesRadio"))
    private WebElement yesButtonClick;

    @FindBy(xpath = "//span[text() = 'Yes']")
    private WebElement YesRadioButtonText;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(id = ("impressiveRadio"))
    private WebElement impressiveRadioButtonSelected;

    @FindBy(xpath = " //p[@class='mt-3']")
    private WebElement impressiveRadioButtonText;

    @FindBy(xpath = "//label[@for='noRadio']")
    private WebElement noButton;

    @FindBy(id = ("noRadio"))
    private WebElement noButtonDisabled;

    @FindBy(xpath = " //div[text()='Do you like the site?']")
    private WebElement text;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public RadioButtonPage clickOnImpressibeRadioButton() {
        if (impressiveRadioButton.isDisplayed() && impressiveRadioButton.isEnabled()) {
            scrollByVisibleElement(text);
            click(impressiveRadioButton);
        }

        return new RadioButtonPage(getDriver());
    }

    public boolean isRadioButtonImpressiveSelected() {

        return isElementSelected(impressiveRadioButtonSelected);
    }

    public boolean impressiveButtonText(String tekst) {
        scrollByVisibleElement(text);

        return isTextContains(impressiveRadioButtonText, tekst);
    }

    public RadioButtonPage clickOnYesRadioButton() {
        scrollByVisibleElement(text);
        if (yesButton.isDisplayed() && yesButton.isEnabled()) {
            click(yesButton);
        }

        return new RadioButtonPage(getDriver());
    }

    public boolean isRadioButtonYesSelected() {

        return isElementSelected(yesButtonClick);
    }

    public boolean yesButtonText(String tekst) {
        scrollByVisibleElement(text);

        return isTextContains(YesRadioButtonText, tekst);
    }

    public RadioButtonPage clickOnNoRadioButton() {
        scrollByVisibleElement(text);
        if (noButton.isDisplayed() && noButton.isEnabled()) {
            click(noButton);
        }

        return new RadioButtonPage(getDriver());
    }

    public boolean isRadioButtonNoSelected() {

        return isElementSelected(noButtonDisabled);
    }
}