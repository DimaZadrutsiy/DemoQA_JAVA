package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTest extends BaseTest {

    @Test
    public void testURL_ElementsPage() {
        final String expectedURL = "https://demoqa.com/elements";

        String actualURL = openBaseURL()
                .clickElementsMenu()
                .getCurrentURL();

        Assert.assertEquals(actualURL, expectedURL);
    }
}

