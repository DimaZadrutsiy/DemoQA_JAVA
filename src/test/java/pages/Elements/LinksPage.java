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

    @FindBy(id = ("dynamicLink"))
    private WebElement dynamicLink;

    @FindBy (xpath = "//*[@href=\"javascript:void(0)\"]")
    private List<WebElement> linksApiCall;

    @FindBy (css = "#linkResponse > b:nth-child(1)")
    private WebElement responseCode;

    @FindBy (css = "#linkResponse > b:nth-child(2)")
    private WebElement responseName;

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

    public void clickLinks(int index) {
        scrollByVisibleElement(linksApiCall.get(index));
        linksApiCall.get(index).click();
    }

    public String getResponseCode() {

        return getText(responseCode);
    }

    public String getResponseName() {

        return getText(responseName);
    }

    public LinksPage clickOnHomeDynamicLink() {
        if (homeLink.isDisplayed() && homeLink.isEnabled()) {
            click(dynamicLink);
        }

        return new LinksPage(getDriver());
    }
}
