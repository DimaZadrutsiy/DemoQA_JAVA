package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.SelectablePage;

public class SelectableTest extends BaseTest {

    @Test
    public void testNavigationSelectablePage() {
        final String expectedUrl = "https://demoqa.com/selectable";
        final String expectedTitle = "ToolsQA";
        final String expectedHeader = "Selectable";
        final String expectedBasedURL = "https://demoqa.com/";

        SelectablePage selectablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSelectablePage();

        String actualUrl = selectablePage.getCurrentURL();
        String actualTitle = selectablePage.getTitle();
        String actualHeader = selectablePage.getH2Header();

        Assert.assertNotEquals(actualUrl, expectedBasedURL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
