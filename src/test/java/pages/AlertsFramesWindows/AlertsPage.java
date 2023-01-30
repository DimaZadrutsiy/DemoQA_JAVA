package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends AlertsFramesWindowsPage{

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement oneClickAlertButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickOnceAlertButton() {
        if (oneClickAlertButton.isDisplayed() && oneClickAlertButton.isEnabled()) {
            oneClickAlertButton.click();
        }

        return new AlertsPage(getDriver());
    }
}
