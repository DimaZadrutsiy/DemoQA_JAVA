package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SortablePage extends InteractionsPage{

    @FindBy (css = "#demo-tabpane-list > div > div")
    List<WebElement> elementList;

    @FindBy (css = "#demo-tab-grid")
    WebElement bookmarkGrid;

    @FindBy (css = "#demo-tabpane-grid > div > div > div")
    List<WebElement> elementGrid;

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesAllElements() {

        return getTexts(elementList);
    }

    public List<String> getReversedList() {

        return reversedList(elementList);
    }

    public SortablePage clickBookmarkGrid() {
        scrollByVisibleElement(bookmarkGrid);
        click(bookmarkGrid);

        return this;
    }

    public List<String> getRandomList() {

        return randomList(elementGrid);
    }

    public String getH2Header() {

        return getText(h2LogoHeader);
    }
}
