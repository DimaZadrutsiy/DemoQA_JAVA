package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AlertsFramesWindowsPage extends BasePage {

    @FindBy(xpath = "//li[@id='item-0']/span[contains(text(),'Browser Windows')]")
    private WebElement browserWindowsSubMenu;

    @FindBy(xpath = "//li[@id='item-1']/span[contains(text(),'Alerts')]")
    private WebElement alertsSubMenu;

    @FindBy(xpath = "//li[@id='item-2']/span[contains(text(),'Frames')]")
    private WebElement framesSubMenu;

    @FindBy(xpath = "//li[@id='item-3']/span[contains(text(),'Nested Frames')]")
    private WebElement nestedFramesSubMenu;

    @FindBy(xpath = "//li[@id='item-4']/span[contains(text(),'Modal Dialogs')]")
    private WebElement modalDialogsSubMenu;

    public AlertsFramesWindowsPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage selectBrowserWindowsSubMenu() {
        click(browserWindowsSubMenu);

        return new BrowserWindowsPage(getDriver());
    }

    public AlertsPage selectAlertsSubMenu() {
        click(alertsSubMenu);

        return new AlertsPage(getDriver());
    }

    public FramesPage selectFramesSubMenu() {
        click(framesSubMenu);

        return new FramesPage(getDriver());
    }

    public NestedFramesPage selectNestedFramesSubMenu() {
        click(nestedFramesSubMenu);

        return new NestedFramesPage(getDriver());
    }

    public ModalDialogsPage selectModalDialogSubMenu() {
        click(modalDialogsSubMenu);

        return new ModalDialogsPage(getDriver());
    }
}
