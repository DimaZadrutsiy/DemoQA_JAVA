package pages.AlertsFramesWindows;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertsPage extends AlertsFramesWindowsPage{

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement firstAlertButton;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement secondAlertButton;

    @FindBy(xpath = "//button[@id='confirmButton']")
    WebElement thirdAlertButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    WebElement confirmMessage;

    @FindBy(xpath = "//button[@id='promtButton']")
    WebElement forthAlertButton;

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement promptResult;

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
            getWait20().until(alertIsPresent());
        }

        return new AlertsPage(getDriver());
    }

    public AlertsPage clickThirdAlertButton() {
        if (thirdAlertButton.isDisplayed() && thirdAlertButton.isEnabled()) {
            thirdAlertButton.click();
            getWait20().until(alertIsPresent());
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

    public AlertsPage clickForthAlertButton() {
        if (forthAlertButton.isDisplayed() && forthAlertButton.isEnabled()) {
            forthAlertButton.click();
            getWait20().until(alertIsPresent());
        }

        return new AlertsPage(getDriver());
    }

    public String getPromptResultMessage() {

        return promptResult.getText();
    }

    public AlertsPage enterTextAndConfirmAlertInAlertPage(String text) {
        enterTextAndConfirmAlert(text);

        return new AlertsPage(getDriver());
    }

    public void dismissAlertInAlertPage() {
        dismissAlert();
    }

    public boolean isAlertDisplayedInAlertPage() {

       return isAlertDisplayed();
    }
}
