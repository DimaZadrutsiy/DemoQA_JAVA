package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testHeaderNames() {
        final List<String> expectedNamesHeader = new ArrayList<>();
        expectedNamesHeader.add("Following links will open new tab");
        expectedNamesHeader.add("Following links will send an api call");

        List<String> actualNamesHeader = openBaseURL()
                .clickElementsMenu()
                .openLinksPage()
                .getHeadersName();

        Assert.assertEquals(actualNamesHeader, expectedNamesHeader);
    }
}

