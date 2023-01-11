package tests.WidgetsTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WidgetTest extends BaseTest {

    @Test
    public void testURL_WidgetPage() {
        final String expectedURL = "https://demoqa.com/widgets";

        String actualURL = openBaseURL()
                .clickWidgetsMenu()
                .getCurrentURL();

        Assert.assertEquals(expectedURL, actualURL);
    }
}
