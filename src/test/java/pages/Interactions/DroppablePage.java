package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DroppablePage extends InteractionsPage {

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    @FindBy(id = "droppableExample-tab-simple")
    private WebElement simpleTab;

    @FindBy(id = "draggable")
    private WebElement fromElementSimple;

    @FindBy(css = "#droppableContainer > nav > a")
    private List<WebElement> elementTabs;

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public String getH2Header() {

        return getText(h2LogoHeader);
    }

    public DroppablePage clickSimpleTab() {
        scrollByVisibleElement(simpleTab);
        wait10ElementToBeClickable(simpleTab);
        click(simpleTab);

        return this;
    }

    public WebElement getSimpleFromElement() {

        return this.fromElementSimple;
    }

    public List<String> getNameTabs() {

       return getTexts(elementTabs);
    }
}