package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void testCheckH1TextAndURLInNewTab() {
        final String expectedURLFirstWindow = "https://demoqa.com/browser-windows";
        final String expectedH1HeaderNewWindow = "This is a sample page";
        final String expectedURLNewWindow = "https://demoqa.com/sample";

        openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectBrowserWindowsSubMenu();

        String actualURLFirstWindow = getBrowserWindowsPage().getCurrentURL();

        String actualH1HeaderNewWindow =  getBrowserWindowsPage()
                .clickNewTabButton()
                .getH1TextFromNewWindow();

        String actualURLNewWindow = getSamplePage().getCurrentURL();

        String actualURLPreviousPage = getSamplePage().moveToPreviousPage().getCurrentURL();

        Assert.assertNotEquals(actualURLNewWindow, expectedURLFirstWindow);
        Assert.assertEquals(actualURLNewWindow, expectedURLNewWindow);
        Assert.assertEquals(actualH1HeaderNewWindow, expectedH1HeaderNewWindow);
        Assert.assertEquals(actualURLPreviousPage, expectedURLFirstWindow);
    }
}
