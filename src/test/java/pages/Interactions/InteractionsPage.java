package pages.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class InteractionsPage extends BasePage {

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    @FindBy(xpath = "//span[text()='Sortable']")
    private WebElement sortable;

    @FindBy(xpath = "//span[text()='Selectable']")
    private WebElement selectable;

    @FindBy(xpath = "//span[text()='Resizable']")
    private WebElement resizable;

    @FindBy(xpath = "//span[text()='Droppable']")
    private WebElement droppable;

    @FindBy(xpath = "//span[text()='Dragabble']")
    private WebElement dragabble;

    @FindBy(xpath = "//div[@class ='element-list collapse show' ]/ul/li")
    private List<WebElement> interactionsPageSubmenus;

    @FindBy(xpath = "//div[@class ='element-list collapse show' ]/ul")
    private WebElement dropDownMenu;

    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    public SortablePage clickSortablePage() {
        scrollByVisibleElement(sortable);
        click(sortable);

        return new SortablePage(getDriver());
    }

    public SelectablePage clickSelectablePage() {
        wait10ElementToBeClickable(selectable);
        scrollByVisibleElement(selectable);
        click(selectable);

        return new SelectablePage(getDriver());
    }

    public ResizablePage clickResizablePage() {
        scrollByVisibleElement(resizable);
        click(resizable);

        return new ResizablePage(getDriver());
    }

    public DroppablePage clickDroppablePage() {
        scrollByVisibleElement(droppable);
        wait10ElementToBeClickable(droppable);
        click(droppable);

        return new DroppablePage(getDriver());
    }

    public DragabblePage clickDragabblePage() {
        scrollByVisibleElement(dragabble);
        click(dragabble);

        return new DragabblePage(getDriver());
    }

    public List<WebElement> getInteractionsPageSubmenus() {

        return interactionsPageSubmenus;
    }

    public InteractionsPage clickMenu(int index, List<WebElement> menus) {
        wait10ElementToBeClickable(dropDownMenu);
        scrollByVisibleElement(menus.get(index));
        menus.get(index).click();

        return this;
    }
}
