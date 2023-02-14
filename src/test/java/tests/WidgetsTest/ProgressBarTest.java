package tests.WidgetsTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
