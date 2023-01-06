package utils;

import base.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {

//    private static final String BASE_URL = "https://demoqa.com/";
//
//    public static String getBaseUrl() {
//
//        return BASE_URL;
//    }

    private final static By IMG_HEADER = By.xpath("//div [@id = 'app']//img[@src = '/images/Toolsqa.jpg']");

    public static void loadBaseUrlPage(WebDriver driver, WebDriverWait wait) {
        driver.get(BaseTest.getBaseUrl());
        waitForPageLoaded(driver);
    }

    public static void waitForPageLoaded(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void reLoadBaseUrlPage(WebDriver driver, WebDriverWait wait) {
        int count = 0;
        while (count <= 3 && !(isIMGHeaderExists(driver))) {
            loadBaseUrlPage(driver, wait);
            count++;
        }

        if (count == 3 && !isIMGHeaderExists(driver)) {
            Reporter.log("!!!!! Error !!!!! BaseURL page was NOT loaded. Re-Run jobs\n", true);
        }
    }

    public static boolean isIMGHeaderExists(WebDriver driver) {
        boolean isExists = true;
        try {
            driver.findElement(IMG_HEADER);
        } catch (NoSuchElementException e) {
            isExists = false;
        }

        return isExists;
    }

    public static String getRandomName(int length) {

        return RandomStringUtils
                .random(length,
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    public static String getRandomName() {

        return getRandomName(7);
    }

    public static int convertStringToInt(String text) {

        return Integer.parseInt(text);
    }

    public static String getSubstring(String text, String separator) {
        int index = text.indexOf(separator);

        return text.substring(0, index);
    }

    public static List<String> getSortedList(List<String> elements) {

        return elements.stream().sorted().collect(Collectors.toList());
    }
}
