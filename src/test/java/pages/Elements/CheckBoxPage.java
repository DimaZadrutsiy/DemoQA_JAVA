package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends ElementsPage{

    @FindBy(css = "#tree-node > ol input[type = 'checkbox']")
    private List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//div[@id = 'tree-node']//label")
    private List<WebElement> allCheckBoxesClick;

    @FindBy(xpath = "//label[@for = 'tree-node-home']")
    private WebElement homeCheckBoxClick;

    @FindBy(css = "input[id ='tree-node-home']")
    private WebElement homeCheckBox;

    @FindBy(css = "input[id ='tree-node-desktop']")
    private WebElement desktopCheckBox;

    @FindBy(css = "input[id ='tree-node-notes']")
    private WebElement notesCheckBox;

    @FindBy(css = "input[id ='tree-node-commands']")
    private WebElement commandsCheckBox;

    @FindBy(css = "input[id ='tree-node-documents']")
    private WebElement documentsCheckBox;

    @FindBy(css = "input[id ='tree-node-workspace']")
    private WebElement workspaceCheckBox;

    @FindBy(css = "input[id ='tree-node-react']")
    private WebElement reactCheckBox;

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
        scrollByVisibleElement(homeCheckBoxClick);
        if (homeCheckBoxClick.isDisplayed() && homeCheckBoxClick.isEnabled()) {
             click(homeCheckBoxClick);
        }

        return new  CheckBoxPage(getDriver());
    }

    public boolean isHomeCheckBoxSelected() {

        return isElementSelected(homeCheckBox);
    }

    public boolean isDesktopCheckBoxSelected() {

        return isElementSelected(desktopCheckBox);
    }

    public boolean isNotesCheckBoxSelected() {

        return isElementSelected(notesCheckBox);
    }

    public boolean isCommandsCheckBoxSelected() {

        return isElementSelected(commandsCheckBox);
    }

    public boolean isDocumentsCheckBoxSelected() {

        return isElementSelected(documentsCheckBox);
    }

    public boolean isWorkspaceCheckBoxSelected() {

        return isElementSelected(workspaceCheckBox);
    }

    public boolean isReactCheckBoxSelected() {

        return isElementSelected(reactCheckBox);
    }

    public boolean isAllCheckBoxesSelected() {

        return isElementsInListSelected(allCheckBoxes);
    }

    public CheckBoxPage clickExpandAll() {
        click(expandAll);
        return new  CheckBoxPage(getDriver());
    }

    public CheckBoxPage clickOnExcelFileCheckBox() {
        scrollByVisibleElement(excelFileCheckBoxClick);
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

}
