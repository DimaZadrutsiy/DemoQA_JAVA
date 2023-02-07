package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends InteractionsPage{

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public String getH2Header() {

        return getText(h2LogoHeader);
    }
}
