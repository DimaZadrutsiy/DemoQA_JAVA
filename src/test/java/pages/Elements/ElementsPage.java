package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ElementsPage extends BasePage {

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id = 'item-0']")
    private WebElement textBoxSubMenu;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id = 'item-1']")
    private WebElement checkBoxSubMenu;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id = 'item-2']")
    private WebElement radioButtonSubMenu;
    
    @FindBy(xpath = "//div[@class = 'element-list collapse show']//span")
    private List<WebElement> elementsList;

    @FindBy(xpath = "//div[@class='element-list collapse show']/ul[@class='menu-list']/li[5]")
    WebElement Buttons;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getElementsSubMenuHeaders() {

        return getTexts(elementsList);
    }

    public int getElementsSubMenuAmount() {

        return getListSize(elementsList);
    }

    public void checkAllElementsIsVisibleAndClickable() {
        clickAllElementsInList(elementsList);
    }

    public TextBoxPage clickTextBox() {
        scrollByVisibleElement(textBoxSubMenu);
        click(textBoxSubMenu);

        return new TextBoxPage(getDriver());
    }
    public ButtonsPage clickButtons() {
        scrollByVisibleElement(Buttons);
        click(Buttons);

        return new ButtonsPage(getDriver());
    }

    public CheckBoxPage openCheckBoxPage() {
        scrollByVisibleElement(checkBoxSubMenu);
        click(checkBoxSubMenu);

        return new CheckBoxPage(getDriver());
    }

    public RadioButtonPage openRadioButtonPage() {
        scrollByVisibleElement(radioButtonSubMenu);
        click(radioButtonSubMenu);

        return new RadioButtonPage(getDriver());
    }
}

