package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void testCheckOneClickAlertText() {
        final String expectedAlertText = "You clicked a button";

        String actualAlertText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickOnceAlertButton()
                .getTextFromAlert();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void testCheckOneClickAndWaitAlertText() {
        final String expectedAlertText = "This alert appeared after 5 seconds";

        openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickOnceAndWaitAlertButton();

        String actualAlertText = getAlertsPage().getTextFromAlert();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }
}
