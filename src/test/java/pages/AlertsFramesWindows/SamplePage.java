package pages.AlertsFramesWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePage extends BrowserWindowsPage{

    @FindBy(xpath = "//h1[@id='sampleHeading']") //move to SamplePage?
    private WebElement h1HeaderNewWindow;

    public SamplePage(WebDriver driver) {
        super(driver);
    }
    public String getH1TextFromNewWindow() {
        switchToAnotherWindow();

        return getText(h1HeaderNewWindow);
    }

    public BrowserWindowsPage moveToPreviousPage() {
        switchToAnotherWindow();

        return new BrowserWindowsPage(getDriver());
    }
}
