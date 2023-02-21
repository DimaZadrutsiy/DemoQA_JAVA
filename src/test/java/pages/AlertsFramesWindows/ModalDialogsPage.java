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

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public ModalDialogsPage clickSmallModalButton() {
        if(smallModalButton.isEnabled() && smallModalButton.isDisplayed()) {
            click(smallModalButton);

            return new ModalDialogsPage(getDriver());
        } else

            return null;
    }

    public String getSmallModalBoxText() {
        getWait20().until(ExpectedConditions.visibilityOf(smallModalDialogBody));

        return smallModalDialogBody.getText();
    }
}
