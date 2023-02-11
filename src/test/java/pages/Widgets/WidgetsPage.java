package pages.Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class WidgetsPage extends BasePage {

    @FindBy(xpath = "//div//span[text()=\'Accordian\']")
    private WebElement accordianSubMenu;

    @FindBy(xpath = "//div[@class = 'element-list collapse show']//ul[@class = 'menu-list']//span")
    private List<WebElement> elementsList;

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public WidgetsPage clickAccordianPages() {
        scrollByVisibleElement(accordianSubMenu);
        click(accordianSubMenu);

        return new AccordianPage(getDriver());
    }

    public List<String> getWidgetsSubMenuHeaders() {

        return getTextToList(elementsList);
    }

    public int getWidgetsSubMenuAmount() {

        return getListSize(elementsList);
    }
}
