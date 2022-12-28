package pages.Elements;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends ElementsPage{

    @FindBy (xpath = "//button[@id='doubleClickBtn']")
    WebElement button_DoubleClickMe;

    @FindBy (xpath = "//button[@id='rightClickBtn']")
    WebElement button_RightClickMe;

    @FindBy (xpath = "//button[text()='Click Me']")
    WebElement button_ClickMe;

    @FindBy (id = "doubleClickMessage")
    WebElement messageForButton_DoubleClickMe;

    @FindBy (id = "rightClickMessage")
    WebElement messageForButton_RightClickMe;

    @FindBy (id = "dynamicClickMessage")
    WebElement messageForButton_ClickMe;


    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage clickButton_DoubleClickMe() {
        Actions actions = new Actions(getDriver());
        actions.doubleClick(button_DoubleClickMe).perform();

        return this;
    }

    public ButtonsPage clickButton_RightClickMe() {
        Actions actions = new Actions(getDriver());
        actions.contextClick(button_RightClickMe).perform();

        return this;
    }

    public ButtonsPage clickButton_ClickMe() {
        Actions actions = new Actions(getDriver());
        actions.click(button_ClickMe).perform();

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
}
