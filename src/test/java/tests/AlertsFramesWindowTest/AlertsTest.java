package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void testCheckOneClickAlert() {
        final String expectedAlertText = "You clicked a button";

        String actualAlertText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickOnceAlertButton()
                .getTextFromAlert();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }
}
