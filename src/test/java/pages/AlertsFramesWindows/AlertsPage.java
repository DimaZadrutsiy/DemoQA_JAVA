package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends AlertsFramesWindowsPage{

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement oneClickAlertButton;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement oneClickAndWaitAlertButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickOnceAlertButton() {
        if (oneClickAlertButton.isDisplayed() && oneClickAlertButton.isEnabled()) {
            oneClickAlertButton.click();
        }

        return new AlertsPage(getDriver());
    }

    public AlertsPage clickOnceAndWaitAlertButton() {
        if (oneClickAlertButton.isDisplayed() && oneClickAlertButton.isEnabled()) {
            oneClickAndWaitAlertButton.click();
            getWait20().until(ExpectedConditions.alertIsPresent());
        }

        return new AlertsPage(getDriver());
    }
}
