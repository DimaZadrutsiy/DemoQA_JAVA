package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.LinksPage;

public class LinksTest extends BaseTest {

    @Test
    public void testLinksURL() {

        String expectedResult = "https://demoqa.com/links";

        LinksPage linksPage = openBaseURL()
                .clickElementsMenu()
                .clickLinksPage();

        String actualResult = linksPage.getCurrentURL();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
