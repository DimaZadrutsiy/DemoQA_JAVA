package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ElementsPage extends BasePage {
    
    @FindBy(xpath = "//div[@class = 'element-list collapse show']//span")
    private List<WebElement> elementsList;

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
}
