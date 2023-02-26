package tests.AlertsFramesWindowTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalDialogsTest extends BaseTest {

    @Test
    public void testCheckSmallModalDialogBoxText() {
        final String expectedText = "This is a small modal. It has very less content";

        String actualText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectModalDialogSubMenu()
                .clickSmallModalButton()
                .getSmallModalBoxText();

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testCheckLargeModalDialogBoxText() {
        final String expectedText = "Lorem Ipsum is simply dummy text of the printing and" +
                " typesetting industry. Lorem Ipsum has been the industry's standard dummy text " +
                "ever since the 1500s, when an unknown printer took a galley of type and scrambled " +
                "it to make a type specimen book. It has survived not only five centuries, " +
                "but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem " +
                "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker" +
                " including versions of Lorem Ipsum.";

        String actualText = openBaseURL()
                .clickAlertsFramesWindowsMenu()
                .selectModalDialogSubMenu()
                .clickLargeModalButton()
                .getLargeModalBoxText();

        Assert.assertEquals(actualText, expectedText);
    }
}
