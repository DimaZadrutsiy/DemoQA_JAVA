package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WebTablesPage extends ElementsPage{

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div[1]/div[1]/div[1]")
    private WebElement firstNameFirstColumFirstRow;

    @FindBy(id = ("searchBox"))
    private WebElement searchField;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage inputFirstNameIntoSearchField(String firstName) {
        scrollByVisibleElement(searchField);
        inputAfterClear(searchField, firstName);

        return this;
    }

    public String getTextFirstColumnRow() {
        scrollByVisibleElement(firstNameFirstColumFirstRow);

        return getText(firstNameFirstColumFirstRow);
    }
}
