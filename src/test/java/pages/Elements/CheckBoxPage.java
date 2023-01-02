package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends ElementsPage{

    @FindBy(css = "input[type = 'checkbox']")
    private List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//label[@for = 'tree-node-home']")
    private WebElement homeCheckBoxClick;

    @FindBy(css = "input[id ='tree-node-home']")
    private WebElement homeCheckBox;

    @FindBy(xpath = "//button[@class = 'rct-option rct-option-expand-all']")
    private WebElement expandAll;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxPage clickOnHomeCheckBox() {
        if (homeCheckBoxClick.isDisplayed() && homeCheckBoxClick.isEnabled()) {
             click(homeCheckBoxClick);
        }

        return new  CheckBoxPage(getDriver());
    }

    public boolean isHomeCheckBoxSelected() {

        return isElementSelected(homeCheckBox);
    }

    public CheckBoxPage clickExpandAll() {
        click(expandAll);
        return new  CheckBoxPage(getDriver());
    }

    public boolean isAllCheckBoxSelected() {

        return isElementsInListSelected(allCheckBoxes);
    }
}
