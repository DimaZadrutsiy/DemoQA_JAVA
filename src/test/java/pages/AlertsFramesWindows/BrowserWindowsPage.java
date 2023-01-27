package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserWindowsPage extends AlertsFramesWindowsPage {
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement tabButton;

    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement windowButton;

    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement messageWindowButton;

    @FindBy(xpath = "//body/")
    private WebElement body;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public SamplePage clickNewTabButton() {
        if(tabButton.isDisplayed() && tabButton.isEnabled()) {
            click(tabButton);
        }

        return new SamplePage(getDriver());
    }

    public SamplePage clickNewWindowButton() {
        if(windowButton.isDisplayed() && windowButton.isEnabled()) {
            click(windowButton);
        }

        return new SamplePage(getDriver());
    }

    public BrowserWindowsPage clickNewWindowMessageButton() {
        if(messageWindowButton.isDisplayed() && messageWindowButton.isEnabled()) {
            click(messageWindowButton);
        }

        return new BrowserWindowsPage(getDriver());
    }

    public String getNewWindowMessageBodyText() {
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToAnotherWindow();

        return getText(body);
    }
}
