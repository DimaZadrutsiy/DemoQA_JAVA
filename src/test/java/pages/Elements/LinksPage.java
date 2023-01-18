package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LinksPage extends ElementsPage {

    @FindAll(@FindBy(xpath = "//h5"))
    private List<WebElement> headerText;

    @FindBy(id = ("simpleLink"))
    private WebElement homeLink;

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getHeadersName() {

        return getTexts(headerText);
    }

    public LinksPage clickOnHomeLink() {
        if (homeLink.isDisplayed() && homeLink.isEnabled()) {
            click(homeLink);
        }

        return new LinksPage(getDriver());
    }

    public void switchToWindow() {
        switchToAnotherWindow();
    }
}
