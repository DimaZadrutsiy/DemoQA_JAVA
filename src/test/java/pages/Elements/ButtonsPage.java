package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ButtonsPage extends ElementsPage{

    @FindBy (xpath = "//button[@id='doubleClickBtn']")
    private WebElement button_DoubleClickMe;

    @FindBy (xpath = "//button[@id='rightClickBtn']")
    private WebElement button_RightClickMe;

    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")
    private WebElement button_ClickMe;

    @FindBy (css = "#doubleClickMessage")
    private WebElement messageForButton_DoubleClickMe;

    @FindBy (css = "#rightClickMessage")
    private WebElement messageForButton_RightClickMe;

    @FindBy (css = "#dynamicClickMessage")
    private WebElement messageForButton_ClickMe;

    @FindBy (css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div")
    private List<WebElement> allButtons;

    @FindBy (css = ".main-header")
    private WebElement mainHeader;


    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage clickButton_DoubleClickMe() {
        scrollByVisibleElement(button_DoubleClickMe);
        Actions actions = new Actions(getDriver());
        actions.doubleClick(button_DoubleClickMe).perform();

        return this;
    }

    public ButtonsPage clickButton_RightClickMe() {
        scrollByVisibleElement(button_RightClickMe);
        Actions actions = new Actions(getDriver());
        actions.contextClick(button_RightClickMe).perform();

        return this;
    }

    public ButtonsPage clickButton_ClickMe() {
        scrollByVisibleElement(button_ClickMe);
        click(button_ClickMe);

        return this;
    }

    public String messageForButton_DoubleClickMe() {

        return getText(messageForButton_DoubleClickMe);
    }

    public String messageForButton_RightClickMe() {

        return getText(messageForButton_RightClickMe);
    }

    public String messageForButton_ClickMe() {

        return getText(messageForButton_ClickMe);
    }

    public List<String> getNamesAllButtons() {

        return getTexts(allButtons);
    }

    public int getNumberOfButtons() {

        return getTexts(allButtons).size();
    }

    public String getMainHeader() {

        return getText(mainHeader);
    }
}
