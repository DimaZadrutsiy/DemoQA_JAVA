package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void testCheckTextAndConfirmFirstAlert() {
        final String expectedAlertText = "You clicked a button";

        String actualAlertText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickFirstAlertButton()
                .getTextAndConfirmAlertInAlertPage();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void testCheckTextAndConfirmSecondAlert() {
        final String expectedAlertText = "This alert appeared after 5 seconds";

        openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickSecondAlertButton();

        String actualAlertText = getAlertsPage().getTextAndConfirmAlertInAlertPage();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void testCheckTextAndConfirmThirdAlert() {
        final String expectedAlertMessage = "Do you confirm action?";
        final String expectedConfirmMessage = "You selected Ok";

        String actualAlertMessage = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickThirdAlertButton()
                .getTextAndConfirmAlertInAlertPage();

        String actualConfirmMessage = getAlertsPage().getConfirmMessage();

        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage);
    }
}
