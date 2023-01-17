package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends AlertsFramesWindowsPage {
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement tabButton;

    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement windowButton;

    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement messageWindowButton;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public SamplePage clickNewTabButton() {
        click(tabButton);

        return new SamplePage(getDriver());
    }

    public BrowserWindowsPage clickNewWindowButton() {
        click(windowButton);

        return new BrowserWindowsPage(getDriver());
    }

    public BrowserWindowsPage clickNewWindowMessageButton() {
        click(messageWindowButton);

        return new BrowserWindowsPage(getDriver());
    }
}
