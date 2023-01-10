package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SortablePage extends InteractionsPage{

    @FindBy (css = "#demo-tabpane-list > div > div")
    List<WebElement> elementList;

    @FindBy (css = "#demo-tabpane-list > div > div:nth-child(6)")
    WebElement sixElement;

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesAllElements() {

        return getTexts(elementList);
    }

    public List<String> getReversedList() {

        return reversedList(elementList);
    }
}
