package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class BrokenLinksImagesPage extends BasePage {

    @FindBy(css = "//div/img[@src = '/images/Toolsqa.jpg']")
    WebElement validImage;

    @FindBy(css = ".main-header")
    WebElement mainHeader;

    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isValidImageDisplayed() {
        scrollByVisibleElement(validImage);
        return isElementDisplayed(validImage);
    }

    public boolean isHeaderContainText(String str) {
        scrollByVisibleElement(mainHeader);

        return isTextContains(mainHeader,str);
    }
}
