package pages.Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProgressBarPage extends WidgetsPage{

    @FindBy (css = "#startStopButton")
    private WebElement startStopButton;

    @FindBy (css = "#progressBar > div")
    private WebElement progressBar;

    @FindBy (css = "#resetButton")
    private WebElement resetButton;

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public ProgressBarPage clickStartStopButton() {
        scrollByVisibleElement(startStopButton);
        click(startStopButton);

        return this;
    }

    public String getBackgroundColorProgressBar() {
        scrollByVisibleElement(progressBar);
        wait10ElementToBeVisible(resetButton);

        return Color.fromString(getBackgroundColor(progressBar)).asHex();
    }
}
