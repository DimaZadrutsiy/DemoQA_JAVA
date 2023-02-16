package pages.Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends WidgetsPage{

    @FindBy (css = "#progressBarContainer > button")
    private WebElement allButtons;

    @FindBy (css = "#progressBar > div")
    private WebElement progressBar;

    @FindBy (css = "#resetButton")
    private WebElement resetButton;

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public ProgressBarPage clickStartStopButton() {
        scrollByVisibleElement(allButtons);
        click(allButtons);

        return this;
    }

    public String getBackgroundColorProgressBar() {
        scrollByVisibleElement(progressBar);
        wait10ElementToBeVisible(resetButton);

        return Color.fromString(getBackgroundColor(progressBar)).asHex();
    }

    public String getNameButton() {
        scrollByVisibleElement(allButtons);

        return getText(allButtons);
    }

    public void waitElements() {
        wait10ElementToBeVisible(resetButton);
    }
}
