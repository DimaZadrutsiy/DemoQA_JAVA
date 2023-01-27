package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void testCheckH1TextAndURLInNewTab() {
        final String expectedURLFirstWindow = "https://demoqa.com/browser-windows";
        final String expectedH1HeaderNewTab = "This is a sample page";
        final String expectedURLNewTab = "https://demoqa.com/sample";

        openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectBrowserWindowsSubMenu();

        String actualURLFirstWindow = getBrowserWindowsPage().getCurrentURL();

        String actualH1HeaderNewWindow =  getBrowserWindowsPage()
                .clickNewTabButton()
                .getH1TextFromNewWindow();

        String actualURLNewTab = getSamplePage().getCurrentURL();

        String actualURLPreviousWindow = getSamplePage().moveToPreviousPage().getCurrentURL();

        Assert.assertNotEquals(actualURLNewTab, expectedURLFirstWindow);
        Assert.assertEquals(actualURLNewTab, expectedURLNewTab);
        Assert.assertEquals(actualH1HeaderNewWindow, expectedH1HeaderNewTab);
        Assert.assertEquals(actualURLPreviousWindow, expectedURLFirstWindow);
    }

    @Test
    public void testCheckH1TextAndURLInNewWindow() {
        final String expectedURLFirstWindow = "https://demoqa.com/browser-windows";
        final String expectedH1HeaderNewWindow = "This is a sample page";
        final String expectedURLNewWindow = "https://demoqa.com/sample";

    openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectBrowserWindowsSubMenu();

    String actualURLFirstWindow = getBrowserWindowsPage().getCurrentURL();

    String actualH1HeaderNewWindow =  getBrowserWindowsPage()
            .clickNewWindowButton()
            .getH1TextFromNewWindow();

    String actualURLNewWindow = getSamplePage()
            .getCurrentURL();

    String actualURLPreviousWindow = getSamplePage()
            .moveToPreviousPage()
            .getCurrentURL();

        Assert.assertNotEquals(actualURLNewWindow, expectedURLFirstWindow);
        Assert.assertEquals(actualURLNewWindow, expectedURLNewWindow);
        Assert.assertEquals(actualH1HeaderNewWindow, expectedH1HeaderNewWindow);
        Assert.assertEquals(actualURLPreviousWindow, expectedURLFirstWindow);
}

    //подивіться цей тест, будь-ласка. Фаєрфокс відкриває вікно нормально, а Хром не показує url
    @Ignore
    @Test
    public void testCheckTextInNewWindowMessage() {
        final String expectedTextNewWindowMessage = "Knowledge increases by sharing but not by saving. " +
                "Please share this website with your friends and in your organization.";

        String actualTextNewWindowMessage = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectBrowserWindowsSubMenu()
                .clickNewWindowMessageButton()
                .getNewWindowMessageBodyText();

        Assert.assertEquals(actualTextNewWindowMessage, expectedTextNewWindowMessage);
    }
}
