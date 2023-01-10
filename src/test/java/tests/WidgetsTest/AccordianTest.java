package tests.WidgetsTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccordianTest extends BaseTest {


    @Test
    public void testURL_AccordianPage() {
        final String expectedURL = "https://demoqa.com/accordian";

        String actualURL = openBaseURL()
                .clickWidgetsMenu()
                .openAccordianPages()
                .getCurrentURL();

        Assert.assertEquals(expectedURL, actualURL);
    }
}
