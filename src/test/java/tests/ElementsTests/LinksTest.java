package tests.ElementsTests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.LinksPage;
import pages.Interactions.InteractionsPage;
import testData.TestData;

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

    @Test
    public void testHomeLinkRedirection() {

        String expectedHomeLinkRedirection = "https://demoqa.com/";

        LinksPage actualHomeLinkRedirection = openBaseURL()
                .clickElementsMenu()
                .openLinksPage()
                .clickOnHomeLink();

        actualHomeLinkRedirection.switchToWindow();

        Assert.assertTrue(actualHomeLinkRedirection.getCurrentURL().contains(expectedHomeLinkRedirection));
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "CorrectCodeAndNameLinks")
    public void testCheckingResponseCodeAndNameAfterLinkIsClicked(
            int index, String expectedName, String expectedCod) {

        LinksPage linksPage = openBaseURL()
                .clickElementsMenu()
                .openLinksPage();

        linksPage.clickLinks(index);

        String actualCod = linksPage.getResponseCode();
        String actualName = linksPage.getResponseName();

        Assert.assertEquals(actualCod, expectedCod);
        Assert.assertEquals(actualName, expectedName);
    }
}

