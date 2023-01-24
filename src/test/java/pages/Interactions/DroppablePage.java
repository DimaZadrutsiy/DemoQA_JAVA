package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends InteractionsPage {

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    @FindBy(id = "droppableExample-tab-simple")
    private WebElement simpleTab;

    @FindBy(id = "draggable")
    private WebElement fromElementSimple;

    @FindBy(id = "droppable")
    private WebElement toElementSimple;

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

    public WebElement getSimpleToElement() {

        return this.toElementSimple;
    }
}