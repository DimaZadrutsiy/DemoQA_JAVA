package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import service.ConfProperties;
import service.LoggingConfProperties;

import java.time.Duration;
import java.util.*;

public abstract class BasePage {
    private final WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait10;
    private Actions actions;
    protected ConfProperties properties;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.properties = new LoggingConfProperties(new ConfProperties());
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(driver);
        }

        return actions;
    }

    public String getTitle() {

        return getDriver().getTitle();
    }

    public String getCurrentURL() {

        return getDriver().getCurrentUrl();
    }

    public String getFormattedURL() {

        return getDriver().getCurrentUrl().substring(0, 37);
    }

    public String getText(WebElement element) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getText();
    }
    protected List<String> getTexts(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> textList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    textList.add(element.getText().trim());
                }
            }

            return textList;
        }

        return new ArrayList<>();
    }

    protected List<String> getTrimmedTexts(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(getText(element).trim());
        }

        return texts;
    }

    protected List<WebElement> getListOfVisibleElements(List<WebElement> list, int listSize) {
        List<WebElement> visibleElements = new ArrayList<>();

        if (!(list.size() > 0)) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            for (WebElement element : list) {
                if (!element.isDisplayed() && !element.isEnabled()) {
                    getWait20().until(ExpectedConditions.visibilityOf(element));
                    visibleElements.add(element);
                }
            }
        } else if (list.size() == listSize) {

            return list;
        }

        return visibleElements;
    }

    protected boolean isElementsInListContainsText(List<WebElement> list, String str) {

        for (WebElement element : list) {
            if (element.getText().trim().contains(str)) {

                return true;
            }
        }

        return false;
    }
    public String getAttribute(WebElement element, String attribute) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getAttribute(attribute);
    }

    protected String getBackgroundColor(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("background-color");
    }

    public String getBackgroundColourInHEX(WebElement element) {

        return Color.fromString(getBackgroundColor(element)).asHex();
    }

    protected String getFontSize(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("font-size");
    }

    public int getListSize(List<WebElement> list) {

        return list.size();
    }

    protected void click(WebElement element) {
        wait10ElementToBeVisible(element);
        wait10ElementToBeClickable(element).click();
    }

    protected void click20(WebElement element) {
        wait20ElementToBeVisible(element);
        wait20ElementToBeClickable(element).click();
    }

    protected void clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void clickEnter(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ENTER);
    }

    protected void clickArrowUp(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ARROW_UP);
    }

    protected void clickAllElementsInList(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);

        for (WebElement element : allElements) {
            if (element.isEnabled() && element.isDisplayed()) {
                wait10ElementToBeVisible(element);
                wait10ElementToBeClickable(element).click();
            } else {
                Reporter.log("Element " + element + " is not visible or not clickable ", true);
            }
        }
    }

    protected void clear(WebElement element) {

        element.clear();
    }

    protected void input(String text, WebElement element) {

        element.sendKeys(text);
    }

    protected void inputAndEnter(WebElement element, String text) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text, Keys.ENTER);
    }

    protected void inputAfterClear(WebElement element, String text) {
        click20(element);
        clear(element);
        input(text, element);
    }

    protected void setWindowDimensions(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    protected void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    protected void scrollByVisibleElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void goBack() {
        getDriver().navigate().back();
    }

    protected void selectOption(WebElement element, String text) {
        Select option = new Select(element);
        option.selectByValue(text);
    }

    protected void waitForTextNotToBeEmpty(WebElement element) {
        while (element.getText() == null || element.getText().length() < 1) {
            getWait20().until(ExpectedConditions
                    .not(ExpectedConditions.textToBePresentInElement(element, "")));
        }
    }

    protected void wait10ElementToBeVisible(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    protected void wait20ElementToBeVisible(WebElement element) {
        getWait20().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement wait10ElementToBeClickable(WebElement element) {

        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement wait20ElementToBeClickable(WebElement element) {

        return getWait20().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForUrlContains(String text) {
        getWait10().until(ExpectedConditions.urlContains(text));
    }

    protected void waitTextToBeChanged(WebElement element, String text) {
        getWait20().until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    protected boolean isElementDisplayed(WebElement element) {

        return element.isDisplayed();
    }

    protected boolean isElementsInListDisplayed(List<WebElement> list) {
        boolean result = false;

        for (WebElement element : list) {
            if (element.isDisplayed()) {
                result = true;
            } else {

                return false;
            }
        }

        return result;
    }

    protected boolean isAllElementsVisibleAndClickable(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);
        int elementsSize = elements.size();
        int count = 0;

        for (WebElement checkedElement : allElements) {
            if (checkedElement.isEnabled() && checkedElement.isDisplayed()) {
                wait10ElementToBeClickable(checkedElement);
                count++;
            }
        }

        return elementsSize == count;
    }

    protected boolean isTextContains(WebElement webElement, String text) {

        return getText(webElement).contains(text);
    }

    protected boolean isElementEnabled(WebElement webElement) {
        return webElement.isEnabled();
    }

    protected boolean isElementSelected(WebElement webElement) {
        return webElement.isSelected();
    }

    protected boolean isElementsInListSelected(List<WebElement> list) {
        boolean result = false;

        for (WebElement element : list) {
            wait10ElementToBeVisible(element);
            if (element.getAttribute("class").contains("rct-icon rct-icon-check")) {
                result = true;
            }
        }

        return result;
    }

    public void switchToIframe(WebElement iframe) {
        getDriver().switchTo().frame(iframe);
    }

    public void switchToParentFrame() {
        getDriver().switchTo().parentFrame();
    }

    public List<String> reversedList(List<WebElement> list) {
        for (int i = 1; i < list.size(); i++) {
            wait10ElementToBeVisible(list.get(i));
            new Actions(driver)
                    .dragAndDrop(list.get(i), list.get(0))
                    .release()
                    .build()
                    .perform();
        }

        return getTexts(list);
    }

    public List<String> randomList(List<WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            scrollByVisibleElement(list.get(i));
            wait10ElementToBeVisible(list.get(i));
            int random = (int) Math.floor(Math.random() * list.size());
            new Actions(driver)
                    .dragAndDrop(list.get(i), list.get(random))
                    .release()
                    .build()
                    .perform();
        }

        return getTexts(list);
    }

    protected void acceptAlert() {
        getWait20().until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void dragAndDrop(WebElement fromElement) {
        wait10ElementToBeVisible(fromElement);
        scrollByVisibleElement(fromElement);
                new Actions(driver)
                .dragAndDropBy(fromElement, 291, 45)
                .build()
                .perform();
    }
    
    protected String getTextFromAlert() {
        getWait20().until(ExpectedConditions.alertIsPresent());

        return getDriver().switchTo().alert().getText();
    }

    protected String getTextAndConfirmAlert() {
        getWait20().until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        String text = alert.getText();
        alert.accept();

        return text;
    }

    protected String getTextAndDismissAlert() {
        getWait20().until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        String text = alert.getText();
        alert.dismiss();

        return text;
    }

    protected void enterTextAndConfirmAlert (String text) {
        getWait20().until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    protected void dismissAlert() {
        getWait20().until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().dismiss();
    }

    protected boolean isAlertDisplayed() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    protected String getSaltString(String str, int length) {

        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * str.length());
            salt.append(str.charAt(index));
        }
        return salt.toString();
    }

    protected boolean isElementEmpty(List<WebElement> list) {
        for (WebElement element : list) {
            if (element.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

