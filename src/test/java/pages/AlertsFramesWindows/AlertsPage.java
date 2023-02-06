package pages.AlertsFramesWindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends AlertsFramesWindowsPage{

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement firstAlertButton;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement secondAlertButton;

    @FindBy(xpath = "//button[@id='confirmButton']")
    WebElement thirdAlertButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    WebElement confirmMessage;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickFirstAlertButton() {
        if (firstAlertButton.isDisplayed() && firstAlertButton.isEnabled()) {
            firstAlertButton.click();
        }

        return new AlertsPage(getDriver());
    }

    public AlertsPage clickSecondAlertButton() {
        if (firstAlertButton.isDisplayed() && firstAlertButton.isEnabled()) {
            secondAlertButton.click();
            getWait20().until(ExpectedConditions.alertIsPresent());
        }

        return new AlertsPage(getDriver());
    }

    public AlertsPage clickThirdAlertButton() {
        if (thirdAlertButton.isDisplayed() && thirdAlertButton.isEnabled()) {
            thirdAlertButton.click();
            getWait20().until(ExpectedConditions.alertIsPresent());
        }

        return new AlertsPage(getDriver());
    }

    public String getConfirmMessage() {

        return confirmMessage.getText();
    }

    public String getTextAndConfirmAlertInAlertPage() {

        return  getTextAndConfirmAlert();
    }

    public String getTextAndDismissAlertInAlertPage() {

        return getTextAndDismissAlert();
    }
}
