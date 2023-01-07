package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButtonPage extends ElementsPage {

    @FindAll(@FindBy(xpath = "//label[@class='custom-control-label']"))
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//input[@id='yesRadio']")
    private WebElement yesButton;

    @FindBy(css = "//label[@for='yesRadio']")
    private WebElement yesButtonClick;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(id = ("impressiveRadio"))
    private WebElement impressiveRadioButtonSelected;

    @FindBy(xpath = " //p[@class='mt-3']")
    private WebElement impressiveRadioButtonText;

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
    }


















