package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.*;
import pages.AlertsFramesWindows.*;
import pages.BookStoreApplication.BookStorePage;
import pages.BookStoreApplication.LoginPage;
import pages.BookStoreApplication.ProfilePage;
import pages.Elements.BrokenLinksImagesPage;
import pages.Elements.CheckBoxPage;
import pages.Elements.ElementsPage;
import pages.Elements.WebTablesPage;
import pages.Forms.FormsPage;
import pages.Interactions.InteractionsPage;
import pages.Widgets.WidgetsPage;
import utils.ConsoleColors;
import utils.ReportUtils;
import utils.TestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    private static final Properties props = new Properties();
    private static final String BASE_URL;

    static {
        try {
            InputStream input = BaseTest.class.getResourceAsStream("/config.properties");
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        BASE_URL = props.getProperty("BASE_URL");
    }
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public static String getBaseUrl() {

        return BASE_URL;
    }

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log(ConsoleColors.YELLOW + "TEST RUN" + ConsoleColors.RESET, true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        if (!result.isSuccess() && BaseUtils.isServerRun()) {
            BaseUtils.captureScreenFile(driver, method.getName(), this.getClass().getName());
        }

        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
        webDriverWait = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait;
    }

    public HomePage openBaseURL() {
        TestUtils.loadBaseUrlPage(getDriver(), getWait());

        if (TestUtils.isIMGHeaderExists(getDriver())) {
            Reporter.log(ConsoleColors.YELLOW_BOLD_BRIGHT + "BaseURL page was loaded successfully " + ConsoleColors.RESET, true);
        } else {
            TestUtils.reLoadBaseUrlPage(getDriver(), getWait());
        }

        return new HomePage(getDriver());
    }

    private boolean reloadPageIfElementNotFound(By by) {
        int count = 0;

        while (count <= 3 && !(isElementExists(by))) {
            getDriver().navigate().refresh();
            Reporter.log("Re-loading base URL page", true);
            count++;
        }

        return isElementExists(by);
    }

    //новые методы getPages
    public HomePage getHomePage() {

        return new HomePage(getDriver());
    }

    public AlertsFramesWindowsPage getAlertsFramesWindowsPage() {

        return new AlertsFramesWindowsPage(getDriver());
    }

    public BrowserWindowsPage getBrowserWindowsPage() {

        return new BrowserWindowsPage(getDriver());
    }

    public AlertsPage getAlertsPage() {

        return new AlertsPage(getDriver());
    }

    public FramesPage getFramesPage() {

        return new FramesPage(getDriver());
    }

    public NestedFramesPage getNestedFramesPage() {

        return new NestedFramesPage(getDriver());
    }

    public ModalDialogsPage getModalDialogsPage() {

        return new ModalDialogsPage(getDriver());
    }

    public SamplePage getSamplePage() {

        return new SamplePage(getDriver());
    }

    public BookStorePage getBookStorePage() {

        return new BookStorePage(getDriver());
    }

    public ElementsPage getElementsPage() {

        return new ElementsPage(getDriver());
    }

    public CheckBoxPage getCheckBoxPage() {

        return new CheckBoxPage(getDriver());
    }

    public FormsPage getFormsPage() {

        return new FormsPage(getDriver());
    }

    public InteractionsPage getInteractionsPage() {

        return new InteractionsPage(getDriver());
    }

    public WidgetsPage getWidgetsPage() {

        return new WidgetsPage(getDriver());
    }

    public LoginPage getLoginPage() {

        return new LoginPage(getDriver());
    }

    public ProfilePage getProfilePage() {

        return new ProfilePage(getDriver());
    }

    public WebTablesPage getWebTablesPage() {

        return new WebTablesPage(getDriver());
    }

    public BrokenLinksImagesPage getBrokenLinks_ImagesPage() {

        return new BrokenLinksImagesPage(getDriver());
    }

    // нужно пересмотреть все методы ниже и удалить ненужные


    public boolean isElementExists(By by) {
        boolean isExists = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isExists = false;
        }

        return isExists;
    }

    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public String getExternalPageTitle() {
        if (getDriver().getTitle().isEmpty()) {
            TestUtils.waitForPageLoaded(getDriver());
        }

        return getDriver().getTitle();
    }

    public String getExternalPageURL() {

        return getDriver().getCurrentUrl();
    }
}
