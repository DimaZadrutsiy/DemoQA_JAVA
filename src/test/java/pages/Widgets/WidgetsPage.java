package pages.Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WidgetsPage extends BasePage {

    @FindBy(xpath = "//div//span[text()=\'Accordian\']")
    private WebElement accordianSubMenu;

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public WidgetsPage clickAccordianPages() {
        scrollByVisibleElement(accordianSubMenu);
        click(accordianSubMenu);

        return new AccordianPage(getDriver());
    }
}
