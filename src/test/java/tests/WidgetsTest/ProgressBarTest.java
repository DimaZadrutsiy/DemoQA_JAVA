package tests.WidgetsTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Widgets.ProgressBarPage;

public class ProgressBarTest extends BaseTest {

    @Test
    public void testCheckBackgroundColorProgressBar() {
        final String expectedBackgroundColor = "#28a745";

        String actualBackgroundColor = openBaseURL()
                .clickWidgetsMenu()
                .clickProgressBarPages()
                .clickStartStopButton()
                .getBackgroundColorProgressBar();

        Assert.assertEquals(actualBackgroundColor ,expectedBackgroundColor);
    }

    @Test
    public void testCheckWhatTheButtonChangesTheName() {
        final String expectedNameButtonStart = "Start";
        final String expectedNameButtonStop = "Stop";
        final String expectedNameButtonReset = "Reset";

        ProgressBarPage progressBarPage = openBaseURL()
                .clickWidgetsMenu()
                .clickProgressBarPages();

        Assert.assertEquals(progressBarPage.getNameButton(), expectedNameButtonStart);

        progressBarPage.clickStartStopButton();

        Assert.assertEquals(progressBarPage.getNameButton(), expectedNameButtonStop);

        progressBarPage.waitElements();

        Assert.assertEquals(progressBarPage.getNameButton(), expectedNameButtonReset);
    }
}
