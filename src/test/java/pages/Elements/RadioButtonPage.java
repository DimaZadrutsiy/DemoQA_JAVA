package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RadioButtonPage extends ElementsPage {

    @FindAll(@FindBy(xpath = "//label[@class='custom-control-label']"))
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//input[@id='yesRadio']")
    private WebElement yesButton;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public RadioButtonPage clickOnYesRadioButton() {
        if (yesButton.isDisplayed() && yesButton.isEnabled()) {
            click(yesButton);
        }

        return new RadioButtonPage(getDriver());
    }


    public boolean isRadioButtonSelected() {

        return isElementSelected(yesButton);
    }

















}

