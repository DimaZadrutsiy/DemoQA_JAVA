package pages.Widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutoCompletePage extends WidgetsPage{

    @FindBy (css = "#autoCompleteMultipleInput")
    private WebElement autoCompleteMultipleContainer;

    @FindBy (css = "#autoCompleteSingleInput")
    private WebElement autoCompleteSingleContainer;

    @FindBy (xpath = "//div[@class='css-12jo7m5 auto-complete__multi-value__label']")
    private List<WebElement> inputColorsInMultipleContainer;

    @FindBy (xpath = "//div[@class='auto-complete__single-value css-1uccc91-singleValue']")
    private WebElement inputColorInSingleContainer;

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    public AutoCompletePage clickMultipleContainer() {
        scrollByVisibleElement(autoCompleteMultipleContainer);
        click(autoCompleteMultipleContainer);

        return this;
    }

    public AutoCompletePage clickSingleContainer() {
        scrollByVisibleElement(autoCompleteSingleContainer);
        click(autoCompleteSingleContainer);

        return this;
    }

    public AutoCompletePage inputColorMultipleContainer(String text, String text2, String text3) {
        input(text, autoCompleteMultipleContainer);
        autoCompleteMultipleContainer.sendKeys(Keys.ENTER);
        input(text2, autoCompleteMultipleContainer);
        autoCompleteMultipleContainer.sendKeys(Keys.ENTER);
        input(text3, autoCompleteMultipleContainer);
        autoCompleteMultipleContainer.sendKeys(Keys.ENTER);

        return this;
    }

    public AutoCompletePage inputColorSingleContainer(String text) {
        input(text, autoCompleteSingleContainer);
        autoCompleteSingleContainer.sendKeys(Keys.ENTER);

        return this;
    }

    public List<String> checkInputColorsMultipleContainer() {

        return getTexts(inputColorsInMultipleContainer);
    }

    public String checkInputColorSingleContainer() {

        return getText(inputColorInSingleContainer);
    }
}
