package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends ElementsPage{

    @FindBy(css = "#tree-node > ol input")
    private List<WebElement> allCheckBoxes;

    @FindBy(css = ".rct-checkbox")
    private List<WebElement> allCheckBoxesClick;

    @FindBy(xpath = "//label[@for = 'tree-node-home']")
    private WebElement homeCheckBoxClick;

    @FindBy(css = "input[id ='tree-node-home']")
    private WebElement homeCheckBox;

    @FindBy(xpath = "//button[@class = 'rct-option rct-option-expand-all']")
    private WebElement expandAll;

    @FindBy(xpath = "//label[@for = 'tree-node-excelFile']")
    private WebElement excelFileCheckBoxClick;

    @FindBy(css = "input[id ='tree-node-excelFile']")
    private WebElement excelFileCheckBox;

    @FindBy(xpath = "//div[@id = 'result']//span[@class = 'text-success']")
    private List<WebElement> selectedResult;

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

    public CheckBoxPage clickOnExcelFileCheckBox() {
        if (excelFileCheckBoxClick.isDisplayed() && excelFileCheckBoxClick.isEnabled()) {
            click(excelFileCheckBoxClick);
        }

        return new  CheckBoxPage(getDriver());
    }

    public boolean isExcelFileCheckBoxSelected() {

        return isElementSelected(excelFileCheckBox);
    }

    public List<String> selectedResult() {

        return getTexts(selectedResult);
    }

    public boolean isAllCheckBoxDisplayed() {

        return areElementsInListDisplayed(allCheckBoxesClick);
    }
}
