package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectablePage extends InteractionsPage {

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    @FindBy(id = "demo-tab-list")
    private WebElement demoTabList;

    @FindBy(id = "demo-tab-grid")
    private WebElement demoTabGrid;

    @FindBy(xpath = "//div/ul[@id='verticalListContainer']/li")
    private List<WebElement> verticalList;

    @FindBy(xpath = "//div[@id='row1']/li")
    private List<WebElement> gridList1;

    @FindBy(xpath = "//div[@id='row2']/li")
    private List<WebElement> gridList2;

    @FindBy(xpath = "//div[@id='row3']/li")
    private List<WebElement> gridList3;

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    public String getH2Header() {

        return getText(h2LogoHeader);
    }

    public SelectablePage clickDemoTabList() {
        wait10ElementToBeClickable(demoTabList);
        scrollByVisibleElement(demoTabList);
        click(demoTabList);

        return new SelectablePage(getDriver());
    }

    public SelectablePage clickDemoTabGrid() {
        wait10ElementToBeClickable(demoTabGrid);
        scrollByVisibleElement(demoTabGrid);
        click(demoTabGrid);

        return new SelectablePage(getDriver());
    }

    public List<WebElement> getVerticalList() {

        return verticalList;
    }

    public List<WebElement> getGrid1() {

        return gridList1;
    }

    public List<WebElement> getGrid2() {

        return gridList2;
    }

    public List<WebElement> getGrid3() {

        return gridList3;
    }
}
