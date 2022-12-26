package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h5[contains(text(),'Elements')]")
    private WebElement elementsMenu;

    @FindBy(xpath = "//h5[contains(text(),'Forms')]")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement alertsMenu;

    @FindBy(xpath = "//h5[contains(text(),'Widgets')]")
    private WebElement widgetsMenu;

    @FindBy(xpath = "//h5[contains(text(),'Interactions')]")
    private WebElement interactionsMenu;

    @FindBy(xpath = "//h5[contains(text(),'Book Store Application')]")
    private WebElement bookStoreMenu;

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getH2LogoHeaderText() {

        return getText(h2LogoHeader);
    }

   public ElementsPage clickElementsMenu() {
        scrollByVisibleElement(elementsMenu);
        click(elementsMenu);

        return new ElementsPage(getDriver());
   }

   public FormsPage clickFormsMenu() {
        scrollByVisibleElement(formsMenu);
        click(formsMenu);

        return new FormsPage(getDriver());
   }

   public AlertsFramesWindowsPage clickAlertsFramesWindowsMenu() {
        scrollByVisibleElement(alertsMenu);
        click(alertsMenu);

        return new AlertsFramesWindowsPage(getDriver());
   }

   public WidgetsPage clickWidgetsMenu() {
        scrollByVisibleElement(widgetsMenu);
        click(widgetsMenu);

        return new WidgetsPage(getDriver());
   }

   public InteractionsPage clickInteractionsMenu() {
        scrollByVisibleElement(interactionsMenu);
        click(interactionsMenu);

        return new InteractionsPage(getDriver());
   }

   public BookStoreApplicationPage clickBookStoreApplicationMenu() {
        scrollByVisibleElement(bookStoreMenu);
        click(bookStoreMenu);

        return new BookStoreApplicationPage(getDriver());
   }
}
