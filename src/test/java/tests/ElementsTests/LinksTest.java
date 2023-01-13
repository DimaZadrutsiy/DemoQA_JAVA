package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {

    @Test
    public void testLinksURL() {

        String expectedLinksURL = "https://demoqa.com/links";

        String actualLinksURL = openBaseURL()
                .clickElementsMenu()
                .openLinksPage()
                .getCurrentURL();

        Assert.assertEquals(actualLinksURL, expectedLinksURL);
    }
}
