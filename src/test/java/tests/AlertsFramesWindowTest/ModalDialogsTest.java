package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalDialogsTest extends BaseTest {

    @Test
    public void checkSmallModalDialogBoxText() {
        final String expectedText = "This is a small modal. It has very less content";

        String actualText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectModalDialogSubMenu()
                .clickSmallModalButton()
                .getSmallModalBoxText();

        Assert.assertEquals(actualText, expectedText);
    }
}
