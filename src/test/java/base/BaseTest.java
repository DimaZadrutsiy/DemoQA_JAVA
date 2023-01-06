package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.reporters.jq.Main;
import pages.*;
import pages.AlertsFramesWindows.AlertsFramesWindowsPage;
import pages.BookStoreApplication.BookStorePage;
import pages.BookStoreApplication.LoginPage;
import pages.BookStoreApplication.ProfilePage;
import pages.Elements.ElementsPage;
import pages.Forms.FormsPage;
import pages.Interactions.InteractionsPage;
import pages.Widgets.WidgetsPage;
import utils.ReportUtils;
import utils.TestUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseTest {
    public final String BASE_URL = TestUtils.getBaseUrl();
    private WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait10;

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();
        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
        webDriverWait20 = null;
        webDriverWait10 = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }

    // вместо void поставила возврат Homepage
    public HomePage openBaseURL() {
        getDriver().get(BASE_URL);

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

    public BookStorePage getBookStorePage() {

        return new BookStorePage(getDriver());
    }

    public ElementsPage getElementsPage() {

        return new ElementsPage(getDriver());
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

}
