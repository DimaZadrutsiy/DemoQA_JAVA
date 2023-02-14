package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"Regression"})
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

    @Test
    public void testCheckTextAndDismissThirdAlert() {
        final String expectedAlertMessage = "Do you confirm action?";
        final String expectedConfirmMessage = "You selected Cancel";

        String actualAlertMessage = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickThirdAlertButton()
                .getTextAndDismissAlertInAlertPage();

        String actualConfirmMessage = getAlertsPage().getConfirmMessage();

        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage);
    }

    @Test
    public void testEnterTextAndConfirmForthAlert() {
        final String text = "some text";
        final String expectedPromptResultMessage = "You entered " + text;

        openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickForthAlertButton()
                .enterTextAndConfirmAlertInAlertPage(text);

        String actualPromptResultMessage = getAlertsPage().getPromptResultMessage();

        Assert.assertEquals(actualPromptResultMessage, expectedPromptResultMessage);
    }

    @Test
    public void testCheckTextAndConfirmForthAlert() {
        final String expectedAlertText = "Please enter your name";

        String actualAlertText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickForthAlertButton()
                .getTextAndConfirmAlertInAlertPage();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void testDismissForthAlert() {

       openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectAlertsSubMenu()
                .clickForthAlertButton()
                .dismissAlertInAlertPage();

        Assert.assertFalse(getAlertsPage().isAlertDisplayedInAlertPage());
    }
}
