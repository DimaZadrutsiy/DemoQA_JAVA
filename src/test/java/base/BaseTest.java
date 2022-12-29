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
    public String getText(By by) {
        WebElement element = getDriver().findElement(by);
        if (!element.getText().isEmpty()) {
            getWait10().until(ExpectedConditions.visibilityOfElementLocated(by));
        }

        return element.getText();
    }

    public boolean isTextContains(By by, String text) {

        return getText(by).contains(text);
    }

    public String getTextWaiting(By by) {
        getWait20().until(ExpectedConditions.visibilityOfElementLocated(by));

        return getDriver().findElement(by).getText();
    }

    public void click(By by) {
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(by));
        getWait10().until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void click20(By by) {
        getWait20().until(ExpectedConditions.visibilityOfElementLocated(by));
        getWait20().until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void input(String text, By by) {

        getDriver().findElement(by).sendKeys(text);
    }

    public void waitElementToBeVisible(By by) {
        getWait20().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitTextToBeChanged(By by, String text) {
        getWait10().until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(driver.findElement(by), text)));
    }

    public boolean isDisplayed(By by) {

        return getDriver().findElement(by).isDisplayed();
    }

    public int countElements(By by) {
        return driver.findElements(by).size();
    }

    public String systemDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, hh:mma");

        return sdf.format(date).substring(0, 10);
    }

    public String getCurrentURL() {

        return getDriver().getCurrentUrl();
    }

    public List<WebElement> getListOfElements(By by) {

        return getDriver().findElements(by);
    }

    public int getListSize(By by) {

        return getListOfElements(by).size();
    }

    public String getTextByAttribute(By by, String attribute) {

        return getDriver().findElement(by).getAttribute(attribute);
    }

    public int findAllVisibleElements(String xpath, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElement(By.xpath(xpath))));
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        return elements.size();
    }

    public void scrollByVisibleElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", getDriver().findElement(by));
    }

    public void switchToAnotherWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public String getTitle() {

        return getDriver().getTitle();
    }

    public void switchWindow() {
        ArrayList<String> newWindow = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newWindow.get(1));
    }

    public int seeAllElementAndCount(By by) {
        getWait20().until(ExpectedConditions.visibilityOfAllElements(getDriver().findElement(by)));
        List<WebElement> allElements = getDriver().findElements(by);
        int count = allElements.size();
        for (WebElement checkedElement : allElements) {
            getWait20().until(ExpectedConditions.elementToBeClickable(checkedElement));
        }

        return count;
    }

    public void inputAndEnter(By by, String text) {
        getWait10().until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));
        getDriver().findElement(by).sendKeys(text, Keys.ENTER);
    }

    public String backgroundColor(By by) {
        getWait10().until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));

        return getDriver().findElement(by).getCssValue("background-color");
    }

    public boolean isElementExists(By by) {
        boolean isExists = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isExists = false;
        }

        return isExists;
    }

    public void openURL(String url) {
        getDriver().get(url);
    }

    public boolean isElementEnabled(By by) {

        return getDriver().findElement(by).isEnabled();
    }

    public void jumpToNextWindow() {
        String mainWindows = getDriver().getWindowHandle();
        for (String windowsHandle : getDriver().getWindowHandles()) {
            if (!mainWindows.contentEquals(windowsHandle)) {
                getDriver().switchTo().window(windowsHandle);
                break;
            }
        }
    }

    public boolean isContainsTextInUrl(String text) {
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl.contains(text);
    }

    public void inputTextAndClickEnter(By by, String text) {
        getDriver().findElement(by).sendKeys(text + Keys.ENTER);
    }

    public List<String> getListText(By by) {
        List<String> elements = new ArrayList<>();

        for (WebElement temp : getDriver().findElements(by)) {
            elements.add(temp.getText());
        }

        return elements;
    }

    public void waitForElement(By by) {
        getWait20().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean checkWebElementIsVisibleOrNotVisible(By by, WebDriver driver) {
        try {
            driver.findElement(by).isDisplayed();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean checkWebElementIsEnabledOrDisabled(By by, WebDriver driver) {
        try {
            driver.findElement(by).isEnabled();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void scrollToPageBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickByKeyEnter(By by) {
        getDriver().findElement(by).sendKeys(Keys.ENTER);
    }

    public int getSizeList(List<String> list) {
        return list.size();
    }

    public List<String> getElemntsText(By by) {
        List<WebElement> elementtList = getListOfElements(by);
        List<String> textList = new ArrayList<>();
        for (WebElement element : elementtList) {
            textList.add(element.getText());
        }
        return textList;
    }

    public void getSmallSizeWindow(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    public boolean isElementsListActive(By by) {
        boolean active = false;
        List<WebElement> list = getDriver().findElements(by);
        for (WebElement element : list) {
            if (element.isEnabled()) {
                active = true;
            }
        }
        return active;
    }

    public void waitElementToBeClickable(By by) {
        getWait20().until(ExpectedConditions.elementToBeClickable(by));
    }

    public void CopyAndPast(By by, By id) {
        Actions act = new Actions(getDriver());
        WebElement apiKeyFrom = getDriver().findElement(by);
        WebElement apiKeyWhere = getDriver().findElement(id);
        act.moveToElement(apiKeyFrom).doubleClick();
        act.keyDown(Keys.CONTROL).sendKeys("c");
        act.moveToElement(apiKeyWhere).click().keyDown(Keys.CONTROL).sendKeys("v");
        act.keyUp(Keys.CONTROL).build().perform();
    }

    public void scrollToElement(By by) {
        WebElement scroll = getDriver().findElement(by);
        new Actions(getDriver())
                .scrollToElement(scroll)
                .perform();
    }

    public void waitForGrayContainerAppeared() {
        getWait20().until(ExpectedConditions.visibilityOfElementLocated(
                By.className("owm-loader-container")));
    }

    public String getCssStyleColor(By by) {
        String color = getDriver().findElement(by).getCssValue("color");

        String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);

        return String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
    }


    public static int daysInMonth(int month, int year) {
        int numDays;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) &&
                        !(year % 100 == 0))
                        || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:

                return 0;
        }

        return numDays;
    }

    public String returnMonth(int number) {
        if (number > 0 && number < 13) {
            switch (number) {
                case 1:
                    return "Jan";
                case 2:
                    return "Feb";
                case 3:
                    return "Mar";
                case 4:
                    return "Apr";
                case 5:
                    return "May";
                case 6:
                    return "Jun";
                case 7:
                    return "Jul";
                case 8:
                    return "Aug";
                case 9:
                    return "Sep";
                case 10:
                    return "Oct";
                case 11:
                    return "Nov";
                case 12:
                    return "Dec";
            }
        }
        return "Error";
    }

    public int returnMonth(String month) {
        if (month != null) {
            switch (month) {
                case "Jan":
                    return 1;
                case "Feb":
                    return 2;
                case "Mar":
                    return 3;
                case "Apr":
                    return 4;
                case "May":
                    return 5;
                case "Jun":
                    return 6;
                case "Jul":
                    return 7;
                case "Aug":
                    return 8;
                case "Sep":
                    return 9;
                case "Oct":
                    return 10;
                case "Nov":
                    return 11;
                case "Dec":
                    return 12;
            }
        }
        return 0;
    }

    public String returnDayOfTheWeek(int number) {
        if (number > 0 && number < 8) {

            switch (number) {
                case 1:
                    return "Mon";
                case 2:
                    return "Tue";
                case 3:
                    return "Wed";
                case 4:
                    return "Thu";
                case 5:
                    return "Fri";
                case 6:
                    return "Sat";
                case 7:
                    return "Sun";
            }
        }
        return "Error";
    }

    public int returnDayOfTheWeek(String day) {
        if (day != null) {

            switch (day) {
                case "Mon":
                    return 1;
                case "Tue":
                    return 2;
                case "Wed":
                    return 3;
                case "Thu":
                    return 4;
                case "Fri":
                    return 5;
                case "Sat":
                    return 6;
                case "Sun":
                    return 7;
            }
        }

        return 0;
    }

    public String returnDate(int date) {
        if (date < 10) {

            return "0" + date;
        } else {
            return String.valueOf(date);
        }
    }

    public void clear(By by) {
        getWait10().until(ExpectedConditions.visibilityOf(getDriver().findElement(by))).clear();
    }

    public WebElement getElement(By by) {
        return getDriver().findElement(by);
    }

    public List<String> getLinksList(By xpath, By tagName) {
        List<String> linksList = new ArrayList<>();
        for (WebElement link : getDriver().findElement(xpath).findElements(tagName)) {
            linksList.add(link.getText());
        }
        return linksList;
    }

    public String getTitleNameConfirmed(By by) {
        return getDriver().findElement(by).getText();
    }

    public void iterateWindows() {
        Iterator<String> iter = getDriver().getWindowHandles().iterator();
        iter.next();
        getDriver().switchTo().window(iter.next());
    }

    public void selectOption(By by, String text) {
        Select option = new Select(getDriver().findElement(by));
        option.selectByValue(text);
    }

    public void clickOnButton(By by) {
        WebElement Button = getDriver().findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", Button);
    }

    public void changeWindowResolution(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }


    public void clickAllElements(By by) {
        List<WebElement> allElements = getDriver().findElements(by);
        for (WebElement checkedElement : allElements) {
            getWait20().until(ExpectedConditions.elementToBeClickable(checkedElement)).click();
        }
    }

    public boolean checkingForUnselectedElements(By by) {
        boolean evenOneIsUnchecked = false;
        List<WebElement> allElements = getDriver().findElements(by);
        for (WebElement checkbox : allElements) {
            if (!checkbox.findElement(By.cssSelector("*, :after, :before")).isSelected()) {
                evenOneIsUnchecked = true;
            }
        }

        return evenOneIsUnchecked;
    }

    public void waitForElementToBeDisappeared(By by) {
        getWait10().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitURLToBeChanged(String url) {
        getWait10().until(ExpectedConditions
                .not(ExpectedConditions.urlToBe(url)));
    }

    public void waitTitleToBeChanged(String title) {
        getWait10().until(ExpectedConditions
                .not(ExpectedConditions.titleIs(title)));
    }

    public By getXPathOfElementWithExactIndex(By by, int numberInSequence) {
        String NumberInSequence = String.valueOf(numberInSequence);
        return By.xpath(by.toString().substring(10, by.toString().length() - 2) + NumberInSequence + "]");

    }

    public void clickByJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.scrollToElement(element).perform();
    }

    public void scrollByPixels(String x, String y) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
    }

    public void logger_Info(String str) {
        final Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO, String.valueOf(str));
    }

    public String getAttributeValueAfterClick(By by, String nameOfAttribute) {
        click(by);
        WebElement elementAfterClick = getDriver().findElement(by);

        return elementAfterClick.getAttribute(nameOfAttribute);
    }

    public void switchToSpecificWindows(int numberWindow) {
        ArrayList<String> newWindow = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newWindow.get(numberWindow));
    }

    public boolean checkIfAllElementsAreVisibleAndClickable(By by) {
        List<WebElement> list = getDriver().findElements(by);
        boolean isAllElementsAreVisibleAndClickable = false;

        for (WebElement element: list) {
            if(element.isEnabled() && element.isDisplayed()) {
                isAllElementsAreVisibleAndClickable = true;
            } else {
                isAllElementsAreVisibleAndClickable = false;
                break;
            }
        }

        return isAllElementsAreVisibleAndClickable;
    }

    public ArrayList<String> returnsTheWindowIdList() {
        ArrayList<String> idAllWindows = new ArrayList<>(getDriver().getWindowHandles());

        return idAllWindows;
    }

    public List<String> getListOfHeadersWhenClickLinks (By byLink, By byHeader) {
        List<String> elements = new ArrayList<>();

        for (int i = 0; i < getListOfElements(byLink).size(); i++) {
            getListOfElements(byLink).get(i).click();
            elements.add(getListOfElements(byHeader).get(i).getText());
        }

        return elements;
    }

    public void clearDataInputField(By by){
        getWait10().until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));

        getDriver().findElement(by).clear();
    }

    public String getBackgroundColor(By by){
        getWait10().until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));

        return getDriver().findElement(by).getCssValue("background-color");
    }

    public String getFontSize(By by){
        getWait10().until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));

        return getDriver().findElement(by).getCssValue("font-size");
    }
}
