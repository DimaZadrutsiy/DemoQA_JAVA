package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalDialogsPage extends AlertsFramesWindowsPage {

    @FindBy(xpath = "//button[@id='showSmallModal']")
    WebElement smallModalButton;

    @FindBy(xpath = "//div[@class='modal-body']")
    WebElement smallModalDialogBody;

    @FindBy(xpath = "//button[@id='showLargeModal']")
    WebElement largeModalButton;

    @FindBy(xpath = "//div[@class='modal-body']")
    WebElement largeModalDialogBody;

    @FindBy(xpath = "//button[@id='closeSmallModal']")
    WebElement closeSmallModalDialogButton;

    @FindBy(xpath = "//button[@id='closeLargeModal']")
    WebElement closeLargeModalDialogButton;

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public ModalDialogsPage clickSmallModalButton() {
        if (smallModalButton.isEnabled() && smallModalButton.isDisplayed()) {
            click(smallModalButton);

            return new ModalDialogsPage(getDriver());
        } else

            return null;
    }

    public String getSmallModalBoxText() {
        getWait20().until(ExpectedConditions.visibilityOf(smallModalDialogBody));

        return smallModalDialogBody.getText();
    }

    public ModalDialogsPage clickLargeModalButton() {
        if (largeModalButton.isEnabled() && largeModalButton.isDisplayed()) {
            click(largeModalButton);

            return new ModalDialogsPage(getDriver());
        } else

            return null;
    }

    public String getLargeModalBoxText() {
        getWait20().until(ExpectedConditions.visibilityOf(largeModalDialogBody));

        return largeModalDialogBody.getText();
    }

    public ModalDialogsPage clickCloseSmallModalDialogButton() {
        getWait10().until(ExpectedConditions.visibilityOf(closeSmallModalDialogButton));
        closeSmallModalDialogButton.click();
        getWait10().until(ExpectedConditions.invisibilityOf(closeSmallModalDialogButton));

        return new ModalDialogsPage(getDriver());
    }

    public ModalDialogsPage clickCloseLargeModalDialogButton() {
        getWait10().until(ExpectedConditions.visibilityOf(closeLargeModalDialogButton));
        closeLargeModalDialogButton.click();
        getWait10().until(ExpectedConditions.invisibilityOf(closeLargeModalDialogButton));

        return new ModalDialogsPage(getDriver());
    }

    public boolean isLargeModalDialogBoxDisplayed() {

        try {
            if (closeLargeModalDialogButton.isDisplayed() && largeModalDialogBody.isDisplayed()) {

                return true;
            } else {

                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public boolean isSmallModalDialogBoxDisplayed() {

        try {
            if (closeSmallModalDialogButton.isDisplayed() && smallModalDialogBody.isDisplayed()) {

                return true;
            } else {

                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }
}
